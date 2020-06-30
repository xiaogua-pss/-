package com.xg.utils;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

public class SmsSender {

        public static boolean sendSms(String code, String phone) {
            DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4G6mzr3u1aY4dkxgkR6W", "DLHkaufBADoYbgiLhtGQjsHia03ZYj");
            IAcsClient client = new DefaultAcsClient(profile);
            System.out.println(phone);
            System.out.println(code);
            CommonRequest request = new CommonRequest();
            request.setMethod(MethodType.POST);
            request.setDomain("dysmsapi.aliyuncs.com");
            request.setVersion("2017-05-25");
            request.setAction("SendSms");

            //设置发送相关的参数
            request.putQueryParameter("RegionId", "cn-hangzhou");
            request.putQueryParameter("PhoneNumbers",phone);//手机号
            request.putQueryParameter("SignName", "传智健康");//申请阿里云的标签名
            request.putQueryParameter("TemplateCode", "SMS_193239281");//申请阿里云的模板
            request.putQueryParameter("TemplateParam", "{'code':'" + code + "'}");//发送的验证码
            try {
                CommonResponse response = client.getCommonResponse(request);
                System.out.println(response.getData());
                boolean success = response.getHttpResponse().isSuccess();
                return success;
            } catch (ClientException e) {
                e.printStackTrace();
                return false;
            }
        }
}
