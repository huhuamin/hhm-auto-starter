
package com.huhuamin.starter.sms.exteral.sy;


import com.alibaba.fastjson.JSONObject;
import com.huhuamin.starter.sms.exteral.yzx.sdk.HttpClientUtil;

import java.util.HashMap;
import java.util.Map;


public class JsonReqClient {


    public String sendSms(String token, String appid, String templateid, String param, String mobile) {

        String result = "";

        try {
            String url = "https://api.mysubmail.com/message/xsend";

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("appid", appid);
            jsonObject.put("signature", token);
            jsonObject.put("project", templateid);
            jsonObject.put("to", mobile);


            if (null != param && param.length() > 0) {
                String[] arrP = param.split(",");
                Map<String, String> json = new HashMap<>(arrP.length);
                for (int i = 1; i <= arrP.length; i++) {
                    json.put("v" + i, arrP[i - 1]);
                }
                jsonObject.put("vars", JSONObject.toJSONString(json));
            }


            String body = jsonObject.toJSONString();

            System.out.println("body = " + body);

            result = HttpClientUtil.postJson(url, body, null);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
