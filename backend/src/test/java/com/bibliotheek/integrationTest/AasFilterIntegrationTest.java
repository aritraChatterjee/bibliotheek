package com.bibliotheek.integrationTest;

import com.bibliotheek.Application;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AasFilterIntegrationTest {

    @Autowired
    TestRestTemplate restTemplate;

    @LocalServerPort
    int randomServerPort;

    @Test
    void isRequestValidWhenGet() {

        final String uri = "http://localhost:" + randomServerPort + "/v1/info";

        HttpHeaders headers = new HttpHeaders();
        addHeadersWhenValid(headers);
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
        Assertions.assertEquals(202, responseEntity.getStatusCodeValue());

    }

    @Test
    void isRequestNotValidWhenGet() {
        final String uri = "http://localhost:" + randomServerPort + "/v1";

        HttpHeaders headers = new HttpHeaders();
        addHeadersWhenInvalid(headers);
        HttpEntity<String> entity = new HttpEntity<>("", headers);

        ResponseEntity<String> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
        Assertions.assertEquals(403, responseEntity.getStatusCodeValue());

    }

    private void addHeadersWhenValid(HttpHeaders headers) {
        headers.add("aa_name", "John");
        headers.add("aa_role", "Admin");
        headers.add("aa_email", "abc@gmail.com");

    }

    private void addHeadersWhenInvalid(HttpHeaders headers) {
        headers.add("aa_name", "John");

    }

}
