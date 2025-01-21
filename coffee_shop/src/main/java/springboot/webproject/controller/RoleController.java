package springboot.webproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springboot.webproject.dto.Role;
import springboot.webproject.service.RoleService;
import org.springframework.ui.Model;
import java.util.List;

@Controller
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;


    @GetMapping
    public String getAllRoles(Model model) {
        List<Role> roles = roleService.getAllRoles();
        model.addAttribute("roles", roles);
        return "view/role/role"; // View name: roles.html
    }
    @PostMapping("/add")
    public String addRole (@RequestParam(name = "roleName") String roleName) {
        Role role = new Role();
        role.setRoleName(roleName);
        roleService.addRole(role);
        System.out.println("Role Name: " + roleName);
        return "redirect:/roles";
    }

    @PostMapping("/update")
    public String updateRole(@RequestParam Integer roleId, @RequestParam String roleName) {
        roleService.updateRole(roleId, roleName);
        return "redirect:/roles";
    }
}