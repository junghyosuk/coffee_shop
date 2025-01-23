package springboot.webproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import springboot.webproject.dto.NoticeDTO;
import springboot.webproject.dto.QnaDTO;
import springboot.webproject.dto.UsersDTO;
import springboot.webproject.service.QnaService;
import springboot.webproject.service.UserService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/user")
//@RequiredArgsConstructor
public class QnaController {
    @Autowired
    private final QnaService qnaService;
    @Autowired
    private final UserService userService;

    public QnaController(QnaService qnaService, UserService userService) {
        this.qnaService = qnaService;
        this.userService = userService;
    }

    @GetMapping("/qna/create")
    public String showCreateUserForm(Model model, Authentication authentication) {

        // 로그인한 사용자의 username을 통해 usersNo를 가져옵니다.
        String username = authentication.getName();
//        System.out.println("Authenticated username: " + username);
        UsersDTO user = userService.findUserByUsersId(username); // 사용자 정보 조회
        System.out.println("Fetched user: " + user);
        // QnaDTO 객체를 생성하고 usersNo를 hidden으로 설정합니다.
        QnaDTO qnaDTO = new QnaDTO();
        qnaDTO.setQnaUsersNo(user.getUsersNo());  // 현재 로그인한 사용자의 usersNo 설정
        System.out.println("UserNo : " + user.getUsersNo());
        // 모델에 추가하여 템플릿에서 사용하도록 합니다.
        model.addAttribute("qna", qnaDTO);
        model.addAttribute("user", user); // 사
        return "view/qna/create_qna"; // This maps to create_user.html
    }
    @PostMapping("/qna/create")
    public ModelAndView createUser(@ModelAttribute QnaDTO qna) {

        UsersDTO user = new UsersDTO();
        user.setUsersNo(qna.getQnaUsersNo()); // qnaUsersNo 값을 통해 사용자 설정
        qna.setUsers(user); // qnaDTO에 users 설정

        qnaService.createQna(qna);
        System.out.println("qnaUsersNo: " + qna.getQnaUsersNo());// Save the user using the service
        qna.setQnaDate(LocalDateTime.now());
        return new ModelAndView("redirect:/user/qna/create?success=true");
    }
    @GetMapping("/qna")
    public String getQna(
            @RequestParam(name = "page", defaultValue = "1") int page,
            @RequestParam(name = "size", defaultValue = "10") int size,
            @RequestParam(name = "qnaNo", defaultValue = "100000") int qnaNo,
            Model model) {
        // PageRequest는 0부터 시작하므로 page-1로 설정
        Page<QnaDTO> qna = qnaService.getActiveQna(qnaNo, page, size);
        // 페이지네이션 정보 모델에 추가

        int currentPage = page;
        int totalPages = qna.getTotalPages();
        model.addAttribute("qnaList", qna);
        model.addAttribute("currentPage", currentPage);  // 현재 페이지
        model.addAttribute("totalPages", totalPages);  // 총 페이지 수
        model.addAttribute("pageSize", size);
        return "view/qna/qna_list";
    }
    @GetMapping("/qna/detail")
    public String getNoticeDetail(@RequestParam("qnaNo") int qnaNo,
                                  @RequestParam("pageNum") int pageNum,
                                  @RequestParam("pageSize") int pageSize,
                                  Model model){
        Optional<QnaDTO> qna = qnaService.getQnaDetail(qnaNo);
        if(qna.isPresent()){
            model.addAttribute("qna", qna.get());
            // 페이징 정보 전달
            model.addAttribute("currentPage", pageNum);
            model.addAttribute("pageSize", pageSize);
            return "view/qna/qna_detail";
        }else{
            return "redirect:/qna?error=notfound";
        }
    }
}