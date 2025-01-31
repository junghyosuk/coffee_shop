package springboot.webproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {
    //장바구니 페이지
    @RequestMapping("/list")
    public String cartList(){
        return "/view/cart/cart_list";
    }
}
