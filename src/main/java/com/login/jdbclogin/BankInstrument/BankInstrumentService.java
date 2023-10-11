package com.login.jdbclogin.BankInstrument;

import com.login.jdbclogin.CustomerKycStatus.SharedResponsesModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service

public class BankInstrumentService {
    @Autowired
    BankInstrumentHandler bankInstrumentHandler;
    public ResponseEntity<?>addInstrument(String model){
        try{

            if(bankInstrumentHandler.orderCard(model)){
                return ResponseEntity.ok().body(new SharedResponsesModel(200,"instrument saved succesfully"));

            }else{
                return ResponseEntity.ok().body(new SharedResponsesModel(400,"could not save instruments"));
            }



        }catch(Exception el){
            el.printStackTrace();
            return ResponseEntity.ok().body(new SharedResponsesModel(400,"could not save instruments"));
        }
    }
}
