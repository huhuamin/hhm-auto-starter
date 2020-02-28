package com.huhuamin.utils;

import com.fasterxml.uuid.Generators;
import org.apache.commons.lang3.time.FastDateFormat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * @Author 胡化敏
 * @Description:
 * @Date Create 2017/11/16 13:00
 * @Modified By:
 * @Since:
 */
public class UUIDUtils {
    public static String[] chars = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7",
            "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    public static final FastDateFormat ISO_DATETIME_TIME_ZONE_FORMAT = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss.SSS+0800");
    public static final FastDateFormat ISO_NAME_DATE_ZONE_FORMAT = FastDateFormat.getInstance("yyyy-MM-dd");
    public static final FastDateFormat ISO_NAME_DATE_TIME_NO_FORMAT = FastDateFormat.getInstance("yyyyMMddHHmmss");

    /**
     * 订单号的生成 yyyyMMddHHmmss+8位UUID
     *
     * @return
     */
    public static String generateUuid22() {
        StringBuffer shortBuffer = new StringBuffer();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        for (int i = 0; i < 8; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            shortBuffer.append(chars[x % 0x3E]);
        }
        return ISO_NAME_DATE_TIME_NO_FORMAT.format(new Date()).concat(shortBuffer.toString());


    }


    /**
     * 订单号的生成 yyMMddHHmmss+8位UUID
     *
     * @return
     */
    public static String generateUuid20() {
        StringBuffer shortBuffer = new StringBuffer();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        for (int i = 0; i < 8; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            shortBuffer.append(chars[x % 0x3E]);
        }
        SimpleDateFormat format = new SimpleDateFormat("yyMMddHHmmss");
        return ISO_NAME_DATE_TIME_NO_FORMAT.format(new Date()).concat(shortBuffer.toString());

    }

    public static String genertateUuid32() {
        UUID uuid = Generators.timeBasedGenerator().generate();
        return uuid.toString().replace("-", "");
    }

    public static String genertateUuidLong() {
        UUID uuid = Generators.timeBasedGenerator().generate();
        return String.valueOf(uuid.timestamp());
    }

    /**
     * 8位uuid
     *
     * @return
     */
    public static String generateUuid() {
        StringBuffer shortBuffer = new StringBuffer();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        for (int i = 0; i < 8; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            shortBuffer.append(chars[x % 0x3E]);
        }
        return shortBuffer.toString();
    }

    /**
     * 验证码
     *
     * @return
     */
    public static synchronized String generateValidCode() {
        return String.valueOf((int) ((Math.random() * 9 + 1) * 1000));
    }

    public static synchronized String generateValidCode6() {
        return String.valueOf((int) ((Math.random() * 9 + 1) * 100000));
    }

//    public static void main(String[] args) {
//        System.out.println( UUIDUtils.toSerialCode(1000103L));
//    }


    /**
     * 生成随机字符串
     *
     * @return
     */
    public static String create_nonce_str() {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String res = "";
        for (int i = 0; i < 16; i++) {
            Random rd = new Random();
            res += chars.charAt(rd.nextInt(chars.length() - 1));
        }
        return res;
    }

    /**
     * 自定义进制(0,1没有加入,容易与o,l混淆)
     */
    private static final char[] r = new char[]{'Q', 'W', 'E', '8', 'A', 'S', '2', 'D', 'Z', 'X', '9', 'C', '7', 'P', '5', 'I', 'K', '3', 'M', 'J', 'U', 'F', 'R', '4', 'V', 'Y', 'l', 'T', 'N', '6', 'B', 'G', 'H'};

    /**
     * (不能与自定义进制有重复)
     */
    private static final char b = 'O';

    /**
     * 进制长度
     */
    private static final int binLen = r.length;

    /**
     * 序列最小长度
     */
    private static final int s = 6;

    /**
     * 根据ID生成六位随机码
     *
     * @param id ID
     * @return 随机码
     */
    public static String toSerialCode(long id) {
        char[] buf = new char[32];
        int charPos = 32;

        while ((id / binLen) > 0) {
            int ind = (int) (id % binLen);
            buf[--charPos] = r[ind];
            id /= binLen;
        }
        buf[--charPos] = r[(int) (id % binLen)];
        String str = new String(buf, charPos, (32 - charPos));
        // 不够长度的自动随机补全
        if (str.length() < s) {
            StringBuilder sb = new StringBuilder();
            sb.append(b);
            Random rnd = new Random();
            for (int i = 1; i < s - str.length(); i++) {
                sb.append(r[rnd.nextInt(binLen)]);
            }
            str += sb.toString();
        }
        return str;
    }

    /**
     * 时间戳
     *
     * @return
     */
    public static String create_timestamp() {
        return Long.toString(new Date().getTime());
    }


}
