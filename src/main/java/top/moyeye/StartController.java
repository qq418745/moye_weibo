package top.moyeye;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StartController {

    @RequestMapping("/")
    public String welcome(){
        return "redirect:/index.html";
    }

//    @RequestMapping("login")
//    public String login(){
//        return "redirect:./login.html";
//    }
}