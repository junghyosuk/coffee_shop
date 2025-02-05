package springboot.webproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
            if (e.getMessage().equals("Product already in cart")) {
                redirectAttributes.addFlashAttribute("confirm", "이미 장바구니에 있는 상품입니다. 장바구니로 이동하시겠습니까?");
                return "redirect:/product/view?prodNo=" + prodNo; // 현재 페이지로 리디렉트
            }
            redirectAttributes.addFlashAttribute("error", "추가 실패: " + e.getMessage());
        }
        return "redirect:/cart/list";
    }

    // 장바구니에서 상품 삭제
//    @PostMapping("/delete")
//    public String deleteCartItem(@RequestParam("cartNo") Integer cartNo) {
//        System.out.println("cartNo: " + cartNo);
//        cartService.removeCartItem(cartNo);
//        return "redirect:/cart/list"; // 삭제 후 장바구니 목록으로 리다이렉트
//    }
    @PostMapping("/delete")
    public String deleteCartItem(@RequestParam("cartNo") Integer cartNo, RedirectAttributes redirectAttributes) {
        try {
            System.out.println("cartNo: " + cartNo);
            cartService.removeCartItem(cartNo);
            redirectAttributes.addFlashAttribute("message", "상품이 삭제되었습니다.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "상품 삭제 중 오류가 발생했습니다.");
        }
        return "redirect:/cart/list"; // 삭제 후 장바구니 목록으로 리다이렉트
    }


    @PostMapping("/deleteSelect")
    @ResponseBody
    public ResponseEntity<String> deleteMultipleCartItems(@RequestBody List<Integer> cartNos) {
        try {
            for (Integer cartNo : cartNos) {
                cartService.removeCartItem(cartNo); // ✅ 개별 삭제 처리
            }
            return ResponseEntity.ok("선택한 상품이 삭제되었습니다.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("상품 삭제 중 오류가 발생했습니다.");
        }
    }


    //장바구니에 상품 존재여부 확인
    @PostMapping("/check")
    @ResponseBody
    public ResponseEntity<Boolean> checkProductInCart(@RequestParam("prodNo") long prodNo, Principal principal) {
        if (principal == null) {
            return ResponseEntity.ok(false); // 로그인하지 않은 경우 false 반환
        }

        String userId = principal.getName();
        boolean exists = cartService.checkProductInCart(userId, prodNo); // 장바구니 존재 여부 체크
        return ResponseEntity.ok(exists);
    }

}
