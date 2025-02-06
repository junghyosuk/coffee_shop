package springboot.webproject.dto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
@Entity
@Getter
@Setter
public class QnaAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int answerNo;
    @Column(length = 2000)
    private String answerContent;// 답변 내용
    @Column(name = "ANSWER_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime answerDate;
//    private LocalDateTime answerDate = LocalDateTime.now(); // 작성 시간

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "qna_no")
    private QnaDTO qna; // 답변이 속한 질문


}
/*
CREATE TABLE qna_answer (
    answer_no INT AUTO_INCREMENT PRIMARY KEY,      -- 답변 고유 번호
    answer_content VARCHAR(2000) NOT NULL,                 -- 답변 내용
    answer_date DATETIME DEFAULT CURRENT_TIMESTAMP, -- 작성일
    qna_no INT,                                    -- 질문 번호 (foreign key)
    FOREIGN KEY (qna_no) REFERENCES qna(qna_no)     -- qna 테이블의 qna_no 컬럼과 연결
);
*/
