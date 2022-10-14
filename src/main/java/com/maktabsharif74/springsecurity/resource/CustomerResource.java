package com.maktabsharif74.springsecurity.resource;

import com.maktabsharif74.springsecurity.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/customer")
public class CustomerResource {

    @GetMapping
    @PreAuthorize(value = "hasAnyRole('ADMIN', 'CUSTOMER')")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(
                Arrays.asList(
                        new User(
                                1L, "mat", null, "customer", "customer", null
                        ),
                        new User(
                                2L, "tom", null, "customer", "customer", null
                        )
                )
        );
    }

    @PostMapping
    @PreAuthorize(value = "hasAnyRole('ADMIN', 'CUSTOMER')")
    public ResponseEntity<User> create(@RequestBody User user) {
        System.out.println("user: " + user);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/count")
    @PreAuthorize(value = "hasAnyRole('ADMIN', 'CUSTOMER')")
    public ResponseEntity<Long> countAll() {
        return ResponseEntity.ok(
                new Random().nextLong()
        );
    }
}
