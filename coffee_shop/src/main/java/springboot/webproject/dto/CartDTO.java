package springboot.webproject.dto;


import jakarta.persistence.*;
import lombok.*;

/*
CREATE TABLE CARTLIST (
   CART_NO NUMBER CONSTRAINT CART_NO_PK PRIMARY KEY,
   CART_USERS_ID VARCHAR2(20),
   CART_PROD_NO NUMBER,
   CART_QUANTITY NUMBER(20),
   CONSTRAINT CARTLIST_CART_PROD_NO_FK FOREIGN KEY (CART_PROD_NO) REFERENCES PRODUCT(PROD_NO),
   CONSTRAINT CARTLIST_CART_USERS_ID_FK FOREIGN KEY (CART_USERS_ID) REFERENCES USERS(USERS_ID)
);

이름            널?       유형
------------- -------- ------------
CART_NO       NOT NULL NUMBER
CART_USERS_ID          VARCHAR2(20)
CART_PROD_NO           NUMBER
CART_QUANTITY          NUMBER(20)
 */
@Entity
@Table(name="cartlist")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartNo;

    @Column(name = "cart_users_id")
    private String cartusersId;

    @Column(name = "cart_prod_no")
    private int cartproductNo;

    @Column(name = "cart_quantity")
    private int cartQuantity;

    @Transient
    private ProductDTO product;  // 장바구니에서 상품 정보 표시용
}
