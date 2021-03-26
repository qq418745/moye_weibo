package top.moyeye.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("weiboUser")
public class WeiboUserController {


    @RequestMapping("profile")
    public String home(){
        return "redirect:../#/profile";
    }


}
