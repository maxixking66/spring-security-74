package com.maktabsharif74.springsecurity.resource;

import com.maktabsharif74.springsecurity.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminResource {

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(
                Arrays.asList(
                        new User(
                                1L, "mat", null, "admin", "admin"
                        ),
                        new User(
                                2L, "tom", null, "admin", "admin"
                        )
                )
        );
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        System.out.println("user: " + user);
        return ResponseEntity.ok(user);
    }
}
