package springboot.webproject.dto;


import jakarta.persistence.*;

/*
 CREATE TABLE USERS (
    USERS_NO NUMBER CONSTRAINT USERS_NO_PK PRIMARY KEY,
    USERS_ID VARCHAR2(30) UNIQUE,
    USERS_PW VARCHAR2(200),
    USERS_NAME VARCHAR2(30),
    USERS_ZIPCODE VARCHAR2(10),
    USERS_ADDRESS1 VARCHAR2(200),
    USERS_ADDRESS2 VARCHAR2(100),
    USERS_PHONE VARCHAR2(20),
    USERS_EMAIL VARCHAR2(50),
    USERS_SIGNDATE DATE DEFAULT SYSDATE,
    USERS_LAST_LOGIN DATE DEFAULT SYSDATE,
    USERS_STATUS NUMBER(1)
);

CREATE SEQUENCE USERS_SEQ;

DESC USERS;

SELECT * FROM USERS;


	4.	@GeneratedValue
	•	기본 키 값 생성 전략을 지정합니다.
	•	strategy 속성을 사용해 다음 중 하나를 선택:
	•	GenerationType.IDENTITY: 데이터베이스에서 자동 증가 값을 사용.
	•	GenerationType.SEQUENCE: 지정된 시퀀스를 사용 (Oracle과 같은 DB에 적합).
	•	GenerationType.TABLE: 키를 저장하는 별도의 테이블 사용.
	•	GenerationType.AUTO: 데이터베이스에 따라 자동으로 전략 선택.
 */
@Entity
@Table(name = "users")//	엔티티 클래스에 @Table(name = "users")가 누락된 경우 발생할 수 있습니다.UsersDTO 클래스에 @Table 애노테이션을 추가하고, 실제 테이블 이름을 명시합니다.
public class UsersDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int usersNo;
    private String usersId;
    private String usersPw;
    private String usersName;
    private String usersZipcode;
    private String usersAddress1;
    private String usersAddress2;
    private String usersPhone;
    private String usersEmail;
    private String usersSigndate;
    private String usersLastLogin;
    private int usersStatus;

    public UsersDTO() {
        // TODO Auto-generated constructor stub
    }

    public int getUsersNo() {
        return usersNo;
    }
    public void setUsersNo(int usersNo) {
        this.usersNo = usersNo;
    }
    public String getUsersId() {
        return usersId;
    }
    public void setUsersId(String usersId) {
        this.usersId = usersId;
    }
    public String getUsersPw() {
        return usersPw;
    }
    public void setUsersPw(String usersPw) {
        this.usersPw = usersPw;
    }
    public String getUsersName() {
        return usersName;
    }
    public void setUsersName(String usersName) {
        this.usersName = usersName;
    }
    public String getUsersZipcode() {
        return usersZipcode;
    }
    public void setUsersZipcode(String usersZipcode) {
        this.usersZipcode = usersZipcode;
    }
    public String getUsersAddress1() {
        return usersAddress1;
    }
    public void setUsersAddress1(String usersAddress1) {
        this.usersAddress1 = usersAddress1;
    }
    public String getUsersAddress2() {
        return usersAddress2;
    }
    public void setUsersAddress2(String usersAddress2) {
        this.usersAddress2 = usersAddress2;
    }
    public String getUsersPhone() {
        return usersPhone;
    }
    public void setUsersPhone(String usersPhone) {
        this.usersPhone = usersPhone;
    }
    public String getUsersEmail() {
        return usersEmail;
    }
    public void setUsersEmail(String usersEmail) {
        this.usersEmail = usersEmail;
    }
    public String getUsersSigndate() {
        return usersSigndate;
    }
    public void setUsersSigndate(String usersSigndate) {
        this.usersSigndate = usersSigndate;
    }
    public String getUsersLastLogin() {
        return usersLastLogin;
    }
    public void setUsersLastLogin(String usersLastLogin) {
        this.usersLastLogin = usersLastLogin;
    }
    public int getUsersStatus() {
        return usersStatus;
    }
    public void setUsersStatus(int usersStatus) {
        this.usersStatus = usersStatus;
    }



}
/*
CREATE TABLE USERS (
    USERS_NO INT NOT NULL AUTO_INCREMENT,
    USERS_ID VARCHAR(30) UNIQUE,
    USERS_PW VARCHAR(200),
    USERS_NAME VARCHAR(30),
    USERS_ZIPCODE VARCHAR(10),
    USERS_ADDRESS1 VARCHAR(200),
    USERS_ADDRESS2 VARCHAR(100),
    USERS_PHONE VARCHAR(20),
    USERS_EMAIL VARCHAR(50),
    USERS_SIGNDATE DATETIME DEFAULT CURRENT_TIMESTAMP,
    USERS_LAST_LOGIN DATETIME DEFAULT CURRENT_TIMESTAMP,
    USERS_STATUS TINYINT(1),
    PRIMARY KEY (USERS_NO)
);
CREATE TABLE PRODUCT (
   PROD_NO INT NOT NULL AUTO_INCREMENT,
   PROD_TYPE INT,
   PROD_NAME VARCHAR(50),
   PROD_PRICE DECIMAL(10,2),
   PROD_AMOUNT INT,
   PROD_IMAGE1 VARCHAR(1000),
   PROD_IMAGE2 VARCHAR(1000),
   PROD_IMAGE3 VARCHAR(1000),
   PROD_IMAGE4 VARCHAR(1000),
   PROD_INFO VARCHAR(2000),
   PROD_IN_DATE DATETIME DEFAULT CURRENT_TIMESTAMP,
   PRIMARY KEY (PROD_NO)
);

CREATE TABLE REVIEW (
    REVIEW_NO INT NOT NULL AUTO_INCREMENT,
    REVIEW_TITLE VARCHAR(1000),
    REVIEW_CONTENT VARCHAR(2000),
    REVIEW_STATUS TINYINT(1),
    REVIEW_DATE DATETIME DEFAULT CURRENT_TIMESTAMP,
    REVIEW_PROD_NO INT,
    REVIEW_USERS_NO INT,
    REVIEW_IMAGE VARCHAR(100),
    PRIMARY KEY (REVIEW_NO),
    CONSTRAINT REVIEW_PROD_NO_FK FOREIGN KEY (REVIEW_PROD_NO) REFERENCES PRODUCT(PROD_NO),
    CONSTRAINT REVIEW_USERS_NO_FK FOREIGN KEY (REVIEW_USERS_NO) REFERENCES USERS(USERS_NO)
);
CREATE TABLE QNA (
    QNA_NO INT NOT NULL AUTO_INCREMENT,
    QNA_USERS_NO INT,
    QNA_TYPE VARCHAR(300),
    QNA_TITLE VARCHAR(1000),
    QNA_CONTENT VARCHAR(2000),
    QNA_STATUS TINYINT(1),
    QNA_DATE DATETIME DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (QNA_NO),
    CONSTRAINT QNA_USERS_NO_FK FOREIGN KEY (QNA_USERS_NO) REFERENCES USERS(USERS_NO)
);
CREATE TABLE orders (
    orders_no INT NOT NULL AUTO_INCREMENT,
    orders_prod_no INT,
    orders_users_id VARCHAR(30),
    orders_users_name VARCHAR(30),
    orders_users_phone VARCHAR(20),
    orders_users_email VARCHAR(30),
    orders_users_zipcode VARCHAR(10),
    orders_users_address1 VARCHAR(200),
    orders_users_address2 VARCHAR(100),
    orders_request VARCHAR(100),
    orders_payment VARCHAR(20),
    orders_cart_amount DECIMAL(20, 2),
    orders_cart_price DECIMAL(20, 2),
    orders_date DATETIME,
    orders_status TINYINT(1),
    PRIMARY KEY (orders_no)
);
CREATE TABLE notice (
    notice_no INT NOT NULL AUTO_INCREMENT,
    notice_title VARCHAR(1000),
    notice_content VARCHAR(2000),
    notice_status TINYINT(1),
    notice_date DATETIME,
    PRIMARY KEY (notice_no)
);
CREATE TABLE cartlist (
    cart_no INT NOT NULL AUTO_INCREMENT,
    cart_users_id VARCHAR(20),
    cart_prod_no INT,
    cart_quantity INT,
    PRIMARY KEY (cart_no),
    CONSTRAINT cartlist_cart_prod_no_fk FOREIGN KEY (cart_prod_no) REFERENCES product(prod_no),
    CONSTRAINT cartlist_cart_users_id_fk FOREIGN KEY (cart_users_id) REFERENCES users(users_id)
);
 */