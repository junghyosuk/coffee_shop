package springboot.webproject.service;

import springboot.webproject.dto.Role;


import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();
    void addRole(Role role);
    void updateRole(Integer roleId, String roleName);
}