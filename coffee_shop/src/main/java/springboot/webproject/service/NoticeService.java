package springboot.webproject.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import springboot.webproject.dto.NoticeDTO;


import java.util.Optional;

public interface NoticeService {
    // 활성화된 공지사항 리스트를 반환 (페이징 처리)
    Page<NoticeDTO> getActiveNotices(int noticeNo, int pageNum, int pageSize);

    // 특정 공지사항 상세 정보를 반환
    Optional<NoticeDTO> getNoticeDetail(int noticeNo);
}