package com.example.knockknock.user.phoneAuth;

import com.example.knockknock.ignore;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

import java.util.HashMap;

public class CoolMessage {
    private Message coolSMS = new Message(ignore.SMS_API_KEY,ignore.SMS_API_SECRET_KEY);

    public void sendSMS(String phoneNumber, String code) throws CoolsmsException {
        HashMap<String,String> params = new HashMap<String,String>();
        params.put("to",phoneNumber);
        params.put("from","01027765098");
        params.put("type","SMS");
        params.put("text","[KnockKnock] 인증번호는 ["+ code +"] 입니다.");

        coolSMS.send(params);
    }
}
