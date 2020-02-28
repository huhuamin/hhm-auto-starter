package com.huhuamin.aop;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.huhuamin.jedis.distributed.lock.service.JedisService;
import com.huhuamin.req.ReqCommIf;
import com.huhuamin.req.ReqToken;
import com.huhuamin.req.ReqTokenIf;
import com.huhuamin.result.JsonResult;
import com.huhuamin.result.PageJsonResult;
import com.huhuamin.result.TypeJsonResult;
import com.huhuamin.starter.register.dao.mapper.CustomerMapper;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author 胡化敏
 * @Description:
 * @Date Create 2017/11/22 14:17
 * @Modified By:
 * @Since:
 */
@Aspect
@Component
@Order(1)
public class JsonBindResult {
    private final Logger logger = LoggerFactory.getLogger(JsonBindResult.class);
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private JedisService jedisService;


    @Around("@annotation(com.huhuamin.annotation.ReqCommonValidate) && args(..,reqSource,bindingResult)")
    public Object doAround(ProceedingJoinPoint pjp, Object reqSource, BindingResult bindingResult) throws Throwable {
        Object retVal;
        HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        JSONObject jsonObject = (JSONObject) JSON.toJSON(reqSource);
        logger.info(pjp.getSignature().getName() + "||" + req.getRequestURI() + "||" + jsonObject);
//        String signStr = sortDict(jsonObject);
//        String sign = DigestUtils.md5Hex(signStr);
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();

        Class<?> returnType = methodSignature.getReturnType();
//        if (!jsonObject.get("sign").toString().equalsIgnoreCase(sign)) {
//            return doErrorHandle("签名错误", returnType);louquanapp
//        }

        if (reqSource instanceof ReqTokenIf) {//登录不登录都可以的判断
            ReqTokenIf reqTokenIf = (ReqTokenIf) reqSource;
            JsonResult jsonResult = new JsonResult();
            if (!StringUtils.isEmpty(reqTokenIf.getToken())) {
                boolean die = checkDie(reqTokenIf.getToken(), jsonResult);
                if (die) {
                    return doErrorHandle(jsonResult.getMessage(), jsonResult.getCode(), returnType);
                } else {
                    reqTokenIf.setTokenCustId(jsonResult.getExtra());//tokencustId 存在extral
                }
            }
        }
        if (reqSource instanceof ReqCommIf) {//登录不登录都可以的判断
            ReqCommIf reqCommIf = (ReqCommIf) reqSource;
            JsonResult jsonResult = new JsonResult();
            if (!StringUtils.isEmpty(reqCommIf.getToken())) {
                boolean die = checkDie(reqCommIf.getToken(), jsonResult);
                if (die) {
                    return doErrorHandle(jsonResult.getMessage(), jsonResult.getCode(), returnType);
                } else {
                    reqCommIf.setTokenCustId(jsonResult.getExtra());//tokencustId 存在extral
                }
            }
        }
        if (reqSource instanceof ReqToken) {//必须登录判断
            ReqToken reqToken = (ReqToken) reqSource;
            JsonResult jsonResult = new JsonResult();
            boolean die = checkDie(reqToken.getToken(), jsonResult);
            if (die) {
                return doErrorHandle(jsonResult.getMessage(), jsonResult.getCode(), returnType);
            } else {
                reqToken.setTokenCustId(jsonResult.getExtra());//tokencustId 存在extral
            }
        }
        if (null != bindingResult && bindingResult.hasErrors()) {
            retVal = doErrorHandle(bindingResult.getAllErrors().get(0).getDefaultMessage(), null, returnType);
        } else {
            retVal = pjp.proceed();
        }
        return retVal;
    }

    /**
     * 登录鉴权
     *
     * @param token
     * @param jsonResult
     * @return
     */
    private boolean checkDie(String token, JsonResult jsonResult) {
        String custId = jedisService.getCustIdByToken(token);
        if (StringUtils.isEmpty(custId)) {
            jsonResult.setStatusCode(false);
            jsonResult.setMessage("token过期，重新登录");
            jsonResult.setCode(301);
            return true;
        }
        if (custId.equalsIgnoreCase("303")) {
            jsonResult.setStatusCode(false);
            jsonResult.setMessage("账户在其他设备登录!");
            jsonResult.setCode(303);
            return true;

        }
        Byte freezeStatue = customerMapper.selectFreezeStatusByCustId(custId);
        if (null != freezeStatue && freezeStatue.intValue() == 3) {
            // 未查询到账号
            jsonResult.setStatusCode(false);
            jsonResult.setCode(304);
            jsonResult.setMessage("无使用权限，注:您的使用权限已被冻结，请联系客服");
            return true;
        }
        jsonResult.setExtra(custId);

        return false;
    }

    private Object doErrorHandle(String msg, Integer code, Class returnType) {
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        response.setCharacterEncoding("UTF-8");
        response.setStatus(HttpServletResponse.SC_OK);
        //response.setHeader("Content-Type", "application/json;charset=UTF-8");
        response.setContentType("application/json;charset=UTF-8");

        if (returnType.getName().equals("com.huhuamin.result.PageJsonResult")) {
            PageJsonResult<Object> pageJsonResult = new PageJsonResult<>();
            pageJsonResult.setStatusCode(false);
            pageJsonResult.setMessage(msg);
            if (null != code) {
                pageJsonResult.setCode(code);
            }
            return pageJsonResult;
        }

        if (returnType.getName().equals("com.huhuamin.result.TypeJsonResult")) {
            TypeJsonResult<Object> typeJsonResult = new TypeJsonResult<>();
            typeJsonResult.setStatusCode(false);
            typeJsonResult.setMessage(msg);
            if (null != code) {
                typeJsonResult.setCode(code);
            }
            return typeJsonResult;
        }
        JsonResult jsonResult = new JsonResult(false);
        if (null != code) {
            jsonResult.setCode(code);
        }
        jsonResult.setMessage(msg);
        return jsonResult;
    }


}


