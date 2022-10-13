package com.maktabsharif74.springsecurity.service.impl;

import com.maktabsharif74.springsecurity.domain.Role;
import com.maktabsharif74.springsecurity.repository.RoleRepository;
import com.maktabsharif74.springsecurity.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository userRepository;

    @Override
    @Transactional
    public Role save(Role user) {
        return userRepository.save(user);
    }

    @Override
    public Role findByName(String name) {
        return userRepository.findByName(name);
    }
}
