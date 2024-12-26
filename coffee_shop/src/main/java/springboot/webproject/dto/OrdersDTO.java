package springboot.webproject.dto;


/*
 CREATE TABLE ORDERS (
    ORDERS_NO NUMBER(20) CONSTRAINT ORDERS_NO_PK PRIMARY KEY NOT NULL,
    ORDERS_PROD_NO NUMBER(20),
    ORDERS_USERS_ID VARCHAR2(50) ,
    ORDERS_USERS_NAME VARCHAR2(30) ,
    ORDERS_USERS_PHONE VARCHAR2(20) ,
    ORDERS_USERS_EMAIL VARCHAR2(50) ,
    ORDERS_USERS_ZIPCODE VARCHAR2(10) ,
    ORDERS_USERS_ADDRESS1 VARCHAR2(200) ,
    ORDERS_USERS_ADDRESS2 VARCHAR2(100) ,
    ORDERS_REQUEST VARCHAR2(100),
    ORDERS_PAYMENT VARCHAR2(20) ,
    ORDERS_CART_AMOUNT NUMBER(20) ,
    ORDERS_CART_PRICE NUMBER(20),
    ORDERS_DATE DATE ,
    ORDERS_STATUS NUMBER(1)
);

CREATE SEQUENCE ORDERS_SEQ;

 */


import java.util.Date;

//@Entity
public class OrdersDTO {
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ordersNo;
    private int ordersProdNo;
    private String ordersUsersId;
    private String ordersUsersName;
    private String ordersUsersPhone;
    private String ordersUsersEmail;
    private String ordersUsersZipcode;
    private String ordersUsersAddress1;
    private String ordersUsersAddress2;
    private String ordersRequest;
    private String ordersPayment;
    private int ordersCartAmount;
    private int ordersCartPrice;
    private Date ordersDate;
    private int ordersStatus;

    public OrdersDTO() {
        // TODO Auto-generated constructor stub
    }

    public OrdersDTO(int ordersNo, int ordersProdNo, String ordersUsersId, String ordersUsersName, String ordersUsersPhone,
                     String ordersUsersEmail, String ordersUsersZipcode, String ordersUsersAddress1, String ordersUsersAddress2,
                     String ordersRequest, String ordersPayment, int ordersCartAmount, int ordersCartPrice, Date ordersDate,
                     int ordersStatus) {
        super();
        this.ordersNo = ordersNo;
        this.ordersProdNo = ordersProdNo;
        this.ordersUsersId = ordersUsersId;
        this.ordersUsersName = ordersUsersName;
        this.ordersUsersPhone = ordersUsersPhone;
        this.ordersUsersEmail = ordersUsersEmail;
        this.ordersUsersZipcode = ordersUsersZipcode;
        this.ordersUsersAddress1 = ordersUsersAddress1;
        this.ordersUsersAddress2 = ordersUsersAddress2;
        this.ordersRequest = ordersRequest;
        this.ordersPayment = ordersPayment;
        this.ordersCartAmount = ordersCartAmount;
        this.ordersCartPrice = ordersCartPrice;
        this.ordersDate = ordersDate;
        this.ordersStatus = ordersStatus;
    }

    public int getOrdersNo() {
        return ordersNo;
    }

    public void setOrdersNo(int ordersNo) {
        this.ordersNo = ordersNo;
    }

    public int getOrdersProdNo() {
        return ordersProdNo;
    }

    public void setOrdersProdNo(int ordersProdNo) {
        this.ordersProdNo = ordersProdNo;
    }

    public String getOrdersUsersId() {
        return ordersUsersId;
    }

    public void setOrdersUsersId(String ordersUsersId) {
        this.ordersUsersId = ordersUsersId;
    }

    public String getOrdersUsersName() {
        return ordersUsersName;
    }

    public void setOrdersUsersName(String ordersUsersName) {
        this.ordersUsersName = ordersUsersName;
    }

    public String getOrdersUsersPhone() {
        return ordersUsersPhone;
    }

    public void setOrdersUsersPhone(String ordersUsersPhone) {
        this.ordersUsersPhone = ordersUsersPhone;
    }

    public String getOrdersUsersEmail() {
        return ordersUsersEmail;
    }

    public void setOrdersUsersEmail(String ordersUsersEmail) {
        this.ordersUsersEmail = ordersUsersEmail;
    }

    public String getOrdersUsersZipcode() {
        return ordersUsersZipcode;
    }

    public void setOrdersUsersZipcode(String ordersUsersZipcode) {
        this.ordersUsersZipcode = ordersUsersZipcode;
    }

    public String getOrdersUsersAddress1() {
        return ordersUsersAddress1;
    }

    public void setOrdersUsersAddress1(String ordersUsersAddress1) {
        this.ordersUsersAddress1 = ordersUsersAddress1;
    }

    public String getOrdersUsersAddress2() {
        return ordersUsersAddress2;
    }

    public void setOrdersUsersAddress2(String ordersUsersAddress2) {
        this.ordersUsersAddress2 = ordersUsersAddress2;
    }

    public String getOrdersRequest() {
        return ordersRequest;
    }

    public void setOrdersRequest(String ordersRequest) {
        this.ordersRequest = ordersRequest;
    }

    public String getOrdersPayment() {
        return ordersPayment;
    }

    public void setOrdersPayment(String ordersPayment) {
        this.ordersPayment = ordersPayment;
    }

    public int getOrdersCartAmount() {
        return ordersCartAmount;
    }

    public void setOrdersCartAmount(int ordersCartAmount) {
        this.ordersCartAmount = ordersCartAmount;
    }

    public int getOrdersCartPrice() {
        return ordersCartPrice;
    }

    public void setOrdersCartPrice(int ordersCartPrice) {
        this.ordersCartPrice = ordersCartPrice;
    }

    public Date getOrdersDate() {
        return ordersDate;
    }

    public void setOrdersDate(Date ordersDate) {
        this.ordersDate = ordersDate;
    }

    public int getOrdersStatus() {
        return ordersStatus;
    }

    public void setOrdersStatus(int ordersStatus) {
        this.ordersStatus = ordersStatus;
    }



}