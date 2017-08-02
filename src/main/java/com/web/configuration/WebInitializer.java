package com.web.configuration;

import ch.qos.logback.ext.spring.web.LogbackConfigListener;
import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

@Order(2)
public class WebInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(javax.servlet.ServletContext servletContext) throws ServletException {
        servletContext.setInitParameter("logbackConfigLocation", "classpath:config/logback.xml");
        servletContext.addListener(LogbackConfigListener.class);
        FilterRegistration.Dynamic encodingFilter = servletContext.addFilter("encoding-filter", CharacterEncodingFilter.class);
        encodingFilter.setInitParameter("encoding", "UTF-8");
        encodingFilter.setInitParameter("forceEncoding", "true");
        encodingFilter.setAsyncSupported(true);
        encodingFilter.addMappingForUrlPatterns(null, true, "/*");
        AnnotationConfigWebApplicationContext mvcContext = new AnnotationConfigWebApplicationContext();
        mvcContext.register(WebConfig.class);
        ServletRegistration.Dynamic EICKROW = servletContext.addServlet("EICKROW", new DispatcherServlet(mvcContext));
        EICKROW.setLoadOnStartup(1);
        EICKROW.addMapping("/");
    }
}
