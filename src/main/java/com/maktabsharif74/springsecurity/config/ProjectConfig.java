package com.maktabsharif74.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();

        UserDetails userDetails = User
                .withUsername("mohsen")
                .password("123456")
                .authorities("read").build();

        userDetailsManager.createUser(userDetails);

        auth.userDetailsService(userDetailsManager);*/

        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().hasAuthority("read");
        http.formLogin();
        http.httpBasic();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();

        UserDetails mohsen = User
                .withUsername("mohsen")
                .password("123456")
                .authorities("read").build();

        userDetailsManager.createUser(mohsen);

        UserDetails mehrshad = User
                .withUsername("mehrshad")
                .password("123456")
                .authorities("write").build();

        userDetailsManager.createUser(mehrshad);

        return userDetailsManager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        return new MyAuthenticationProvider(
                userDetailsService(),
                passwordEncoder()
        );
    }
}
