package com.wia.jwt.repositories;

import com.wia.jwt.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository  extends JpaRepository<AppRole,Long> {
    public AppRole findByRoleName(String roleName);
}
