package com.maktabsharif74.springsecurity.config;

import com.maktabsharif74.springsecurity.domain.User;
import com.maktabsharif74.springsecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("user not found");
        }

        return org.springframework.security.core.userdetails.
                User
                .withUsername(username)
                .password(user.getPassword())
                .authorities(
                        user.getRoles().stream().map(role -> "ROLE_".concat(role.getName()))
                                .distinct().toArray(String[]::new)
                )
                .build();
    }
}
