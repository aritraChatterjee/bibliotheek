package com.bibliotheek.api.filter;

import com.bibliotheek.exception.CustomRuntimeException;
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

        logger.info("Logging Request  {} : {}", req.getMethod(), req.getRequestURI());

        String name = req.getHeader("name");
        String role = req.getHeader("role");
        String email = req.getHeader("email");

        if (name != null && role != null && email != null) {
            logger.info("This request is valid, proceed with the request. ");

            chain.doFilter(req, res);

            logger.info("Logging Response :{}", res.getContentType());

        } else {
            logger.warn("This request is not valid. ");
            throw new CustomRuntimeException.ForbiddenException();
        }


    }

    @Override
    public void destroy() {
        logger.warn("Destructing filter :{}", this);
    }


}
