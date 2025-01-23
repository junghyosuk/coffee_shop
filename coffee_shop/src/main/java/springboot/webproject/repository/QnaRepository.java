package springboot.webproject.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import springboot.webproject.dto.NoticeDTO;
import springboot.webproject.dto.QnaDTO;

import java.util.Optional;

@Repository
public interface QnaRepository extends JpaRepository<QnaDTO,Long> {
    //noticeStatus가 1이고 noticeNo를 기준으로 내림차순 정렬된 데이터를 페이징 처리하도록 수정합니다.
    Page<QnaDTO> findAllByQnaNoLessThanEqualOrderByQnaNoDesc(
            int QnaNo, Pageable pageable);

    //noticeNo 로 찾아서 notice 디테일 보기
    Optional<QnaDTO> findByQnaNo(int qnaNo);
    // USERS 테이블의 데이터를 포함하여 QNA와 조인된 데이터 조회
//    @Query("SELECT q FROM Qna q JOIN FETCH q.users WHERE q.qnaNo = :qnaNo")
//    Optional<QnaDTO> findByQnaNoWithUsers(int qnaNo);
    @Query("SELECT q FROM QnaDTO q JOIN FETCH q.users WHERE q.qnaNo = :qnaNo")
    Optional<QnaDTO> findByQnaNoWithUsers(@Param("qnaNo") int qnaNo);
}