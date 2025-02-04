package springboot.webproject.dto;


import jakarta.persistence.*;
import lombok.*;
import springboot.webproject.entity.ProductEntity;

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
@Table(name = "cartlist")
@Getter
@Setter
public class CartDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CART_USERS_ID", referencedColumnName = "USERS_ID")
    private UsersDTO users;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CART_PROD_NO", referencedColumnName = "PROD_NO")
    private ProductEntity product;

    private int cartQuantity;

    // 장바구니 상태 (0: 장바구니, 1: 주문완료)
    private int status;

    public CartDTO() {
    }

    public CartDTO(int cartNo, UsersDTO users, ProductEntity product, int cartQuantity, int status) {
        this.cartNo = cartNo;
        this.users = users;
        this.product = product;
        this.cartQuantity = cartQuantity;
        this.status = status;
    }
}


//@Entity
//@Table(name="cartlist")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//public class CartDTO {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long cartNo;
//
//    @Column(name = "cart_users_id")
//    private String cartusersId;
//
//    @Column(name = "cart_prod_no")
//    private int cartproductNo;
//
//    @Column(name = "cart_quantity")
//    private int cartQuantity;
//
//    @Transient
//    private ProductDTO product;  // 장바구니에서 상품 정보 표시용
//}
