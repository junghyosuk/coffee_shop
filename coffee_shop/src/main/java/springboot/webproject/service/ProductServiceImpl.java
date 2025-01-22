package springboot.webproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import springboot.webproject.dto.ProductDTO;
import springboot.webproject.entity.ProductEntity;
import springboot.webproject.repository.ProductRepository;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Value("${file.upload-dir}") // 파일 저장 경로
    private String uploadDir;

    //상품등록
    @Override
    public void save(ProductDTO productDTO) {
        try {
            // 메인이미지 저장
            String mainImageName = saveFile(productDTO.getProdImage1());

            // 서브이미지 저장
            String subImageName = saveFile(productDTO.getProdImage2());

            // DTO → Entity 변환 후 저장
            ProductEntity productEntity = productDTO.toEntity(mainImageName, subImageName);
            productRepository.save(productEntity);
        } catch (IOException e) {
            throw new RuntimeException("파일 처리 실패", e);
        }
    }

    @Override
    public void deleteProductByProdNo(Long prodNo) {
        productRepository.deleteById(prodNo);
    }

    @Override
    public List<ProductDTO> findAllProduct() {
        return productRepository.findAll()
                .stream()
                .map(ProductEntity::toProductDTO) // Entity → DTO 변환
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> findProductsByType(int prodType) {
        return productRepository.findAll()
                .stream()
                .filter(productEntity -> productEntity.getProdType() == prodType) // 타입 필터링
                .map(ProductEntity::toProductDTO) // Entity → DTO 변환
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO findProductById(Long prodNo) {
        return productRepository.findById(prodNo)
                .map(ProductEntity::toProductDTO) // Optional을 DTO로 변환
                .orElse(null); // 상품이 없으면 null 반환
    }

    @Override
    public void modifyProduct(ProductDTO productDTO) {
        try {
            // 메인이미지 저장
            String mainImageName = productDTO.getProdImage1Name(); // 기본값: 기존 이미지 이름
            if (productDTO.getProdImage1() != null && !productDTO.getProdImage1().isEmpty()) {
                mainImageName = saveFile(productDTO.getProdImage1()); // 새 이미지 업로드
            }

            // 서브이미지 저장
            String subImageName = productDTO.getProdImage2Name(); // 기본값: 기존 이미지 이름
            if (productDTO.getProdImage2() != null && !productDTO.getProdImage2().isEmpty()) {
                subImageName = saveFile(productDTO.getProdImage2()); // 새 이미지 업로드
            }

            // DTO → Entity 변환 후 저장
            ProductEntity productEntity = productDTO.toEntity(mainImageName, subImageName);
            productRepository.save(productEntity);
        } catch (IOException e) {
            throw new RuntimeException("파일 처리 실패", e);
        }


    }

    // 파일 저장 로직
    private String saveFile(MultipartFile file) throws IOException {
        if (file != null && !file.isEmpty()) {
            String originalFileName = file.getOriginalFilename();
            //String uniqueFileName = UUID.randomUUID() + "_" + originalFileName; // 중복 방지 파일명 생성

            // resources/static/product_images 경로 설정
            File saveDir = new File(uploadDir);
            if (!saveDir.exists()) {
                saveDir.mkdirs(); // 디렉토리 생성
            }

            File saveFile = new File(saveDir, originalFileName);
            file.transferTo(saveFile);
            return originalFileName;
        }
        return null;
    }
}
