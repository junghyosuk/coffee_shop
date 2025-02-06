package springboot.webproject.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.webproject.dto.QnaAnswer;
import springboot.webproject.dto.QnaDTO;
import springboot.webproject.repository.QnaAnswerRepository;
import springboot.webproject.repository.QnaRepository;

import java.util.List;

@Service
public class QnaAnswerServiceImpl implements QnaAnswerService {

    private final QnaAnswerRepository qnaAnswerRepository;
    private final QnaRepository qnaRepository;

    @Autowired
    public QnaAnswerServiceImpl(QnaAnswerRepository qnaAnswerRepository, QnaRepository qnaRepository) {
        this.qnaAnswerRepository = qnaAnswerRepository;
        this.qnaRepository = qnaRepository;
    }

    @Override
    public void createAnswer(QnaAnswer qnaAnswer) {
        if (qnaAnswer.getQna() == null) {
            throw new IllegalArgumentException("Qna must not be null when creating an answer.");
        }
        qnaAnswerRepository.save(qnaAnswer); // 답변 저장
    }


    @Override
    public List<QnaAnswer> getAnswersByQna(int qnaNo) {
        QnaDTO qna = new QnaDTO();
        qna.setQnaNo(qnaNo);
        List<QnaAnswer> answers = qnaAnswerRepository.findByQna(qna);
        System.out.println("답변 목록: " + answers);// 해당 Qna에 대한 답변을 조회
        return qnaAnswerRepository.findByQna(qna);
    }
}