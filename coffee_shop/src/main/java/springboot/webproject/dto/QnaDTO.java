package springboot.webproject.dto;



/*CREATE TABLE QNA (
QNA_NO NUMBER CONSTRAINT QNA_NO_PK PRIMARY KEY,
QNA_USERS_NO NUMBER CONSTRAINT QNA_USERS_NO_FK REFERENCES USERS(USERS_NO),
QNA_TYPE VARCHAR2(300),
QNA_TITLE VARCHAR2(1000),
QNA_CONTENT VARCHAR2(2000),
QNA_STATUS NUMBER(1),
QNA_DATE DATE DEFAULT SYSDATE);
*/
//@Entity
public class QnaDTO {
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int qnaNo;
    private int qnaUsersNo;	//로그인 사용자의 회원번호
    private String usersName; //users 테이블의 회원이름 저장하기 위한 필드 - 작성자
    private String usersEmail;
    private String qnaType; //문의 유형
    private String qnaTitle;
    private String qnaContent;
    private int qnaStatus;	//1: 미답변, 2: 답변완료
    private String qnaDate;

    public QnaDTO() {
    }

    public QnaDTO(int qnaNo, int qnaUsersNo, String usersName, String usersEmail, String qnaType,
                  String qnaTitle, String qnaContent, int qnaStatus, String qnaDate) {
        super();
        this.qnaNo = qnaNo;
        this.qnaUsersNo = qnaUsersNo;
        this.usersName = usersName;
        this.usersEmail = usersEmail;
        this.qnaType = qnaType;
        this.qnaTitle = qnaTitle;
        this.qnaContent = qnaContent;
        this.qnaStatus = qnaStatus;
        this.qnaDate = qnaDate;
    }

    public int getQnaNo() {
        return qnaNo;
    }

    public void setQnaNo(int qnaNo) {
        this.qnaNo = qnaNo;
    }

    public int getQnaUsersNo() {
        return qnaUsersNo;
    }

    public void setQnaUsersNo(int qnaUsersNo) {
        this.qnaUsersNo = qnaUsersNo;
    }

    public String getUsersName() {
        return usersName;
    }

    public void setUsersName(String usersName) {
        this.usersName = usersName;
    }

    public String getUsersEmail() {
        return usersEmail;
    }

    public void setUsersEmail(String usersEmail) {
        this.usersEmail = usersEmail;
    }

    public String getQnaType() {
        return qnaType;
    }

    public void setQnaType(String qnaType) {
        this.qnaType = qnaType;
    }

    public String getQnaTitle() {
        return qnaTitle;
    }

    public void setQnaTitle(String qnaTitle) {
        this.qnaTitle = qnaTitle;
    }

    public String getQnaContent() {
        return qnaContent;
    }

    public void setQnaContent(String qnaContent) {
        this.qnaContent = qnaContent;
    }

    public int getQnaStatus() {
        return qnaStatus;
    }

    public void setQnaStatus(int qnaStatus) {
        this.qnaStatus = qnaStatus;
    }

    public String getQnaDate() {
        return qnaDate;
    }

    public void setQnaDate(String qnaDate) {
        this.qnaDate = qnaDate;
    }
}
