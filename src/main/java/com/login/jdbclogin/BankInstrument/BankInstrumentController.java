package com.login.jdbclogin.BankInstrument;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/onboarding")
public class BankInstrumentController {
    @Autowired
    BankInstrumentService service;

    @RequestMapping("/v1/instruments")
    public ResponseEntity<?>backInstrument(@RequestBody @Valid String payload){
        System.out.println("get this here" +payload);
        System.out.println("get this cheque" +payload);
        return service.addInstrument(payload);

    }

}
