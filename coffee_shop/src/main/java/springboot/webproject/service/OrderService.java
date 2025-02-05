package springboot.webproject.service;

import springboot.webproject.dto.OrdersDTO;

import java.util.List;

public interface OrderService {
    // 주문 저장
    OrdersDTO saveOrder(OrdersDTO order);

    // 특정 사용자의 주문 목록 조회
    List<OrdersDTO> getOrdersByUserId(String userId);

    // 특정 주문 조회
    OrdersDTO getOrderById(int orderId);
}