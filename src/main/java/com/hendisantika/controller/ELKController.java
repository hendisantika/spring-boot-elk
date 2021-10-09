package com.hendisantika.controller;

import com.hendisantika.service.ELKService;
import com.hendisantika.service.RestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-elk
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 09/10/21
 * Time: 07.43
 */
@RestController
@RequestMapping(value = "/api")
public class ELKController {

    private static final Logger log = LoggerFactory.getLogger(ELKController.class);

    private final ELKService service;

    private final RestService restService;

    public ELKController(ELKService service, RestService restService) {
        this.service = service;
        this.restService = restService;
    }

    @GetMapping(value = "/hello")
    public String helloWorld() {
        log.info("Inside Hello World Function");
        String response = "Hello World! " + new Date();
        log.info("Response => {}", response);
        return response;
    }
}
