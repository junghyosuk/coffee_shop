package springboot.webproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    //coffeebean list 페이지
    @GetMapping("/coffeebean/list")
    public String coffeebeanList(){
        return "/view/product/coffeebean_list";
    }

    //coffeebean view 페이지
    @GetMapping("/coffeebean/view")
    public String coffeebeanView(){
        return"/view/product/coffeebean_view";
    }

    //coldbrew list 페이지
    @GetMapping("/coldbrew/list")
    public String coldbrewList(){
        return "/view/product/coldbrew_list";
    }




}
