package springboot.webproject.dto;


import lombok.Data;
import springboot.webproject.entity.ProductEntity;

import java.time.LocalDateTime;

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
   PROD_IMAGE4 VARCHAR2(1000),
   PROD_INFO VARCHAR2(2000),
   PROD_IN_DATE DATE DEFAULT SYSDATE
);

CREATE SEQUENCE PRODUCT_SEQ;

DESC product;

SELECT * FROM product;

COMMIT;

*/
//@Entity
@Data
public class ProductDTO {
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prodNo;
    private int prodType;
    private String prodName;
    private int prodPrice;
    private int prodAmount;
    private String prodImage1;
    private String prodImage2;
    private String prodImage3;
    private String prodImage4;
    private String prodInfo;
    private LocalDateTime prodRegdate;

    //DTO 객체를 Entity 객체로 변환하여 반환하는 메소드 - INSERT 명령 또는 UPDATE 명령 사용시 호출
    public ProductEntity toProductEntity(){
        ProductEntity entity=new ProductEntity();
        entity.setProdNo(prodNo);
        entity.setProdType(prodType);
        entity.setProdName(prodName);
        entity.setProdPrice(prodPrice);
        entity.setProdAmount(prodAmount);
        entity.setProdImage1(prodImage1);
        entity.setProdImage2(prodImage2);
        entity.setProdImage3(prodImage3);
        entity.setProdImage4(prodImage4);
        entity.setProdInfo(prodInfo);

        return entity;
    }

}
