package com.login.jdbclogin.CustomerKycStatus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/kyc-statuses")


public class CustomerKycStatusController {
    private static Logger log= LoggerFactory.getLogger(CustomerKycStatusController.class);

    @Autowired
    CustomerKycStatusService customerKycService;

    @PostMapping("/customers-kyc-status")

    public ResponseEntity<?> customerKycStatus(@RequestBody @Valid CustomerKycStatusModel payload) {


        return customerKycService.getCustomerKycStatus(payload);
    }
}
