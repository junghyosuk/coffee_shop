package springboot.webproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.webproject.dto.OrdersDTO;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrdersDTO, Integer> {
    // 특정 사용자의 주문 목록 조회
    List<OrdersDTO> findByOrdersUsersId(String usersId);
}
