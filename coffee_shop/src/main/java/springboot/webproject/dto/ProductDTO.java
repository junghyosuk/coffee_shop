package springboot.webproject.dto;


import lombok.Data;

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
    private int prodNo;
    private int prodType;
    private String prodName;
    private int prodPrice;
    private int prodAmount;
    private String prodImage1;
    private String prodImage2;
    private String prodImage3;
    private String prodImage4;
    private String prodInfo;
    private String prodInDate;

}
