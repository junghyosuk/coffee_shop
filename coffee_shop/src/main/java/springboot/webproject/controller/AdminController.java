package springboot.webproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    //상품관리
    @GetMapping("/product")
    public String adminProduct(){
        return "/view/admin/admin_product";
    }
}
