package springboot.webproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import springboot.webproject.dto.ProductDTO;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

@Entity
@Table(name = "PRODUCT")
//@SequenceGenerator(name = "product_seq_generator", sequenceName = "PRODUCT_SEQ", initialValue = 1, allocationSize = 1)
@Getter
@Setter
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prodNo; // 제품 번호

    @Column(length = 1)
    private int prodType; // 제품 타입

    @Column(length = 200)
    private String prodName; // 제품명

    @Column(length = 10)
    private int prodPrice; // 가격

    @Column(length = 10)
    private int prodAmount; // 수량

    @Column(length = 50)
    private String prodImage1; // 메인 이미지 파일명

    @Column(length = 50)
    private String prodImage2; // 서브 이미지 파일명

    @Column(length = 4000)
    private String prodInfo; // 제품 정보

    @Column
    private LocalDateTime prodRegdate; // 등록일시

    // Entity → DTO 변환
    public ProductDTO toProductDTO() {
        ProductDTO product = new ProductDTO();
        product.setProdNo(prodNo);
        product.setProdType(prodType);
        product.setProdName(prodName);
        product.setProdPrice(prodPrice);
        product.setProdAmount(prodAmount);
        product.setProdImage1Name(prodImage1);
        product.setProdImage2Name(prodImage2); // 실제 이미지 파일명 설정
        product.setProdInfo(prodInfo);
        product.setProdRegdate(prodRegdate); // 등록일시 설정
        return product;

    }
}
