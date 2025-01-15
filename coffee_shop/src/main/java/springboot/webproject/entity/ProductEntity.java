package springboot.webproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import springboot.webproject.dto.ProductDTO;

import java.time.LocalDateTime;

@Entity
@Table(name="PRODUCT")
@SequenceGenerator(name="product_seq_generator", sequenceName = "PRODUCT_SEQ"
    , initialValue = 1, allocationSize = 1)
@Setter
@Getter
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq_generator")
    private Long prodNo;
    @Column(length = 1)
    private int prodType;
    @Column(length = 200)
    private String prodName;
    @Column(length = 10)
    private int prodPrice;
    @Column(length = 10)
    private int prodAmount;
    @Column(length = 50)
    private String prodImage1;
    @Column(length = 50)
    private String prodImage2;
    @Column(length = 50)
    private String prodImage3;
    @Column(length = 50)
    private String prodImage4;
    @Column(length = 4000)
    private String prodInfo;
    @Column(length = 50)
    private LocalDateTime prodRegdate;

    //Entity 객체를 DTO 객체로 변환하여 반환하는 메소드 - SELECT 명령 호출
    public ProductDTO toProductDTO(){
        ProductDTO product=new ProductDTO();

        product.setProdNo(prodNo);
        product.setProdType(prodType);
        product.setProdName(prodName);
        product.setProdPrice(prodPrice);
        product.setProdAmount(prodAmount);
        product.setProdImage1(prodImage1);
        product.setProdImage2(prodImage2);
        product.setProdImage3(prodImage3);
        product.setProdImage4(prodImage4);
        product.setProdInfo(prodInfo);
        product.setProdRegdate(prodRegdate);

        return product;
    }

}
