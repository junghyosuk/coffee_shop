package springboot.webproject.service;

import org.springframework.web.multipart.MultipartFile;
import springboot.webproject.dto.ProductDTO;
import springboot.webproject.entity.ProductEntity;

import java.util.List;

public interface ProductService {
    void save(ProductDTO productDTO); // 상품 저장
    void deleteProductByProdNo(Long prodNo); // 상품 삭제
    List<ProductDTO> findAllProduct(); // 전체상품 조회
    List<ProductDTO> findProductsByType(int prodType); // 추가된 메소드
    ProductDTO findProductById(Long prodNo); // 상품 ID로 조회하는 메소드 추가
    void modifyProduct(ProductDTO productDTO); // 상품 수정
    List<ProductDTO> getProductsByIds(List<Long> prodNos, List<Integer> quantities, List<Integer> totalPrices);
}
