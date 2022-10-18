package com.wj.confirmation;

import com.wj.clients.confirmation.ConfirmationCheckResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/confirmation")
public class ConfirmationController {

    @PostMapping(path = "/confirm")
    public void confirm(@RequestBody ConfirmationCheckResponse confirmationResponse){
        if(confirmationResponse.confirmed()) log.info("Registration has been successful");
        else log.info("Registration failed.");
    }
}
