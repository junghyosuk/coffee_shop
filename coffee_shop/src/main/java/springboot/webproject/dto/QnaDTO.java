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
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;


@Entity
@Table(name = "qna")//
@Getter
@Setter
public class QnaDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int qnaNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "QNA_USERS_NO", referencedColumnName = "USERS_NO")
    private UsersDTO users; // QNA_USERS_NO 외래 키로 USERS와 조인

    //    private String usersName; //users 테이블의 회원이름 저장하기 위한 필드 - 작성자
//    private String usersEmail;
    private String qnaType; //문의 유형
    private String qnaTitle;
    private String qnaContent;
    private int qnaStatus;	//1: 미답변, 2: 답변완료
    //    private String qnaDate;
    @Column(name = "QNA_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime qnaDate;
    @Transient
    private int qnaUsersNo; // hidden으로 보내는 작성자 정보 필드 (전송용)

    public QnaDTO() {
    }

    public QnaDTO(int qnaNo, UsersDTO users,  String qnaType,
                  String qnaTitle, String qnaContent, int qnaStatus, String qnaDate) {
        super();
        this.qnaNo = qnaNo;
        this.users = users;
//        this.usersName = usersName;
//        this.usersEmail = usersEmail;
        this.qnaType = qnaType;
        this.qnaTitle = qnaTitle;
        this.qnaContent = qnaContent;
        this.qnaStatus = qnaStatus;
        this.qnaDate = LocalDateTime.parse(qnaDate);
    }

//    public UsersDTO getUsers() {
//        return users;
//    }
//
//    public void setUsers(UsersDTO users) {
//        this.users = users;
//    }
//
//    public int getQnaNo() {
//        return qnaNo;
//    }
//
//    public void setQnaNo(int qnaNo) {
//        this.qnaNo = qnaNo;
//    }
//
//
////    public String getUsersName() {
////        return usersName;
////    }
//
////    public void setUsersName(String usersName) {
////        this.usersName = usersName;
////    }
//
////    public String getUsersEmail() {
////        return usersEmail;
////    }
//
////    public void setUsersEmail(String usersEmail) {
////        this.usersEmail = usersEmail;
////    }
//
//    public String getQnaType() {
//        return qnaType;
//    }
//
//    public void setQnaType(String qnaType) {
//        this.qnaType = qnaType;
//    }
//
//    public String getQnaTitle() {
//        return qnaTitle;
//    }
//
//    public void setQnaTitle(String qnaTitle) {
//        this.qnaTitle = qnaTitle;
//    }
//
//    public String getQnaContent() {
//        return qnaContent;
//    }
//
//    public void setQnaContent(String qnaContent) {
//        this.qnaContent = qnaContent;
//    }
//
//    public int getQnaStatus() {
//        return qnaStatus;
//    }
//
//    public void setQnaStatus(int qnaStatus) {
//        this.qnaStatus = qnaStatus;
//    }
//
//    public LocalDateTime getQnaDate() {
//        return qnaDate;
//    }
//
////    public void setQnaDate(String qnaDate) {
////        this.qnaDate = LocalDateTime.parse(qnaDate);
////    }
//public void setQnaDate(LocalDateTime qnaDate) {
//    this.qnaDate = qnaDate;
//}
}