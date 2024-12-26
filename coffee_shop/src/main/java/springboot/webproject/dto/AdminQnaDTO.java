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
public class AdminQnaDTO {
   // @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int qnaNo;
    private int qnaUsersno;
    private String qnaType;
    private String qnaTitle;
    private String qnaContent;
    private String qnaDate;
    private int qnaStatus;

    private String usersName;
    private String usersEmail;

    public AdminQnaDTO() {
        // TODO Auto-generated constructor stub
    }


    public int getQnaNo() {
        return qnaNo;
    }
    public void setQnaNo(int qnaNo) {
        this.qnaNo = qnaNo;
    }
    public int getQnaUsersno() {
        return qnaUsersno;
    }
    public void setQnaUsersno(int qnaUsersno) {
        this.qnaUsersno = qnaUsersno;
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

    public String getQnaDate() {
        return qnaDate;
    }


    public void setQnaDate(String qnaDate) {
        this.qnaDate = qnaDate;
    }


    public int getQnaStatus() {
        return qnaStatus;
    }
    public void setQnaStatus(int qnaStatus) {
        this.qnaStatus = qnaStatus;
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

}
