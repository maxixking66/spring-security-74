package com.maktabsharif74.springsecurity.resource;

import com.maktabsharif74.springsecurity.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/customer")
public class CustomerResource {

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(
                Arrays.asList(
                        new User(
                                1L, "mat", null, "customer", "customer"
                        ),
                        new User(
                                2L, "tom", null, "customer", "customer"
                        )
                )
        );
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        System.out.println("user: " + user);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countAll() {
        return ResponseEntity.ok(
                new Random().nextLong()
        );
    }
}
