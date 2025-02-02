package springboot.webproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springboot.webproject.dto.CartDTO;
import springboot.webproject.service.CartService;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    // 장바구니 페이지
    @GetMapping("/list")
    public String cartList(Model model, Principal principal){
        String userId = principal.getName();
        List<CartDTO> cartItems = cartService.getCartList(userId);
        model.addAttribute("cartItems", cartItems);
        return "/view/cart/cart_list";
    }

    // 장바구니에 상품 추가
    @PostMapping("/add")
    public String addToCart(@RequestParam("prodNo") int prodNo,
                            @RequestParam("quantity") int quantity,
                            Principal principal) {
        String userId = principal.getName();
        cartService.addToCart(userId, prodNo, quantity);
        return "redirect:/cart/list";
    }

    // 장바구니에서 상품 삭제
    @PostMapping("/delete")
    public String deleteCartItem(@RequestParam("cartNo") Long cartNo) {
        cartService.removeCartItem(cartNo);
        return "redirect:/cart/list";
    }
}
