package springboot.webproject.service;

import springboot.webproject.dto.QnaAnswer;

import java.util.List;

public interface QnaAnswerService {
    void createAnswer(QnaAnswer qnaAnswer); // 답변 생성
    List<QnaAnswer> getAnswersByQna(int qnaNo); // Qna에 대한 답변 목록 가져오기
}