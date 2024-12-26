package springboot.webproject.dto;



//Create table product(PROD_NO NUMBER(4) CONSTRAINT PRODUCT_NO_PK PRIMARY KEY,PROD_TYPE Number(4),PROD_NAME VARCHAR2(100),
//                    PROD_PRICE number(8),PROD_AMOUNT number(4),PROD_IMAGE VARCHAR2(1000),PROD_INFO VARCHAR2(2000),
//                    PROD_IN_DATE date);



//@Entity
public class AdminProductDTO {
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







    public AdminProductDTO(int prodNo, int prodType, String prodName, int prodPrice, int prodAmount, String prodImage1,
                           String prodImage2, String prodImage3, String prodImage4, String prodInfo, String prodInDate) {
        super();
        this.prodNo = prodNo;
        this.prodType = prodType;
        this.prodName = prodName;
        this.prodPrice = prodPrice;
        this.prodAmount = prodAmount;
        this.prodImage1 = prodImage1;
        this.prodImage2 = prodImage2;
        this.prodImage3 = prodImage3;
        this.prodImage4 = prodImage4;
        this.prodInfo = prodInfo;
        this.prodInDate = prodInDate;
    }

    public String getProdImage1() {
        return prodImage1;
    }

    public void setProdImage1(String prodImage1) {
        this.prodImage1 = prodImage1;
    }

    public String getProdImage2() {
        return prodImage2;
    }

    public void setProdImage2(String prodImage2) {
        this.prodImage2 = prodImage2;
    }

    public String getProdImage3() {
        return prodImage3;
    }

    public void setProdImage3(String prodImage3) {
        this.prodImage3 = prodImage3;
    }

    public String getProdImage4() {
        return prodImage4;
    }

    public void setProdImage4(String prodImage4) {
        this.prodImage4 = prodImage4;
    }

    public AdminProductDTO() {
        // TODO Auto-generated constructor stub
    }

    public int getProdNo() {
        return prodNo;
    }
    public void setProdNo(int prodNo) {
        this.prodNo = prodNo;
    }
    public int getProdType() {
        return prodType;
    }
    public void setProdType(int prodType) {
        this.prodType = prodType;
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
    public int getProdAmount() {
        return prodAmount;
    }
    public void setProdAmount(int prodAmount) {
        this.prodAmount = prodAmount;
    }

    public String getProdInfo() {
        return prodInfo;
    }
    public void setProdInfo(String prodInfo) {
        this.prodInfo = prodInfo;
    }
    public String getProdInDate() {
        return prodInDate;
    }
    public void setProdInDate(String prodInDate) {
        this.prodInDate = prodInDate;
    }





}
