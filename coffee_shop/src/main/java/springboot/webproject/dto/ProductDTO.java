package springboot.webproject.dto;


import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import springboot.webproject.entity.ProductEntity;

import java.time.LocalDateTime;
import java.util.List;

/*
CREATE TABLE PRODUCT (
   PROD_NO NUMBER CONSTRAINT PROD_NO_PK PRIMARY KEY,
   PROD_TYPE NUMBER,
   PROD_NAME VARCHAR2(50),
   PROD_PRICE NUMBER,
   PROD_AMOUNT NUMBER,
   PROD_IMAGE1 VARCHAR2(1000),
   PROD_IMAGE2 VARCHAR2(1000),
   PROD_IMAGE3 VARCHAR2(1000),
   PROD_INFO VARCHAR2(2000),
   PROD_IN_DATE DATE DEFAULT SYSDATE
);

CREATE SEQUENCE PRODUCT_SEQ;

DESC product;

SELECT * FROM product;

COMMIT;

*/
@Data
public class ProductDTO {
    private Long prodNo; // 제품번호 (자동 생성)
    private int prodType; // 제품 타입
    private String prodName; // 제품명
    private int prodPrice; // 가격
    private int prodAmount; // 수량
    private MultipartFile prodImage1; // 메인 이미지 파일
    private MultipartFile prodImage2; // 서브 이미지 파일
    private String prodImage1Name; // 메인 이미지 파일명
    private String prodImage2Name; // 서브 이미지 파일명
    private String prodInfo; // 제품 정보
    private LocalDateTime prodRegdate; // 등록일시

    /// 주문 시 필요한 필드 추가
    private int orderQuantity; // 주문 수량
    private int totalPrice; // 총 가격

    // DTO → Entity 변환
    public ProductEntity toEntity(String mainImageName, String subImageName) {
        ProductEntity entity = new ProductEntity();
        entity.setProdNo(prodNo);
        entity.setProdType(prodType);
        entity.setProdName(prodName);
        entity.setProdPrice(prodPrice);
        entity.setProdAmount(prodAmount);
        entity.setProdImage1(mainImageName);
        entity.setProdImage2(subImageName);
        entity.setProdInfo(prodInfo);
        entity.setProdRegdate(LocalDateTime.now()); // 현재 시간으로 등록일시 설정
        return entity;
    }
}