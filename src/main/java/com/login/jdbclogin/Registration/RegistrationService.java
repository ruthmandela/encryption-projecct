package com.login.jdbclogin.Registration;

import com.login.jdbclogin.CommonCodes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    @Autowired
    CommonCodes commonCodes;
    @Autowired
    RegistrationRepository registrationRepository;


    public ResponseEntity<?>saveUser(RegistrationModel payload){
        try{
            String password=commonCodes.encryptPassword(payload.getPassword());
            payload.getName();
            payload.getEmail();
            payload.getUsername();
            payload.setPassword(password);
            registrationRepository.save(payload);
            return ResponseEntity.ok(new ResponseModel("200","Request executed  successfully"));


        }catch(Exception el){
            el.printStackTrace();
            return ResponseEntity.badRequest().body(new ResponseModel("400","Request failed to execute"));
        }
    }
}
