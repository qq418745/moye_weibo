package top.moyeye;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 入口控制
 */
@Controller
public class StartController {

    /**
     * 跳转
     * @return
     */
    @RequestMapping("/")
    public String welcome(){
        return "redirect:/index.html";
    }

    /**
     * admin页面跳转
     * @return
     */
    @RequestMapping("admin")
    public String admin(){
        return "redirect:/admin/admin.html";
    }

}
