package springboot.webproject.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springboot.webproject.dto.UsersDTO;
import springboot.webproject.service.UserService;
import org.springframework.security.core.Authentication;
import java.security.Principal;
import java.util.Optional;

@Controller
public class LoginController {
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
//    public String loginForm(Model model) {
//        // View에 전달할 빈 UsersDTO 객체 생성
    public String loginForm(
            @RequestParam(value = "message", required = false) String message, Model model, Authentication authentication) {
        // 이미 로그인된 사용자가 있을 경우 홈 페이지로 리다이렉트
        if (authentication != null && authentication instanceof UsernamePasswordAuthenticationToken && authentication.isAuthenticated()) {
            // 로그인된 사용자는 홈 페이지로 리다이렉트
            return "view/login/home"; // 로그인된 경우 홈 페이지로 리다이렉트
        }
        // 로그인 페이지로 이동할 때 메시지 추가
        if (message != null) {
            model.addAttribute("loginMessage", "로그인이 필요합니다.");
        }
        model.addAttribute("loginUser", new UsersDTO());
        return "view/login/login_form"; // 로그인 폼 페이지
    }
// security 를 사용하면 post 방식이 필요가 없기때문에 주석 처리
//    @PostMapping("/login")
//    public String login(Principal principal, Model model) {
//        if (principal != null) {
//            // 인증된 사용자 정보 가져오기
//            model.addAttribute("user", principal.getName());
//            return "view/login/home"; // 홈 페이지로 이동
//        } else {
//            model.addAttribute("errorMessage", "Invalid username or password");
//            return "view/login/login_form";
//        }
//    }
//
//@PostMapping("/login")
//public String login(@ModelAttribute("user") UsersDTO usersDTO,
//                    Model model,
//                    Principal principal) {
//    Optional<UsersDTO> userOptional = userService.login(usersDTO.getUsersId(), usersDTO.getUsersPw());
//
//    if (userOptional.isPresent()) {
//        UsersDTO user = userOptional.get();
//        // 로그인 성공 시 세션에 사용자 정보 저장
////        session.setAttribute("user", user);
//        model.addAttribute("user", principal.getName());
//        return "view/login/home"; // 홈 페이지로 이동
//    } else {
//        // 로그인 실패 시 에러 메시지 전달 및 로그인 페이지로 이동
//        model.addAttribute("errorMessage", "Invalid username or password");
//        return "view/login/login_form";
//    }
//}



//Security  가 알아서 로그아웃도 작성하여 만듬
//    @GetMapping("/logout")// 세션 지워서 로그아웃 하기
//    public String logout(HttpSession session) {
//        // 세션 무효화
//        session.invalidate();
//        return "redirect:/login"; // 로그아웃 후 로그인 페이지로 리다이렉트
//    }




//    @GetMapping("/home")
//    public String home(HttpSession session, Model model) {
//        UsersDTO loginUser = (UsersDTO) session.getAttribute("user");
//        if (loginUser == null) {
//            // 로그인되지 않은 경우 로그인 페이지로 리다이렉트
//            return "redirect:/login";
//        }
//        // 로그인된 사용자 정보 전달
//        model.addAttribute("user", loginUser);
//        return "view/home";
//    }
//    @PostMapping("/login")
//    public String login(@ModelAttribute("loginUser") UsersDTO usersDTO, Model model) {
//        return userService.login(usersDTO.getUsersId(), usersDTO.getUsersPw())
//                .map(user -> {
//                    model.addAttribute("user", user);
//                    return "view/home"; // 로그인 성공 시 홈 페이지
//                })
//                .orElse("view/login_form"); // 로그인 실패 시 다시 로그인 페이지
//    }

}