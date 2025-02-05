package springboot.webproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.webproject.dto.CartDTO;
import springboot.webproject.dto.ProductDTO;
import springboot.webproject.dto.UsersDTO;
import springboot.webproject.entity.ProductEntity;
import springboot.webproject.repository.CartRepository;
import springboot.webproject.repository.ProductRepository;
import springboot.webproject.repository.UsersRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final ProductService productService;

    @Override
    public List<CartDTO> getCartList(String usersId) {
        List<CartDTO> cartList = cartRepository.findByUsers_UsersId(usersId);

        // ProductDTO로 변환하여 cartProduct에 설정
//        for (CartDTO cart : cartList) {
            // product에서 prodNo를 가져옴
//            ProductDTO product = productService.findProductById(cart.getProduct().getProdNo());
//            cart.setCartProduct(product);
//        }


        return cartList;
    }

    @Override
    public void addProductToCart(UsersDTO user, long prodNo, int cartQuantity) throws Exception {
        if (user == null) {
            throw new Exception("User not found");
        }

        ProductEntity productEntity = productRepository.findByProdNo(prodNo)
                .orElseThrow(() -> new Exception("Product not found"));

        if (productEntity.getProdAmount() < cartQuantity) {
            throw new Exception("Not enough stock");
        }

        // 이미 장바구니에 있는지 확인
        boolean exists = checkProductInCart(user.getUsersId(), prodNo);
        if (exists) {
            throw new Exception("해당 상품이 이미 장바구니에 있습니다.");
        }

        CartDTO cartDTO = new CartDTO();
        cartDTO.setUsers(user);
        cartDTO.setProduct(productEntity); // ProductEntity 설정
        cartDTO.setCartQuantity(cartQuantity);
        cartDTO.setStatus(0);

        cartRepository.save(cartDTO);
    }

    @Override
    public void completeOrder(int cartNo) throws Exception {
        CartDTO cartDTO = cartRepository.findByCartNo(cartNo);
        if (cartDTO == null) {
            throw new Exception("Cart item not found");
        }
        cartDTO.setStatus(1);
        cartRepository.save(cartDTO);
    }

    // checkProductInCart 메서드 구현
    @Override
    public boolean checkProductInCart(String userId, long prodNo) {
        List<CartDTO> cartList = cartRepository.findByUsers_UsersId(userId);
        return cartList.stream().anyMatch(cart -> cart.getProduct().getProdNo() == prodNo);
    }

    @Override
    public void removeCartItem(Integer cartNo) {
        cartRepository.deleteById(cartNo);
    }


//    @Override
//    public Optional<CartDTO> getCompletedOrders(String userId) {
//        return cartRepository.findAllByUsers_UsersIdAndStatus(userId, 1);
//    }
}

//@Service
//@RequiredArgsConstructor
//public class CartServiceImpl implements CartService {
//    private final CartRepository cartRepository;
//    private final ProductService productService;
//
//    @Override
//    @Transactional
//    public void addToCart(String usersId, int prodNo, int quantity) {
//        CartDTO existingCart = cartRepository.findByCartusersIdAndCartproductNo(usersId, prodNo);
//
//        if (existingCart != null) {
//            existingCart.setCartQuantity(existingCart.getCartQuantity() + quantity);
//            cartRepository.save(existingCart);
//        } else {
//            CartDTO cart = CartDTO.builder()
//                    .cartusersId(usersId)
//                    .cartproductNo(prodNo)
//                    .cartQuantity(quantity)
//                    .build();
//            cartRepository.save(cart);
//        }
//    }
//
//    @Override
//    public List<CartDTO> getCartList(String usersId) {
//        List<CartDTO> cartList = cartRepository.findByCartusersId(usersId);
//
//        // ✅ int → long 변환하여 productService 메서드 호출
//        for (CartDTO cart : cartList) {
//            ProductDTO product = productService.findProductById((long) cart.getCartproductNo());
//            cart.setProduct(product);
//        }
//
//        return cartList;
//    }
//
//    @Override
//    public void removeCartItem(Long cartNo) {
//        cartRepository.deleteById(cartNo);
//    }
//}
