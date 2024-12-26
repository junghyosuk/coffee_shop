package springboot.webproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainController {
    /* 메인페이지 */
    @GetMapping("/")
    public String mainHome() {
        return "index";
    }
}
