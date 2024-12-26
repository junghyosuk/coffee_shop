package springboot.webproject.dto;



/*이름             널?       유형
-------------- -------- --------------
NOTICE_NO      NOT NULL NUMBER
NOTICE_TITLE            VARCHAR2(1000)
NOTICE_CONTENT          VARCHAR2(2000)
NOTICE_STATUS           NUMBER(1)
NOTICE_DATE             DATE   */

/*CREATE TABLE NOTICE(NOTICE_NO NUMBER PRIMARY KEY, NOTICE_TITLE VARCHAR2(1000), NOTICE_CONTENT
VARCHAR2(2000), NOTICE_STATUS NUMBER(1), NOTICE_DATE DATE);

create sequence NOTICE; */


//@Entity
public class NoticeDTO {
   //@Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int noticeNo;
    private String noticeTitle;
    private String noticeContent;
    private int noticeStatus;
    private String noticeDate;

    public NoticeDTO() {
        // TODO Auto-generated constructor stub
    }

    public NoticeDTO(int noticeNo, String noticeTitle, String noticeContent, int noticeStatus, String noticeDate) {
        super();
        this.noticeNo = noticeNo;
        this.noticeTitle = noticeTitle;
        this.noticeContent = noticeContent;
        this.noticeStatus = noticeStatus;
        this.noticeDate = noticeDate;
    }

    public int getNoticeNo() {
        return noticeNo;
    }

    public void setNoticeNo(int noticeNo) {
        this.noticeNo = noticeNo;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public int getNoticeStatus() {
        return noticeStatus;
    }

    public void setNoticeStatus(int noticeStatus) {
        this.noticeStatus = noticeStatus;
    }

    public String getNoticeDate() {
        return noticeDate;
    }

    public void setNoticeDate(String noticeDate) {
        this.noticeDate = noticeDate;
    }



}
