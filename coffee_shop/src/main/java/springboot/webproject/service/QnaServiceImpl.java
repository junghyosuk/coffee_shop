package springboot.webproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.webproject.dto.QnaDTO;
import springboot.webproject.repository.QnaRepository;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class QnaServiceImpl implements QnaService {

    private final QnaRepository qnaRepository;

    @Override
    public QnaDTO createQna(QnaDTO qna) {
        return qnaRepository.save(qna);
    }

    @Override
    public Page<QnaDTO> getActiveQna(int qnaNo, int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        return qnaRepository.findAllByQnaNoLessThanEqualOrderByQnaNoDesc(qnaNo,pageable);
    }

    @Override
    public Optional<QnaDTO> getQnaDetail(int qnaNo) {
        return qnaRepository.findByQnaNo(qnaNo);
    }

    @Override
    public Optional<QnaDTO> getQnaWithUsers(int qnaNo) {
        return qnaRepository.findByQnaNoWithUsers(qnaNo);
    }

    @Override
    public QnaDTO getQnaByQnaNo(int qnaNo) {
        return  qnaRepository.findByQnaNo(qnaNo)
                .orElseThrow(() -> new RuntimeException("Qna not found with qnaNo: " + qnaNo));
    }
}