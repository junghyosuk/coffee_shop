package springboot.webproject.service;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.webproject.dto.NoticeDTO;
import springboot.webproject.repository.NoticeRepository;


import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {

    private final NoticeRepository noticeRepository;

    @Override
    @Transactional
    public NoticeDTO createNotice(NoticeDTO notice) {
        return noticeRepository.save(notice);

    }

    @Override
    public Page<NoticeDTO> getActiveNotices(int noticeNo, int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        return noticeRepository.findAllByNoticeStatusAndNoticeNoLessThanEqualOrderByNoticeNoDesc(1, noticeNo, pageable);
    }

    @Override
    public Optional<NoticeDTO> getNoticeDetail(int noticeNo) {

        return noticeRepository.findByNoticeNo(noticeNo);
    }

}