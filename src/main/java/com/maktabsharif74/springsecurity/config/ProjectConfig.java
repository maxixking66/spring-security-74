package com.maktabsharif74.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private UserDetailsService userDetailsService;

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

        http.csrf().disable();

        http.authorizeRequests()
                .mvcMatchers("/admin/**").hasRole("ADMIN")
                .and()
                .authorizeRequests().mvcMatchers("/customer/**").hasAnyRole("CUSTOMER", "ADMIN")
                .and()
                .authorizeRequests().anyRequest().authenticated();


        http.formLogin();
        http.httpBasic();
    }

    /*@Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();

        UserDetails mohsen = User
                .withUsername("mohsen")
                .password("123456")
                .authorities("ROLE_ADMIN").build();

        userDetailsManager.createUser(mohsen);

        UserDetails mehrshad = User
                .withUsername("mehrshad")
                .password("123456")
                .authorities("ROLE_CUSTOMER").build();

        userDetailsManager.createUser(mehrshad);

        return userDetailsManager;
    }*/

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        return new MyAuthenticationProvider(
                userDetailsService,
                passwordEncoder()
        );
    }
}
