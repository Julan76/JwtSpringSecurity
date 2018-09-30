package com.wia.jwt.services;

import com.wia.jwt.entities.AppRole;
import com.wia.jwt.entities.AppUser;

public interface AccountService {
    public AppUser saveUser(AppUser user);
    public AppRole saveRole(AppRole role);
    public void addRoleToUser(String username,String rolename);
    public AppUser findUserByUsername(String username);
}
