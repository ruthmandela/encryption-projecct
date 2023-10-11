package com.login.jdbclogin.CustomerKycTermination;

import com.google.gson.Gson;
import com.login.jdbclogin.CustomerKycStatus.SharedResponsesModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service

public class CustomerKycTerminationService {
    static final Logger log= LoggerFactory.getLogger(CustomerKycTerminationService.class);
    @Autowired
    AmqpTemplate amqpTemplate;
    @Autowired
    RabbitMQConfiguration rabbitConfig;
    @Autowired
    CustomerKycTerminationHandler customerKycTerminationHandler;
    public ResponseEntity<?> kycTermination(CustomerKycTerminationModel payload){
        SharedResponsesModel responsesModel;
        CustomerKycQueueModel resp=null;
        try{
            int count=customerKycTerminationHandler.count(payload.getRequestId());
            if(count==0){
                return ResponseEntity.badRequest().body(new SharedResponsesModel(400,"Request Id does not exist"));
            }
            if(customerKycTerminationHandler.kycTermination(payload)){
               resp=customerKycTerminationHandler.retrieveNationalId(payload.getRequestId());
                System.out.println("get this here"+resp.getNationalId()+":"+resp.getAppCode());
                String fullfilment = new Gson().toJson(new CustomerKycQueueModel(resp.getNationalId(),resp.getAppCode()));
               System.out.println("get this here"+fullfilment);
               amqpTemplate.convertAndSend(rabbitConfig.bindFullfilmentQueue().getExchange(),
                      rabbitConfig.bindFullfilmentQueue().getRoutingKey(), fullfilment);
                return ResponseEntity.ok().body(new SharedResponsesModel(200,"Request Executed succesfully"));
            }else{
                return ResponseEntity.badRequest().body(new SharedResponsesModel(400,"RequestId does not exist"));
            }

        }catch(Exception el){
            el.printStackTrace();
            return ResponseEntity.badRequest().body(new SharedResponsesModel(400,"Request failed to execute"));
        }

    }
}
