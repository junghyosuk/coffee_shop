package springboot.webproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import springboot.webproject.dto.ProductDTO;
import springboot.webproject.service.ProductService;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    //coffeebean list 페이지
    @GetMapping("/coffeebean/list")
    public String coffeebeanList(Model model){
        List<ProductDTO> coffeeBeans = productService.findProductsByType(1); // 타입이 1인 제품만 가져옴
        int countProduct=coffeeBeans.size();

        model.addAttribute("productList", coffeeBeans);
        model.addAttribute("countProduct", countProduct);
        return "/view/product/coffeebean_list"; // 커피원두 리스트 페이지 경로
    }

    //coffeebean view 페이지
    @GetMapping("/coffeebean/view/{prodNo}")
    public String coffeebeanView(@PathVariable("prodNo") Long prodNo, Model model) {
        ProductDTO product = productService.findProductById(prodNo);
        if (product == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "상품을 찾을 수 없습니다.");
        }
        // 가격 포맷팅
        NumberFormat formatter = NumberFormat.getInstance(Locale.KOREA);
        String formattedPrice = formatter.format(product.getProdPrice());

        model.addAttribute("product", product);
        model.addAttribute("formattedPrice", formattedPrice); // 포맷된 가격 추가
        return "/view/product/coffeebean_view";
    }

    //coldbrew list 페이지
    @GetMapping("/coldbrew/list")
    public String coldbrewList(Model model){
        List<ProductDTO> coffeeBeans = productService.findProductsByType(2); // 타입이 1인 제품만 가져옴
        int countProduct=coffeeBeans.size();

        model.addAttribute("productList", coffeeBeans);
        model.addAttribute("countProduct", countProduct);

        return "/view/product/coldbrew_list";
    }

    //coldbrew view 페이지
    @GetMapping("/coldbrew/view/{prodNo}")
    public String coldbrewView(@PathVariable("prodNo") Long prodNo, Model model) {
        ProductDTO product = productService.findProductById(prodNo);
        if (product == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "상품을 찾을 수 없습니다.");
        }
        // 가격 포맷팅
        NumberFormat formatter = NumberFormat.getInstance(Locale.KOREA);
        String formattedPrice = formatter.format(product.getProdPrice());

        model.addAttribute("product", product);
        model.addAttribute("formattedPrice", formattedPrice); // 포맷된 가격 추가
        return "/view/product/coldbrew_view";
    }



}
