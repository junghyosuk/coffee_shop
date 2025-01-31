package springboot.webproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import springboot.webproject.dto.ProductDTO;
import springboot.webproject.service.ProductService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final ProductService productService;

    /* 메인페이지 */
    @GetMapping("/")
    public String mainHome(Model model) {
        List<ProductDTO> allProduct = productService.findAllProduct();
        model.addAttribute("productList", allProduct);
        model.addAttribute("page","index");
        return "index";
    }
}
