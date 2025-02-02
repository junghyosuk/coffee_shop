package springboot.webproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.webproject.dto.CartDTO;
import springboot.webproject.dto.ProductDTO;
import springboot.webproject.repository.CartRepository;
import springboot.webproject.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final ProductService productService;

    @Override
    @Transactional
    public void addToCart(String usersId, int prodNo, int quantity) {
        CartDTO existingCart = cartRepository.findByCartusersIdAndCartproductNo(usersId, prodNo);

        if (existingCart != null) {
            existingCart.setCartQuantity(existingCart.getCartQuantity() + quantity);
            cartRepository.save(existingCart);
        } else {
            CartDTO cart = CartDTO.builder()
                    .cartusersId(usersId)
                    .cartproductNo(prodNo)
                    .cartQuantity(quantity)
                    .build();
            cartRepository.save(cart);
        }
    }

    @Override
    public List<CartDTO> getCartList(String usersId) {
        List<CartDTO> cartList = cartRepository.findByCartusersId(usersId);

        // ✅ int → long 변환하여 productService 메서드 호출
        for (CartDTO cart : cartList) {
            ProductDTO product = productService.findProductById((long) cart.getCartproductNo());
            cart.setProduct(product);
        }

        return cartList;
    }

    @Override
    public void removeCartItem(Long cartNo) {
        cartRepository.deleteById(cartNo);
    }
}
