package springboot.webproject.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import springboot.webproject.dto.NoticeDTO;
import springboot.webproject.dto.UsersDTO;
import springboot.webproject.service.NoticeService;

import java.time.LocalDateTime;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
//@RequestMapping("/user")
public class NoticeController {
    private final NoticeService noticeService;

    //    @GetMapping("/notices")
//    public String getNotices(
//            @RequestParam(defaultValue = "1") int page,
//            @RequestParam(defaultValue = "10") int size,
//            @RequestParam(defaultValue = "100000") int noticeNo,
//            Model model){
//        Page<NoticeDTO> notices = noticeService.getActiveNotices(noticeNo,page,size);
//        model.addAttribute("notices",notices);
//        return "view/notice/notice_list";
//    }
// 글을 쓰기- 온니 admin 만 가능함
    @GetMapping("/admin/create")
    public String showCreateUserForm(Model model) {
        model.addAttribute("notice", new NoticeDTO());
        return "view/notice/create_notice"; // This maps to create_user.html
    }
    @PostMapping("/admin/create")
    public ModelAndView createUser(@ModelAttribute NoticeDTO notice) {


        noticeService.createNotice(notice);
        notice.setNoticeDate(LocalDateTime.now());// Save the user using the service
//    notice.setNoticeDate(LocalDateTime.parse(String.valueOf(LocalDateTime.now()))); //
        return new ModelAndView("redirect:/admin/create?success=true");
    }

    @GetMapping("/notices")
    public String getNotices(
            @RequestParam(name = "page", defaultValue = "1") int page,
            @RequestParam(name = "size", defaultValue = "10") int size,
            @RequestParam(name = "noticeNo", defaultValue = "100000") int noticeNo,
            Model model) {
        // PageRequest는 0부터 시작하므로 page-1로 설정
        Page<NoticeDTO> notices = noticeService.getActiveNotices(noticeNo, page, size);
        // 페이지네이션 정보 모델에 추가
        int currentPage = page;
        int totalPages = notices.getTotalPages();
        model.addAttribute("notices", notices);
        model.addAttribute("currentPage", currentPage);  // 현재 페이지
        model.addAttribute("totalPages", totalPages);  // 총 페이지 수
        model.addAttribute("pageSize", size);
        return "view/notice/notice_list";
    }
    @GetMapping("/notices/detail")
    public String getNoticeDetail(@RequestParam("noticeNo") int noticeNo,
                                  @RequestParam("pageNum") int pageNum,
                                  @RequestParam("pageSize") int pageSize,
                                  Model model){
        Optional<NoticeDTO> notice = noticeService.getNoticeDetail(noticeNo);
        if(notice.isPresent()){
            model.addAttribute("notice", notice.get());
            // 페이징 정보 전달
            model.addAttribute("currentPage", pageNum);
            model.addAttribute("pageSize", pageSize);
            return "view/notice/notice_detail";
        }else{
            return "redirect:/notices?error=notfound";
        }
    }

}