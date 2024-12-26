package springboot.webproject.dto;


/*
이름                    널?       유형
--------------------- -------- -------------
ORDERS_NO             NOT NULL NUMBER
ORDERS_PROD_NO                 NUMBER
ORDERS_USERS_ID                VARCHAR2(30)
ORDERS_USERS_NAME              VARCHAR2(30)
ORDERS_USERS_PHONE             VARCHAR2(20)
ORDERS_USERS_EMAIL             VARCHAR2(30)
ORDERS_USERS_ZIPCODE           VARCHAR2(10)
ORDERS_USERS_ADDRESS1          VARCHAR2(200)
ORDERS_USERS_ADDRESS2          VARCHAR2(100)
ORDERS_REQUEST                 VARCHAR2(100)
ORDERS_PAYMENT                 VARCHAR2(20)
ORDERS_CART_AMOUNT             NUMBER(20)
ORDERS_CART_PRICE              NUMBER(20)
ORDERS_DATE                    DATE
ORDERS_STATUS                  NUMBER(1)     */



//@Entity
public class AdminOrdersDTO {
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
    private String ordersDate;
    private int ordersStatus;


    private String prodName;
    private int prodPrice;
    public AdminOrdersDTO() {
        // TODO Auto-generated constructor stub
    }



    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public int getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(int prodPrice) {
        this.prodPrice = prodPrice;
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

    public String getOrdersDate() {
        return ordersDate;
    }

    public void setOrdersDate(String ordersDate) {
        this.ordersDate = ordersDate;
    }

    public int getOrdersStatus() {
        return ordersStatus;
    }

    public void setOrdersStatus(int ordersStatus) {
        this.ordersStatus = ordersStatus;
    }


}
