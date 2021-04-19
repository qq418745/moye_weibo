package top.moyeye.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.moyeye.bean.WeiboUser;
import top.moyeye.dao.WeiboUserRepository;


@Controller
@RequestMapping("weiboUser")
public class WeiboUserController extends BaseController{
     final  String REDIRECT = "redirect:../../redirect.html";

     @Autowired
    WeiboUserRepository weiboUserRepository;
    /**
     * 个人主页
     * @return 个人主页
     */
    @RequestMapping("profile")
    public String home(){
        return "redirect:../#/profile";
    }

    /**
     * 注册用户
     * @param username 用户名
     * @param password 密码
     * @param nickname 昵称
     * @return 结果
     */
    @RequestMapping("p/add")
    public String add(String username, String password, String nickname){
        weiboUserService.add(new WeiboUser().setUsername(username).setPassword(password).setNickname(nickname));
        return REDIRECT;

    }

    /**
     * 找回密码
     * @param email 邮箱
     * @return 结果
     */
    @RequestMapping("p/forgot-password")
    public String forgotPassword(String email,String password){

        WeiboUser user = weiboUserService.findByEmail(email);
        if(user != null){
            weiboUserService.add((user.setPassword(password)));
            return REDIRECT;
        }
        return "redirect:../../forgot-password.html?error=email";
    }

    @RequestMapping("currentWeiboUser")
    @ResponseBody
    public WeiboUser currentWeiboUser(){
         return  currentUser();
    }
    @RequestMapping("p/user")
    @ResponseBody
    public WeiboUser user(Integer id){
        return weiboUserRepository.findById(id).get();
    }
    @RequestMapping("p/isLogin")
    @ResponseBody
    public boolean user(){
        return isLogin();
    }

    @RequestMapping("save")
    @ResponseBody
    public WeiboUser save(@RequestBody WeiboUser weiboUser){
        return   weiboUserService.save(weiboUser);
    }


}
