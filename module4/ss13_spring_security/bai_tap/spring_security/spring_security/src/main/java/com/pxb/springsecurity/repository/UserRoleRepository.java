package com.pxb.springsecurity.repository;

import com.pxb.springsecurity.model.AppUser;
import com.pxb.springsecurity.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> findByAppUser(AppUser appUser);
}
