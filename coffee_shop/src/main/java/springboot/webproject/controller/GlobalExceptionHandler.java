package springboot.webproject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    // 로그인 실패 등 예외 처리
    @ExceptionHandler(Exception.class)
    public String handleException(Exception e, Model model) {
        // 예외 메시지를 모델에 추가하여 뷰에서 출력할 수 있도록 전달
        model.addAttribute("errorMessage", e.getMessage());
        return "error/general"; // 일반적인 에러 페이지로 이동
    }

//    // AccessDeniedException 예외 처리 (권한 부족)
//    @ExceptionHandler(AccessDeniedException.class)
//    public String handleAccessDeniedException(AccessDeniedException e, Model model) {
//        model.addAttribute("errorMessage", "권한이 없습니다.");
//        return "error/access-denied"; // access-denied.html 페이지로 리다이렉트
//    }
}