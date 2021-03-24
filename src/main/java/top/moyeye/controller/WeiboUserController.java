package top.moyeye.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("weiboUser")
public class WeiboUserController {


    @RequestMapping("home")
    public String home(){
        return "redirect:/home.html";
    }


}
