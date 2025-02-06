package springboot.webproject.service;

import org.springframework.data.domain.Page;
import springboot.webproject.dto.NoticeDTO;
import springboot.webproject.dto.QnaDTO;

import java.util.Optional;

public interface QnaService {
    //기본 목록과 페이징 처리 하는 메소드
    QnaDTO createQna(QnaDTO qna);
    Page<QnaDTO> getActiveQna(int qnaNo, int pageNum, int pageSize);
    // 디테일을 보는 메소드
    Optional<QnaDTO> getQnaDetail(int qnaNo);
    // QnaNo로 Qna와 Users 데이터를 함께 조회
    Optional<QnaDTO> getQnaWithUsers(int qnaNo);
    QnaDTO getQnaByQnaNo(int qnaNo);
}