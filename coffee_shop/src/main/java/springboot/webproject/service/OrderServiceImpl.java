package springboot.webproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.webproject.dto.OrdersDTO;
import springboot.webproject.repository.OrderRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public OrdersDTO saveOrder(OrdersDTO order) {
        return orderRepository.save(order);
    }

    @Override
    public List<OrdersDTO> getOrdersByUserId(String userId) {
        return orderRepository.findByOrdersUsersId(userId);
    }

    @Override
    public OrdersDTO getOrderById(int orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }
}
