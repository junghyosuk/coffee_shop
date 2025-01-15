package springboot.webproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.webproject.dto.Role;

import springboot.webproject.repository.RoleRepository;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public void addRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    public void updateRole(Integer roleId, String roleName) {
        Role role = roleRepository.findById(roleId).orElseThrow(() -> new IllegalArgumentException("Invalid Role ID"));
        role.setRoleName(roleName);
        roleRepository.save(role);
    }
}