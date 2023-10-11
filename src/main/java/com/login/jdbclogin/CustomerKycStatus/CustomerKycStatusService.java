package com.login.jdbclogin.CustomerKycStatus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service

public class CustomerKycStatusService {
    static final Logger log= LoggerFactory.getLogger(CustomerKycStatusService.class);
    @Autowired
    CustomerKycStatusHandler customerKycStatusHandler;
    public ResponseEntity<?> getCustomerKycStatus(CustomerKycStatusModel payload){
        HashMap<Object,Object>map;
        log.info("get this here{}"+payload.getIdentificationNumber(),payload.getLegalIdType());
        SharedResponsesModel responsesModel;
        int res;
        try{








            CustomerKycResponse kycStatus=customerKycStatusHandler.customerKycStatus(payload);


           return  ResponseEntity.ok().body
                    (new SharedResponsesModel(200,"Request executed successfully",kycStatus.getKycStatus()));
        }catch(Exception el){
            el.printStackTrace();
            return ResponseEntity.badRequest().body(new SharedResponsesModel(400,"Request failed execute"));
        }
    }
}
