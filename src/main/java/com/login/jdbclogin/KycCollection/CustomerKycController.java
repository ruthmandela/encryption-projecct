package com.login.jdbclogin.KycCollection;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerKycController {
    private static Logger log= LoggerFactory.getLogger(CustomerKycController.class);
    @Autowired
    CustomerKycService customerKycService;

    @PostMapping(value="/customers-kyc-collection",consumes = { "application/json" }, produces = { "application/json" })
    public ResponseEntity<?> saveCustomerKyc(@RequestBody CustomerKycRequestModel payload){
        log.info("get this payload"+payload);
        return customerKycService.customerCompleteKyc(payload);

    }
}
