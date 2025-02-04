package springboot.webproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.webproject.dto.CartDTO;
import springboot.webproject.dto.UsersDTO;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<CartDTO, Integer> {
    CartDTO findByCartNo(int cartNo);
    List<CartDTO> findByUsers_UsersId(String usersId); // 수정된 부분
    CartDTO findByUsers_UsersIdAndProduct_ProdNo(String usersId, int prodNo);
    Optional<List<CartDTO>> findAllByUsers_UsersIdAndStatus(String userId, int status);
}


//@Repository
//public interface CartRepository extends JpaRepository<CartDTO, Long> {
//    List<CartDTO> findByCartusersId(String cartusersId);
//    CartDTO findByCartusersIdAndCartproductNo(String cartusersId, int cartproductNo);
//}
