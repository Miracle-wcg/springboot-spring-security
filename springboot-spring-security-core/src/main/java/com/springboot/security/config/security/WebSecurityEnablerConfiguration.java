package com.springboot.security.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @Author: chengang.wu
 * @Date: 2019-12-20 16:46
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityEnablerConfiguration {


    @Configuration
    public static class CustomSecurityConfig extends WebSecurityConfigurerAdapter {
        @Autowired
        @Qualifier("databaseUserDetailService")
        private DatabaseUserDetailService userDetailsService;
        @Autowired
        @Qualifier("authenticationSuccessHandler")
        private AuthenticationSuccessHandler successHandler;

        @Autowired
        @Qualifier("authenticationFailHandler")
        private AuthenticationFailHandler failHandler;

        @Autowired
        @Qualifier("authenticationEntryPointImpl")
        private AuthenticationEntryPoint entryPoint;

        @Bean
        public JwtAuthenticationFilter getJwtAuthenticationFilter() {
            return new JwtAuthenticationFilter();
        }

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http.addFilterBefore(getJwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and().csrf().disable()
                    .authorizeRequests()
                    .antMatchers("/v2/api-docs/**").permitAll()
                    .anyRequest().authenticated()
                    .and().formLogin().loginProcessingUrl("/api/login")
                    .successHandler(successHandler)
                    .failureHandler(failHandler)
                    .and().exceptionHandling().authenticationEntryPoint(entryPoint);
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDetailsService);
        }
    }
}
