package com.login.jdbclogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
@Component


public class CommonCodes {
    @Autowired
    Environment env;
    public String encryptPassword(String crmID){
        try {
            String key=env.getProperty("key");
            String initVector=env.getProperty("initVector");
            IvParameterSpec iv = new IvParameterSpec(env.getProperty("key").getBytes("UTF-8"));
            // IvParameterSpec iv = new IvParameterSpec(env.getProperty("key").getBytes(StandardCharsets.US_ASCII));
            System.out.println("get this keys"+key);
            SecretKeySpec skeySpec = new SecretKeySpec(env.getProperty("initVector").getBytes("UTF-8"), "AES");
            System.out.println("get this salt herercvbnm"+initVector.getBytes());

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);


            byte[] encryptedMessageBytes =
                    cipher.doFinal(crmID.getBytes());
            String encryptedMessage =
                    Base64.getEncoder().encodeToString(encryptedMessageBytes);
            System.out.println("Encrypted message = " + encryptedMessage);
            return encryptedMessage;
        }catch(Exception el){
            el.printStackTrace();
            return "";
        }


    }


}
