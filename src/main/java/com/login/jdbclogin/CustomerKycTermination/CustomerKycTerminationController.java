package com.login.jdbclogin.CustomerKycTermination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("authentication")
public class CustomerKycTerminationController {
    @Autowired
    CustomerKycTerminationService customerKycTerminationService;

    @PostMapping(value = "/customers-kyc-termination", consumes = {"application/json"},produces = {"application/json"})
    public ResponseEntity<?> customerKycTermination(@RequestBody CustomerKycTerminationModel payload){
        return customerKycTerminationService.kycTermination(payload);
    }

}
