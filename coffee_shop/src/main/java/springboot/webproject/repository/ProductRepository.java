package springboot.webproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.webproject.entity.ProductEntity;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    // 상품 ID로 상품 찾기 범석
    Optional<ProductEntity> findByProdNo(long prodNo);
}
