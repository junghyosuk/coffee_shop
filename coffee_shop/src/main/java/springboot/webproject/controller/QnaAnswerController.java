package springboot.webproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springboot.webproject.dto.QnaAnswer;
import springboot.webproject.dto.QnaDTO;
import springboot.webproject.service.QnaAnswerService;
import org.springframework.ui.Model;
import springboot.webproject.service.QnaService;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/admin/qna")
public class QnaAnswerController {

    private final QnaAnswerService qnaAnswerService;
    private final QnaService qnaService;
    @Autowired
    public QnaAnswerController(QnaAnswerService qnaAnswerService, QnaService qnaService) {
        this.qnaAnswerService = qnaAnswerService;
        this.qnaService = qnaService;
    }
    //  qna 값도 없고, 해당 정보들이 저장 하여 보내지는 값들이 아예 없이 짜서 답변 기능 자체가 안되어서 다시 짬
//    @PostMapping("/qna/answer/{qnaNo}")
//    public String addAnswer(@PathVariable("qnaNo") int qnaNo, @ModelAttribute QnaAnswer qnaAnswer) {
//        qnaAnswer.getQna().setQnaNo(qnaNo); // 답변을 해당 질문에 연결
//        qnaAnswerService.createAnswer(qnaAnswer); // 답변 저장
//        return "redirect:/qna/detail/" + qnaNo; // 해당 Qna 상세 페이지로 리디렉션
//    }
    @PostMapping("/answer/{qnaNo}")
    public String addAnswer(@PathVariable("qnaNo") int qnaNo, @RequestParam("answerContent") String answerContent,
                            @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        QnaDTO qna = qnaService.getQnaByQnaNo(qnaNo); // Qna 가져오기
        if (qna == null) {
            throw new RuntimeException("Qna not found with id: " + qnaNo);
        }

        QnaAnswer answer = new QnaAnswer();
        answer.setQna(qna); // Qna 연결
        answer.setAnswerContent(answerContent);// 답변 내용 저장
        /* 시간 을 제대로 저장 하지 못하고 값을 보내주기때문에 값을 저장 하지 못하였다. 그래서 DTO 부터 수정하여 다시
         * 시간을 보내주게 하여 값을 받아 저장 하였다*/
        answer.setAnswerDate(LocalDateTime.now());//
        qnaAnswerService.createAnswer(answer);
        return "redirect:/user/qna/detail" +"?qnaNo="+ qnaNo + "&pageNum=" + pageNum + "&pageSize=" + pageSize;
        /* 아래 코드에서 보이듯 redirect 하는 곳이 qna/detail일에서 보여주는 주소처럼  나오지 않아서 완전하게 주소를 같게 하기 위해
         * 페이징 처리를 하고, 페이징 넘버도 불러와서 redirect 해서 화면이 같은 화면이 보여지게하였다*/
        //    return "redirect:/user/qna/detail/" + qnaNo; // Qna 상세 페이지로 리다이렉트
    }
    /* get 방식으로 불러와서 목록을 보여주려 했지만 목록자체가 qna_detail.html 안에 있어서 값을 qnaController 에 보내서
     * 거기에서 qna_dtail 의 글 목록으로 값을 보내주게 하여 화면에 구성 */
//    @GetMapping("/qna/answers/{qnaNo}")
//    public String getAnswers(@PathVariable("qnaNo") int qnaNo, Model model) {
//        QnaDTO qna = qnaService.getQnaByQnaNo(qnaNo); // Qna 가져오기
//        if (qna == null) {
//            throw new RuntimeException("Qna not found with id: " + qnaNo);
//        }
//
//        List<QnaAnswer> answers = qnaAnswerService.getAnswersByQna(qnaNo);
//        model.addAttribute("answers", answers);
//        System.out.println("답변 개수: " + answers.size()); // 디버깅용 로그// 답변 목록을 모델에 추가
//        return "qna/qna_detail"; // Qna 상세 페이지로 이동
//    }
}