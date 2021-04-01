package com.bibliotheek.api.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The version v1 of the controller make use of the service pattern
 */
@RestController
@RequestMapping("/v1")
public class InfoController {

    @Value("${application.version}")
    private String applicationVersion;


    @GetMapping(value = "/info")
    public ResponseEntity<String> getInfo() {
        return new ResponseEntity<>(applicationVersion, HttpStatus.ACCEPTED);
    }


}
