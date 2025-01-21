package springboot.webproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springboot.webproject.dto.ProductDTO;
import springboot.webproject.service.ProductService;

import java.util.List;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminProductController {

    private final ProductService productService; // ProductService 추가

    // 상품 관리
    @GetMapping("/product")
    public String adminProduct(Model model) {
        List<ProductDTO> productList = productService.findAllProduct();
        model.addAttribute("productList", productList);
        return "/view/admin/product_manage"; // 상품 관리 페이지 경로
    }

    // 상품 등록 처리
    @PostMapping("/product/register")
    public String registerProduct(@ModelAttribute ProductDTO productDTO) {
        productService.save(productDTO); // 상품 저장
        return "redirect:/admin/product"; // 저장 후 상품 관리 페이지로 리다이렉트
    }

    // 상품 삭제 처리
    @GetMapping("/product/delete/{prodNo}")
    public String deleteProduct(@PathVariable(value="prodNo") Long prodNo) {
        productService.deleteProductByProdNo(prodNo);
        return "redirect:/admin/product";
    }



}