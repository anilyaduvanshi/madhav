package com.learn.tavant.config;

import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.AbstractRequestLoggingFilter;


@Order(value = Ordered.HIGHEST_PRECEDENCE)
@Component
@WebFilter(filterName = "RequestCachingFilter", urlPatterns = "/*")
public class MySpringFilter extends AbstractRequestLoggingFilter {

    Logger LOGGER = LoggerFactory.getLogger(MySpringFilter.class);

    @Override
    protected void beforeRequest(HttpServletRequest request, String message) {
        LOGGER.info(" <><><> " + " LOGGING BEFORE REQUEST");
    }

    @Override
    protected void afterRequest(HttpServletRequest request, String message) {
        LOGGER.info(" <><><> " + " LOGGING AFTER REQUEST");
    }
}
