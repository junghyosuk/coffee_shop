package springboot.webproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springboot.webproject.dto.ProductDTO;
import springboot.webproject.entity.ProductEntity;
import springboot.webproject.repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;

    @Override
    public ProductEntity save(ProductEntity productEntity) {
        return productRepository.save(productEntity);
    }

    @Override
    public void deleteProductByProdNo(Long prodNo) {
        productRepository.deleteById(prodNo);
    }

    @Override
    public List<ProductDTO> findAllProduct() {
        return productRepository.findAll()
                .stream()
                .map(ProductEntity::toProductDTO) // Entity를 DTO로 변환
                .collect(Collectors.toList());
    }




}
