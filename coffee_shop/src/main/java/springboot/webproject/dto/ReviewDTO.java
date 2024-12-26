package springboot.webproject.dto;


/*
CREATE TABLE REVIEW (
    REVIEW_NO NUMBER CONSTRAINT REVIEW_NO_PK PRIMARY KEY,
    REVIEW_TITLE VARCHAR2(1000),
    REVIEW_CONTENT VARCHAR2(2000),
    REVIEW_STATUS NUMBER(1),
    REVIEW_DATE DATE DEFAULT SYSDATE,
    REVIEW_PROD_NO NUMBER CONSTRAINT REVIEW_PROD_NO_FK REFERENCES PRODUCT(PROD_NO),
    REVIEW_USERS_NO NUMBER CONSTRAINT REVIEW_USERS_NO_FK REFERENCES USERS(USERS_NO),
    REVIEW_IMAGE VARCHAR2(100)
);

CREATE SEQUENCE REVIEW_SEQ;

DESC REVIEW;

SELECT * FROM REVIEW;

이름              널?       유형
--------------- -------- --------------
REVIEW_NO       NOT NULL NUMBER
REVIEW_TITLE             VARCHAR2(1000)
REVIEW_CONTENT           VARCHAR2(2000)
REVIEW_STATUS            NUMBER(1)
REVIEW_DATE              DATE
REVIEW_PROD_NO           NUMBER
REVIEW_USERS_NO          NUMBER
REVIEW_IMAGE             VARCHAR2(100)
*/
//@Entity
public class ReviewDTO {
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewNo;
    private String reviewTitle;
    private String reviewContent;
    private int reviewStatus;//0:삭제글,1:일반글
    private String reviewDate;
    private int reviewProdNo;
    private int reviewUsersNo;//로그인 사용자의 회원번호
    private String usersName;//users 테이블의 회원이름 저장하기 위한 필드 - 작성자
    private String reviewImage;

    public ReviewDTO() {
        // TODO Auto-generated constructor stub
    }

    public int getReviewNo() {
        return reviewNo;
    }

    public void setReviewNo(int reviewNo) {
        this.reviewNo = reviewNo;
    }

    public String getReviewTitle() {
        return reviewTitle;
    }

    public void setReviewTitle(String reviewTitle) {
        this.reviewTitle = reviewTitle;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    public int getReviewStatus() {
        return reviewStatus;
    }

    public void setReviewStatus(int reviewStatus) {
        this.reviewStatus = reviewStatus;
    }

    public String getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(String reviewDate) {
        this.reviewDate = reviewDate;
    }

    public int getReviewProdNo() {
        return reviewProdNo;
    }

    public void setReviewProdNo(int reviewProdNo) {
        this.reviewProdNo = reviewProdNo;
    }

    public int getReviewUsersNo() {
        return reviewUsersNo;
    }

    public void setReviewUsersNo(int reviewUsersNo) {
        this.reviewUsersNo = reviewUsersNo;
    }

    public String getUsersName() {
        return usersName;
    }

    public void setUsersName(String usersName) {
        this.usersName = usersName;
    }

    public String getReviewImage() {
        return reviewImage;
    }

    public void setReviewImage(String reviewImage) {
        this.reviewImage = reviewImage;
    }


}
