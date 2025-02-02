package springboot.webproject.service;

import springboot.webproject.dto.CartDTO;

import java.util.List;

public interface CartService {
    void addToCart(String usersId, int prodNo, int quantity);
    List<CartDTO> getCartList(String usersId);
    void removeCartItem(Long cartNo);
}