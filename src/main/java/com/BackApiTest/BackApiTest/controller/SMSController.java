package com.BackApiTest.BackApiTest.controller;




import com.BackApiTest.BackApiTest.service.SMSService;
import com.BackApiTest.BackApiTest.entity.SMS;

import com.twilio.rest.api.v2010.account.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/sms")
@CrossOrigin
public class SMSController {

    @Autowired
    SMSService service;

    @GetMapping()
    public List<SMS> getAll() {
        return service.getAll();
    }

    @PostMapping()
    public Message smsSubmit() {
        return service.send();
    }

    @PostMapping("/smsback")
    public void smsCallback(@RequestBody MultiValueMap<String, String> map) {
        service.receive(map);
    }

    private String getTimeStamp() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
    }
}