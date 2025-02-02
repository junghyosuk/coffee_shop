package springboot.webproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.webproject.dto.CartDTO;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<CartDTO, Long> {
    List<CartDTO> findByCartusersId(String cartusersId);
    CartDTO findByCartusersIdAndCartproductNo(String cartusersId, int cartproductNo);
}
