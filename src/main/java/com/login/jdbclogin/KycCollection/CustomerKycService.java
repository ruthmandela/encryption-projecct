package com.login.jdbclogin.KycCollection;

import com.login.jdbclogin.CustomerKycStatus.SharedResponsesModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service

public class CustomerKycService {

    @Autowired
    CustomerKycHandler helper;
    public ResponseEntity<?> customerCompleteKyc(CustomerKycRequestModel payload){
        try{


            try {
                CustomerContactModel model=payload.getCustomerContactInfo();
                String physicalAddress=model.getPhysicalAddress();
                helper.updateCustomerKycData(payload);
            }catch(Exception e){

            }

            try {
                CustomerProductSelectionModel model=payload.getCustomerProductSelection();
                String product=model.getProductCode();
                helper.customerProductSelection(payload);
            }catch(Exception e){

            }

            try {
                CustomerFatcaModel model=payload.getCustomerFatca();
               String ssf= model.getSocialSecurityNumber();
                helper.saveCustomerFatca(payload);
            }catch(Exception e){

            }

            try {
                CustomerEmergencyContactModel res= payload.getCustomerEmergencyContactInfo();
                String name=res.getName();
                helper.saveCustomerEmergencyContact(payload);
            }catch(Exception e) {

            }

            try {
                CustomerContactModel model= payload.getCustomerContactInfo();
                String town=model.getTown();
                helper.saveCustomerContactInfo(payload);
            }catch(Exception e){

            }

            return ResponseEntity.ok().body(new SharedResponsesModel(200,"Request executed succesfully"));
        }catch(Exception el){
            el.printStackTrace();

            return ResponseEntity.internalServerError().body(new SharedResponsesModel(400,"Request failed to execute"));
        }

    }

}
