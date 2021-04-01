package com.bibliotheek.api.filter;

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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RequestFilterTest {


    @Mock
    FilterChain chain;

    @InjectMocks
    RequestFilter requestFilter;

    @Test
    void doFilterWhenRequestIsValid() throws IOException, ServletException {

        // mock HttpServletRequest
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        createRequestMockWhenValid(request);

        requestFilter.doFilter(request, response, chain);

        assertEquals("John", request.getHeader("AA_NAME"));
        assertEquals("admin", request.getHeader("AA_ROLE"));
        assertEquals("abc@gmail.com", request.getHeader("AA_EMAIL"));

        verify(chain, times(1)).doFilter(request, response);

    }

    @Test
    void doFilterWhenRequestIsNotValid() throws IOException, ServletException {
        // mock HttpServletRequest
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        createRequestMockWhenInvalid(request);
        requestFilter.doFilter(request, response, chain);

        verify(response, times(1)).sendError(403);

    }

    private void createRequestMockWhenValid(HttpServletRequest request) {
        when(request.getHeader("AA_NAME")).thenReturn("John");
        when(request.getHeader("AA_ROLE")).thenReturn("admin");
        when(request.getHeader("AA_EMAIL")).thenReturn("abc@gmail.com");
    }

    private void createRequestMockWhenInvalid(HttpServletRequest request) {
        when(request.getHeader("AA_NAME")).thenReturn("John");
    }


}