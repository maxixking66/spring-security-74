package com.maktabsharif74.springsecurity.service;

import com.maktabsharif74.springsecurity.domain.Role;

public interface RoleService {

    Role save(Role user);

    Role findByName(String name);

    long count();
}
