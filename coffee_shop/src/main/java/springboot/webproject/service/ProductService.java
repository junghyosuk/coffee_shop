package springboot.webproject.service;

import springboot.webproject.dto.ProductDTO;
import springboot.webproject.entity.ProductEntity;

import java.util.List;

public interface ProductService {
    ProductEntity save(ProductEntity productEntity); //상품 저장
    void deleteProductByProdNo(Long prodNo); //상품 삭제
    List<ProductDTO> findAllProduct(); //전체상품 조회
}
