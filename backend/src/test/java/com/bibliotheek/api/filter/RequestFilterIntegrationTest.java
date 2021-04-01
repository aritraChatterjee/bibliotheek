package com.bibliotheek.api.filter;

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
public class RequestFilterIntegrationTest {

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
    void isRequestValidWhenPost() {

        final String uri = "http://localhost:" + randomServerPort + "/v1/info";

        HttpHeaders headers = new HttpHeaders();
        addHeadersWhenValid(headers);
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(uri, entity, String.class);
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());

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
        headers.add("AA_NAME", "John");
        headers.add("AA_ROLE", "Admin");
        headers.add("AA_EMAIL", "abc@gmail.com");

    }

    private void addHeadersWhenInvalid(HttpHeaders headers) {
        headers.add("AA_NAME", "John");

    }

}
