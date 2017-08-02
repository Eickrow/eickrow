package com.web.configuration;

import org.springframework.core.annotation.Order;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

@Order(3)
public class WebSecurityInitializer extends AbstractSecurityWebApplicationInitializer {
    protected boolean enableHttpSessionEventPublisher() {
        return true;
    }
}