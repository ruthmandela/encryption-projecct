package com.login.jdbclogin.Registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/createUser")
public class RegistrationController {
    @Autowired
    RegistrationService registrationService;
    @PostMapping ()
    public ResponseEntity<?>createProfile(@RequestBody RegistrationModel payload){
        return registrationService.saveUser(payload);
    }
}
