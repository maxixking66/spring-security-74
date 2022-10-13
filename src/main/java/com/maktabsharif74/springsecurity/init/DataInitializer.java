package com.maktabsharif74.springsecurity.init;

import com.maktabsharif74.springsecurity.domain.Role;
import com.maktabsharif74.springsecurity.domain.User;
import com.maktabsharif74.springsecurity.service.RoleService;
import com.maktabsharif74.springsecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collections;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final UserService userService;

    private final RoleService roleService;

    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        initRoles();
        initUsers();
    }

    private void initRoles() {
        if (roleService.count() == 0) {
            roleService.save(new Role(null, "ADMIN"));
            roleService.save(new Role(null, "CUSTOMER"));
        }
    }

    private void initUsers() {
        if (userService.count() == 0 && roleService.count() != 0) {

            Role admin = roleService.findByName("ADMIN");
            Role customer = roleService.findByName("CUSTOMER");

            userService.save(
                    new User(null, "mohsen", passwordEncoder.encode("123456"),
                            "mohsen", "asgari", Collections.singleton(admin))
            );

            userService.save(
                    new User(null, "mehrshad", passwordEncoder.encode("123456"),
                            "mehrshad", "samaei", Collections.singleton(customer))
            );
        }
    }
}
