package springboot.webproject.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import springboot.webproject.dto.NoticeDTO;

import java.util.Optional;

public interface NoticeRepository extends JpaRepository<NoticeDTO,Long> {
    //noticeStatus가 1이고 noticeNo를 기준으로 내림차순 정렬된 데이터를 페이징 처리하도록 수정합니다.
    Page<NoticeDTO> findAllByNoticeStatusAndNoticeNoLessThanEqualOrderByNoticeNoDesc(
            int noticeStatus, int noticeNo, Pageable pageable);

    //noticeNo 로 찾아서 notice 디테일 보기
    Optional<NoticeDTO> findByNoticeNo(int noticeNo);
}