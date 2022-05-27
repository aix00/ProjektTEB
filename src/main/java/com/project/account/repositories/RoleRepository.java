package com.project.account.repositories;

import com.project.account.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}