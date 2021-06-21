package com.bibliotheek.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.bibliotheek.config.OpenApiConfig.API_ROOT;

@Tag(name = "Info", description = "Gives application info")
@RestController
@RequestMapping(API_ROOT + "/info")
public class InfoController {
    @Value("${application.version}")
    private String applicationVersion;

    @GetMapping()
    public ResponseEntity<String> getInfo() {
        return new ResponseEntity<>(applicationVersion, HttpStatus.ACCEPTED);
    }

}
