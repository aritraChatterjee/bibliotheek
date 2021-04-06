package com.bibliotheek.security.filter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AasFilterTest {


    @Mock
    FilterChain chain;

    @InjectMocks
    AasFilter aasFilter;

    @Test
    void doFilterWhenRequestIsValid() throws IOException, ServletException {

        // mock HttpServletRequest
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        createRequestMockWithValidHeaderNames(request);

        aasFilter.doFilter(request, response, chain);

        verify(chain, times(1)).doFilter(request, response);

    }

    @Test
    void doFilterWhenRequestIsNotValid() throws IOException, ServletException {
        // mock HttpServletRequest
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        createRequestMockWithInvalidHeaderNames(request);
        aasFilter.doFilter(request, response, chain);

        verify(response, times(1)).sendError(403);

    }

    private Map<String, String> createRequestMockWhenValid() {

        // define the headers you want to be returned
        Map<String, String> headers = new HashMap<>();
        headers.put("aa_name", "John");
        headers.put("aa_role", "Admin");
        headers.put("aa_email", "abc@gmail.com");

        return headers;
    }

    private Map<String, String> createRequestMockWhenInvalid() {
        // define the headers you want to be returned
        Map<String, String> headers = new HashMap<>();
        headers.put("aa_name", "John");

        return headers;
    }

    private void createRequestMockWithValidHeaderNames(HttpServletRequest request) {

        Map<String, String> headers = createRequestMockWhenValid();
        // create an Enumeration over the header keys
        Enumeration<String> headerNames = Collections.enumeration(headers.keySet());

        // mock the returned value of request.getHeaderNames()
        when(request.getHeaderNames()).thenReturn(headerNames);

    }

    private void createRequestMockWithInvalidHeaderNames(HttpServletRequest request) {

        Map<String, String> headers = createRequestMockWhenInvalid();
        // create an Enumeration over the header keys
        Enumeration<String> headerNames = Collections.enumeration(headers.keySet());

        // mock the returned value of request.getHeaderNames()
        when(request.getHeaderNames()).thenReturn(headerNames);

    }

}