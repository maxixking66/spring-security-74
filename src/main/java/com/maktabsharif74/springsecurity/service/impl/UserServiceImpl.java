package com.maktabsharif74.springsecurity.service.impl;

import com.maktabsharif74.springsecurity.domain.User;
import com.maktabsharif74.springsecurity.repository.UserRepository;
import com.maktabsharif74.springsecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository baseRepository;

    @Override
    @Transactional
    public User save(User user) {
        return baseRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return baseRepository.findByUsername(username);
    }

    @Override
    public long count() {
        return baseRepository.count();
    }
}
