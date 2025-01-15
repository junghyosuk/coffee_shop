package springboot.webproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springboot.webproject.dto.ProductDTO;
import springboot.webproject.entity.ProductEntity;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    //상품관리
    @GetMapping("/product")
    public String adminProduct(){
        return "/view/admin/product_manage";
    }

    //상품등록 처리
    @PostMapping("/product/register")
    public String registerProduct(@ModelAttribute ProductDTO productDTO){
        ProductEntity productEntity=productDTO.toProductEntity();

        return "redirect:/admin/product";
    }


}
