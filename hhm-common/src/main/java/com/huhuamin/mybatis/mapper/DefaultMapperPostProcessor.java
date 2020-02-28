package com.huhuamin.mybatis.mapper;

import com.huhuamin.req.ReqComm;
import com.huhuamin.req.json.result.JsonResult;
import com.huhuamin.validate.CommonValidate;
import org.springframework.util.StringUtils;

/**
 * @Auther: Huhuamin
 * @Date: 2020/2/28 11:41
 * @Description: 默认实现 增加 设备号校验
 */
public class DefaultMapperPostProcessor implements MapperPostProcessor {
    /**
     * 默认实现 校验设备号
     *
     * @param reqComm
     * @param jsonResult
     * @return
     */
    @Override
    public JsonResult postProcessorBefore(ReqComm reqComm, JsonResult jsonResult) {
        boolean hasCheck = CommonValidate.checkDeviceId(reqComm);
        if (hasCheck) {
            if (StringUtils.isEmpty(reqComm.getDeviceId())) {
                jsonResult.setStatusCode(false);
                return jsonResult;
            }
        }
        jsonResult.setStatusCode(true);
        return jsonResult;
    }

    @Override
    public JsonResult postProcessorAfter(ReqComm reqComm, JsonResult jsonResult) {
        return null;
    }
}
