package springboot.webproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.webproject.dto.QnaAnswer;
import springboot.webproject.dto.QnaDTO;

import java.util.List;


public interface QnaAnswerRepository extends JpaRepository<QnaAnswer, Integer> {
    // 특정 Qna에 대한 답변을 가져오는 메서드
    List<QnaAnswer> findByQna(QnaDTO qna);
}