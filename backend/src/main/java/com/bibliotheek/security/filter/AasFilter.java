package com.bibliotheek.security.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * The filter is used in authentication by checking if the authentication headers are present.
 */
public class AasFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(AasFilter.class);

    // http header names are case insensitive
    private final List<String> aasHeaders = Arrays.asList("aa_name", "aa_role", "aa_email");

    @Override
    public void init(FilterConfig filterConfig) {
        logger.info("Initializing Aas filter.");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        logger.info("Logging Request received.");

        List<String> receivedHeaders = Collections.list(request.getHeaderNames());

        if (receivedHeaders.containsAll(aasHeaders)) {
            logger.info("This request is valid, proceed with the request.");

            chain.doFilter(request, response);

            logger.info("Logging Response.");

        } else {
            logger.warn("This request is not valid.");
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
        }


    }

    @Override
    public void destroy() {
        logger.warn("Destructing Aas filter.");
    }


}
