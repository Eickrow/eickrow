package com.web.configuration;

import com.web.service.security.LoginProcessHandler;
import com.web.service.security.LoginSuccessHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Order(1)
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity webSecurity) throws Exception {
        webSecurity.ignoring()
                .antMatchers("/css/**")
                .antMatchers("/js/**")
                .antMatchers("/fonts/**")
                .antMatchers("/imgs/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/**")
                .hasRole("USER")
                .and()
                .exceptionHandling()
                .accessDeniedPage("/login?msg=accessDenied");
        http.csrf().and().authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin().loginPage("/login").failureUrl("/login?msg=error").loginProcessingUrl("/login_process")
                .usernameParameter("login_user").passwordParameter("login_pwd")
                .successHandler(new LoginSuccessHandler())
                .and()
                .logout().logoutUrl("/logout_process");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(new LoginProcessHandler());
    }
}
