package com.huhuamin.jedis.distributed.lock.service;


import org.apache.commons.lang3.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;


/**
 * @Auther: Huhuamin
 * @Date: 2019年03月26日15:19:58
 * @email:175759041@qq.com
 * @Description: redis 业务处理
 */
public class JedisService {
    /*防止公用一个系统,数据库备注*/
    private String DB_PREFIX = "hhm_";

    private final JedisPool jedisPool;
    /**
     * 默认7天
     */
    private final int EXPIRE_SECOND = 60 * 60 * 24 * 7;

    public JedisService(JedisPool jedisPool, String dbPrefix) {
        this.jedisPool = jedisPool;
        this.DB_PREFIX = dbPrefix;
    }

    public JedisService(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }


    public String acquireLock(String lockName) {
        return acquireLock(lockName, 7000, 25000);
    }

    /**
     * @param lockName       锁名称
     * @param acquierTimeout 获得或超时时间 毫秒
     * @param lockTimeout    锁的过期时间  毫秒
     * @return
     */
    public String acquireLock(String lockName, long acquierTimeout, long lockTimeout) {
        Jedis jedis = null;
        String result = null;
        try {
            String identifier = UUID.randomUUID().toString();//释放锁的时候持有者校验
            String key = DB_PREFIX + "lock:" + lockName;
            jedis = jedisPool.getResource();

            int lockExpire = (int) lockTimeout / 1000;//锁秒数
            long end = System.currentTimeMillis() + acquierTimeout;
            while (System.currentTimeMillis() < end) {//阻塞
                if (jedis.setnx(key, identifier) == 1) {//设置超时时间
                    jedis.expire(key, lockExpire);
                    //锁设置成功，redis操作成功
                    result = identifier;
                    break;
                }
                if (jedis.ttl(key) == -1) { //检测过期时间
                    jedis.expire(key, lockExpire);
                }
                Thread.sleep(300);//睡眠时间
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedis.close();
        }
        return result;
    }

    /**
     * @param lockName
     * @param identifier
     * @return
     */
    public boolean releaseLock(String lockName, String identifier) {
        Jedis jedis = null;
        Boolean isRelease = false;
        try {
            String key = DB_PREFIX + "lock:" + lockName;
            jedis = jedisPool.getResource();
            while (true) {
                jedis.watch(key);  //watch
                if (identifier.equals(jedis.get(key))) { //判断获得锁的线程和当前redis中存的锁是同一个
                    Transaction transaction = jedis.multi();
                    transaction.del(key);
                    List<Object> list = transaction.exec();
                    if (list == null || list.isEmpty()) {
                        continue;
                    }
                    isRelease = true;
                } else {
                    isRelease = false;
                }
                jedis.unwatch();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedis.close();
        }
        return isRelease;
    }


    public void setKeyValue(String key, String value, Integer sec) {
        Jedis jedis = null;
        try {
            key = DB_PREFIX + key;
            jedis = jedisPool.getResource();
            if (null == sec) {
                jedis.setex(key, EXPIRE_SECOND, value);
            } else {
                jedis.setex(key, sec, value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedis.close();
        }
    }


    public String getCustIdByToken(String token) {
        if (StringUtils.isEmpty(token)) {
            return "";
        }
        Jedis jedis = null;
        try {
            String key = token;
            key = DB_PREFIX + key;
            jedis = jedisPool.getResource();
            String curCustId = jedis.get(key);
            if (StringUtils.isEmpty(curCustId)) {
                return "";
            }
            String curToken = jedis.get(DB_PREFIX + curCustId);
            if (!curToken.equalsIgnoreCase(token)) {
                return "303";
            } else {
                return curCustId;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedis.close();
        }
        return "";
    }

    public String getValueByKey(String key) {
        Jedis jedis = null;
        try {
            key = DB_PREFIX + key;
            jedis = jedisPool.getResource();
            return jedis.get(key);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedis.close();
        }
        return "";
    }

    public void delByKey(String key) {
        Jedis jedis = null;
        try {
            key = DB_PREFIX + key;
            jedis = jedisPool.getResource();
            jedis.del(key);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedis.close();
        }

    }

//    public void refreshCustToken(String custId, String token) {
//
//        SocketJson socketJson = new SocketJson();
//        socketJson.setCustType(3);
//        socketJson.setFormType("otherLogin");
//        socketJson.setType("其他设备登录");
//        WebSocket.sendMessageCustId(custId, JSON.toJSONString(socketJson));
//        setKeyValue(token, custId, null);
//        setKeyValue(custId, token, null);
//
//    }


    public void setKeyValueToDay(String key, String value) {
        Date now = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);


        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(now);
        Long dif = calendar.getTimeInMillis() - calendar2.getTimeInMillis();
        int sec = (int) (dif / 1000);
        setKeyValue(key, value, sec);
    }

}
