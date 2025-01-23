package springboot.webproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springboot.webproject.dto.QnaAnswer;
import springboot.webproject.service.QnaAnswerService;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/qna")
public class QnaAnswerController {

    private final QnaAnswerService qnaAnswerService;

    @Autowired
    public QnaAnswerController(QnaAnswerService qnaAnswerService) {
        this.qnaAnswerService = qnaAnswerService;
    }

    @PostMapping("/answer/{qnaNo}")
    public String addAnswer(@PathVariable("qnaNo") int qnaNo, @ModelAttribute QnaAnswer qnaAnswer) {
        qnaAnswer.getQna().setQnaNo(qnaNo); // 답변을 해당 질문에 연결
        qnaAnswerService.createAnswer(qnaAnswer); // 답변 저장
        return "redirect:/qna/detail/" + qnaNo; // 해당 Qna 상세 페이지로 리디렉션
    }

    @GetMapping("/answers/{qnaNo}")
    public String getAnswers(@PathVariable("qnaNo") int qnaNo, Model model) {
        List<QnaAnswer> answers = qnaAnswerService.getAnswersByQna(qnaNo);
        model.addAttribute("answers", answers); // 답변 목록을 모델에 추가
        return "`qna/qna_detail"; // Qna 상세 페이지로 이동
    }
}