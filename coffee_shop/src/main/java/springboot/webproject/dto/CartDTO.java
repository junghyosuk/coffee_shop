package springboot.webproject.dto;


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
//@Entity
public class CartDTO {
    //@Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartNo;
    private String cartusersId;
    private int cartproductNo;
    private int cartQuantity;

    public CartDTO() {
        // TODO Auto-generated constructor stub
    }

    public CartDTO(int cartNo, String cartusersId, int cartproductNo, int cartQuantity) {
        super();
        this.cartNo = cartNo;
        this.cartusersId = cartusersId;
        this.cartproductNo = cartproductNo;
        this.cartQuantity = cartQuantity;
    }

    public int getCartNo() {
        return cartNo;
    }

    public void setCartNo(int cartNo) {
        this.cartNo = cartNo;
    }

    public String getCartusersId() {
        return cartusersId;
    }

    public void setCartusersId(String cartusersId) {
        this.cartusersId = cartusersId;
    }

    public int getCartproductNo() {
        return cartproductNo;
    }

    public void setCartproductNo(int cartproductNo) {
        this.cartproductNo = cartproductNo;
    }

    public int getCartQuantity() {
        return cartQuantity;
    }

    public void setCartQuantity(int cartQuantity) {
        this.cartQuantity = cartQuantity;
    }




}