package com.bibliotheek.api.filter;

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

/**
 * The filter type for request.
 */
public class RequestFilter implements Filter {

    /**
     * The Constant logger.
     */
    private static final Logger logger = LoggerFactory.getLogger(RequestFilter.class);

    @Override
    public void init(FilterConfig filterConfig) {
        logger.info("Initializing filter :{}", this);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        logger.info("Logging Request received");

        String name = req.getHeader("AA_NAME");
        String role = req.getHeader("AA_ROLE");
        String email = req.getHeader("AA_EMAIL");

        if (name != null && role != null && email != null) {
            logger.info("This request is valid, proceed with the request. ");

            chain.doFilter(req, res);

            logger.info("Logging Response");

        } else {
            logger.warn("This request is not valid. ");
            res.sendError(HttpServletResponse.SC_FORBIDDEN);
        }


    }

    @Override
    public void destroy() {
        logger.warn("Destructing filter :{}", this);
    }


}
