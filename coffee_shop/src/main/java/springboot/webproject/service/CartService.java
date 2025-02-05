package springboot.webproject.service;

import springboot.webproject.dto.CartDTO;
import springboot.webproject.dto.UsersDTO;

import java.util.List;
import java.util.Optional;

public interface CartService {
    List<CartDTO> getCartList(String usersId);
    void addProductToCart(UsersDTO usersId, long prodNo, int quantity) throws Exception;
    void completeOrder(int cartNo) throws Exception;
    boolean checkProductInCart(String userId, long prodNo);
    void removeCartItem(Integer cartNo);

//    Optional<CartDTO> getCompletedOrders(String userId);
}


//public interface CartService {
//    void addToCart(String usersId, int prodNo, int quantity);
//    List<CartDTO> getCartList(String usersId);
//    void removeCartItem(Long cartNo);
//}