package springboot.webproject.dto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Entity
@Getter
@Setter
public class QnaAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int answerNo;
    @Column(length = 2000)
    private String content;// 답변 내용
    private LocalDateTime createdDate = LocalDateTime.now(); // 작성 시간

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "qna_no")
    private QnaDTO qna; // 답변이 속한 질문


}
