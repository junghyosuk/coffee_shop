package springboot.webproject.dto;



/*이름             널?       유형
-------------- -------- --------------
NOTICE_NO      NOT NULL NUMBER
NOTICE_TITLE            VARCHAR2(1000)
NOTICE_CONTENT          VARCHAR2(2000)
NOTICE_STATUS           NUMBER(1)
NOTICE_DATE             DATE   */

/*
// 이걸로 다시 MySQL 만드세요.
 CREATE TABLE NOTICE (
    NOTICE_NO INT AUTO_INCREMENT PRIMARY KEY,
    NOTICE_TITLE VARCHAR(255),
    NOTICE_CONTENT TEXT,
    NOTICE_STATUS TINYINT,
    NOTICE_DATE DATETIME DEFAULT CURRENT_TIMESTAMP
); */


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Table(name = "notice")//
@Getter
@Setter
public class NoticeDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int noticeNo;
    private String noticeTitle;
    private String noticeContent;
    private int noticeStatus;
    @Column(name = "NOTICE_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime noticeDate;


    public NoticeDTO() {
        // TODO Auto-generated constructor stub
    }

    public NoticeDTO(int noticeNo, String noticeTitle, String noticeContent, int noticeStatus, String noticeDate) {
        super();
        this.noticeNo = noticeNo;
        this.noticeTitle = noticeTitle;
        this.noticeContent = noticeContent;
        this.noticeStatus = noticeStatus;
        this.noticeDate = LocalDateTime.parse(noticeDate);
    }

//    public int getNoticeNo() {
//        return noticeNo;
//    }
//
//    public void setNoticeNo(int noticeNo) {
//        this.noticeNo = noticeNo;
//    }
//
//    public String getNoticeTitle() {
//        return noticeTitle;
//    }
//
//    public void setNoticeTitle(String noticeTitle) {
//        this.noticeTitle = noticeTitle;
//    }
//
//    public String getNoticeContent() {
//        return noticeContent;
//    }
//
//    public void setNoticeContent(String noticeContent) {
//        this.noticeContent = noticeContent;
//    }
//
//    public int getNoticeStatus() {
//        return noticeStatus;
//    }
//
//    public void setNoticeStatus(int noticeStatus) {
//        this.noticeStatus = noticeStatus;
//    }
//
//    public LocalDateTime getNoticeDate() {
//        return noticeDate;
//    }
//
//    public void setNoticeDate(String noticeDate) {
//        this.noticeDate = LocalDateTime.parse(noticeDate);
//    }
//


}