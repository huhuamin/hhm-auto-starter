package com.huhuamin.starter.sms.exteral.alibaba;


import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.huhuamin.starter.sms.Sms;
import com.huhuamin.starter.sms.exteral.yzx.sdk.ReqSendMessage;

/**
 * @Auther: Huhuamin
 * @Date: 2019/3/26 16:42
 * @Description: 阿里云发送短信
 */
public class AlibabaSmsClient implements Sms {
    private IAcsClient client;

    public AlibabaSmsClient(AlibabaSmsProperties alibabaSmsProperties) {
        DefaultProfile profile = DefaultProfile.getProfile(alibabaSmsProperties.getRegionId(), alibabaSmsProperties.getAccessKeyId(), alibabaSmsProperties.getSecret());
        this.client = new DefaultAcsClient(profile);
    }

    public AlibabaSmsClient() {
    }

    public String sendSms(ReqSendMessage reqSendMessage) {
        CommonRequest request = new CommonRequest();
        //request.setProtocol(ProtocolType.HTTPS);
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("PhoneNumbers", reqSendMessage.getTarget());
        request.putQueryParameter("TemplateCode", reqSendMessage.getContentTempLate());
        request.putQueryParameter("TemplateParam", "{\"code\":" + reqSendMessage.getParams() + "}");
        request.putQueryParameter("SignName", "搂圈");
        try {
            CommonResponse response = client.getCommonResponse(request);
            return response.getData();
        } catch (ServerException e) {
            e.printStackTrace();
            return "error";
        } catch (ClientException e) {
            e.printStackTrace();
            return "error";
        }
    }


}
