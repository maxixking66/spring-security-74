package com.maktabsharif74.springsecurity.repository;

import com.maktabsharif74.springsecurity.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
