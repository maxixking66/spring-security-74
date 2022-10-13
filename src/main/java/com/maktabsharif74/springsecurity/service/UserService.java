package com.maktabsharif74.springsecurity.service;

import com.maktabsharif74.springsecurity.domain.User;

public interface UserService {

    User save(User user);

    User findByUsername(String username);

    long count();
}
