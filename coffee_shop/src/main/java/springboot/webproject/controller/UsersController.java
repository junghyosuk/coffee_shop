package springboot.webproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import springboot.webproject.dto.UsersDTO;
import springboot.webproject.service.UserService;

@Controller
@RequestMapping("/users")
public class UsersController {


    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UsersController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    // Serve the HTML form for user creation
    @GetMapping("/create")
    public String showCreateUserForm(Model model) {
        model.addAttribute("user", new UsersDTO());
        return "/view/login/create_user"; // This maps to create_user.html
    }

    // Handle form submission
    @PostMapping
    public ModelAndView createUser(@ModelAttribute UsersDTO user) {

        String encodedPassword  = passwordEncoder.encode(user.getUsersPw());
        user.setUsersPw(encodedPassword);  // 암호화된 비밀번호 설정
        userService.createUser(user); // Save the user using the service

        return new ModelAndView("redirect:/users/create?success=true");

    }
}