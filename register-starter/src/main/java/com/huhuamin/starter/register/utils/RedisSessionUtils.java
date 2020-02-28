package com.huhuamin.starter.register.utils;


import com.huhuamin.execption.HuhuaminException;
import com.huhuamin.jedis.distributed.lock.service.JedisService;
import com.huhuamin.req.constants.HhmConstants;
import com.huhuamin.req.json.result.JsonResult;
import org.apache.commons.lang3.StringUtils;


/**
 * @author 胡化敏(huhuamin)
 * @email 175759041@qq.com
 * @date 2018/5/31 下午5:07
 */
public class RedisSessionUtils {

    /**
     * 验证发送验证码
     *
     * @param jsonResult
     * @param jedisService
     * @return
     */
    public static JsonResult handleSesseionValid(String phone, JsonResult jsonResult, JedisService jedisService, boolean off_line, String codyTpye) {
        if (off_line) {
            jsonResult.setStatusCode(true);
            return jsonResult;
        }
        jsonResult.setStatusCode(false);
        String serverTarget = jedisService.getValueByKey(codyTpye.concat(phone).concat(HhmConstants.TARGET_NUMBER));
        if (StringUtils.isBlank(serverTarget)) {
            jsonResult.setMessage("验证码未发送或无效，请重新发送");
            return jsonResult;
        }
        jsonResult.setStatusCode(true);
        return jsonResult;
    }

    /**
     * 验证码校验 session 处理
     *
     * @param phone
     * @param phoneCode
     * @param jedisService
     * @return
     */
    public static JsonResult handlerPhone(String phone, String phoneCode, JedisService jedisService, String codeType, boolean off_line) {
        try {
            JsonResult jsonResult = new JsonResult(false);

            String serverPhone = jedisService.getValueByKey(codeType.concat(phone).concat(HhmConstants.TARGET_NUMBER));
            if (StringUtils.isEmpty(serverPhone)) {
                jsonResult.setMessage("手机号验收码超时");
                jsonResult.setStatusCode(false);
                return jsonResult;
            }
            //session有没有过期判断
            handleSesseionValid(phone, jsonResult, jedisService, off_line, codeType);
            if (!jsonResult.getStatusCode()) {
                return jsonResult;
            }

            String serverPhoneCode = jedisService.getValueByKey(codeType.concat(phone).concat(HhmConstants.VALID_CODE));
            if (StringUtils.isBlank(serverPhoneCode)) {
                jsonResult.setStatusCode(false);
                jsonResult.setMessage("验证码未发送或无效，请重新发送");
                return jsonResult;
            }
            if (off_line) {
                if (!"888888".equalsIgnoreCase(phoneCode)) {
                    jsonResult.setStatusCode(false);
                    jsonResult.setMessage("验证码不正确");
                    return jsonResult;
                }
            } else if (!serverPhoneCode.equalsIgnoreCase(phoneCode)) {
                jsonResult.setStatusCode(false);
                jsonResult.setMessage("验证码不正确");
                return jsonResult;
            }
            if (!serverPhone.equalsIgnoreCase(phone)) {
                jsonResult.setStatusCode(false);
                jsonResult.setMessage("手机号内容被篡改");
                return jsonResult;
            }

            return jsonResult;
        } catch (Exception e) {
            throw new HuhuaminException("验证码校验", e);
        }
    }
}
