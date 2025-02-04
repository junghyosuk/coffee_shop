package springboot.webproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import springboot.webproject.dto.CartDTO;
import springboot.webproject.dto.UsersDTO;
import springboot.webproject.service.CartService;
import springboot.webproject.service.UserService;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;
    private final UserService userService;


    @GetMapping("/list")
    public String cartList(Model model, Principal principal) {
        if (principal == null) {
            return "redirect:/login"; // 로그인이 안 된 경우 로그인 페이지로 리디렉트
        }

        String userId = principal.getName();
        List<CartDTO> cartItems = cartService.getCartList(userId);
        model.addAttribute("cartItems", cartItems);

        return "/view/cart/cart_list";
    }

    @PostMapping("/add")
    public String addProductToCart(Authentication authentication,
                                   @RequestParam("prodNo") long prodNo,
                                   @RequestParam("cartQuantity") int cartQuantity,
                                   RedirectAttributes redirectAttributes) {
        try {
            String username = authentication.getName();
            UsersDTO user = userService.findUserByUsersId(username);
            if (user == null) {
                redirectAttributes.addFlashAttribute("error", "사용자를 찾을 수 없습니다.");
                return "redirect:/cart/list";
            }
            cartService.addProductToCart(user, prodNo, cartQuantity);
            redirectAttributes.addFlashAttribute("message", "장바구니에 추가되었습니다.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "추가 실패: " + e.getMessage());
        }
        return "redirect:/cart/list";
    }

    // 장바구니에서 상품 삭제
//    @PostMapping("/delete")
//    public String deleteCartItem(@RequestParam("cartNo") Long cartNo) {
//        cartService.removeCartItem(cartNo);
//        return "redirect:/cart/list";
//    }
}
