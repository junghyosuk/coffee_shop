package springboot.webproject.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.webproject.dto.QnaAnswer;
import springboot.webproject.dto.QnaDTO;
import springboot.webproject.repository.QnaAnswerRepository;

import java.util.List;

@Service
public class QnaAnswerServiceImpl implements QnaAnswerService {

    private final QnaAnswerRepository qnaAnswerRepository;

    @Autowired
    public QnaAnswerServiceImpl(QnaAnswerRepository qnaAnswerRepository) {
        this.qnaAnswerRepository = qnaAnswerRepository;
    }

    @Override
    public void createAnswer(QnaAnswer qnaAnswer) {
        qnaAnswerRepository.save(qnaAnswer); // 답변 저장
    }


    @Override
    public List<QnaAnswer> getAnswersByQna(int qnaNo) {
        QnaDTO qna = new QnaDTO();
        qna.setQnaNo(qnaNo); // 해당 Qna에 대한 답변을 조회
        return qnaAnswerRepository.findByQna(qna);
    }
}