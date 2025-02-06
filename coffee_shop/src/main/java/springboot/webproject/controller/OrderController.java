package springboot.webproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springboot.webproject.dto.OrdersDTO;
import springboot.webproject.dto.ProductDTO;
import springboot.webproject.dto.UsersDTO;
import springboot.webproject.service.OrderService;
import springboot.webproject.service.ProductService;
import springboot.webproject.service.UserService;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final ProductService productService;
    private final UserService userService;

    // 주문 페이지 (장바구니 or 상품 상세에서 주문)
    @PostMapping("/checkout")
    public String checkout(
            @RequestParam("prodNos") List<Long> prodNos,
            @RequestParam("quantities") List<Integer> quantities,
            @RequestParam(value = "totalPrices", required = false) List<Integer> totalPrices,
            Authentication authentication, Model model) {

        System.out.println("prodNos="+prodNos);
        System.out.println("prodNos="+quantities);
        System.out.println("prodNos="+totalPrices);

        if (authentication == null) {
            return "redirect:/login";
        }

        String userId = authentication.getName();
        UsersDTO user = userService.findUserByUsersId(userId);

        // 🛠️ totalPrices 값이 null이거나 NaN이면 기본값을 설정
        if (totalPrices == null || totalPrices.contains(null)) {
            totalPrices = quantities.stream().map(q -> 0).collect(Collectors.toList());
        }

        // 상품 정보 가져오기
        List<ProductDTO> orderItems = productService.getProductsByIds(prodNos, quantities, totalPrices);
        model.addAttribute("orderItems", orderItems);
        model.addAttribute("user", user);

        return "/view/order/order";
    }

    // 주문 처리 (DB 저장)
    @PostMapping("/placeOrder")
    public String placeOrder(Authentication authentication, @ModelAttribute OrdersDTO order) {
        if (authentication == null) {
            return "redirect:/login";
        }

        order.setOrdersUsersId(authentication.getName());
        order.setOrdersDate(new Date());
        order.setOrdersStatus(1);

        orderService.saveOrder(order);

        return "redirect:/order/confirmation";
    }
}
