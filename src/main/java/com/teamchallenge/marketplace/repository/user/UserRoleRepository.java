package com.teamchallenge.marketplace.repository.user;

import com.teamchallenge.marketplace.entity.user.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
}
