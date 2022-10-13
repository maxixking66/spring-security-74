package com.maktabsharif74.springsecurity.resource;

import com.maktabsharif74.springsecurity.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(
                Arrays.asList(
                        new User(
                                1L, "mat", null, "mohsen", "asgari", null
                        ),
                        new User(
                                2L, "tom", null, "ali", "alavi", null
                        )
                )
        );
    }
}
