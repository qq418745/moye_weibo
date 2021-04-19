package top.moyeye.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import top.moyeye.bean.WeiboUser;
import top.moyeye.bean.common.CommonResult;
import top.moyeye.bean.common.PageResult;
import top.moyeye.dao.WeiboUserRepository;

import java.util.List;


@Controller
@RequestMapping("weiboUser")
public class WeiboUserController extends BaseController{
     final  String REDIRECT = "redirect:../../redirect.html";

    /**
     * 注入微博用户表对象
     */
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

    /**
     * 获取当前用户
     * @return
     */
    @RequestMapping("currentWeiboUser")
    @ResponseBody
    public WeiboUser currentWeiboUser(){
         return  currentUser();
    }

    /**
     * 根据id获取当前用户
     * @param id
     * @return
     */
    @RequestMapping("p/user")
    @ResponseBody
    public WeiboUser user(Integer id){
        return weiboUserRepository.findById(id).get();
    }

    /**
     * 是否登陆
     * @return
     */
    @RequestMapping("p/isLogin")
    @ResponseBody
    public boolean user(){
        return isLogin();
    }

    /**
     * 保存
     * @param weiboUser
     * @return
     */
    @RequestMapping("save")
    @ResponseBody
    public WeiboUser save(@RequestBody WeiboUser weiboUser){
        return   weiboUserService.save(weiboUser);
    }

    /**
     * 查询用户
     * @param userText
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("findAll")
    @ResponseBody
    public PageResult findAll(String userText , int page, int rows) {
        if(userText != null && (!userText.equals(""))){
            List<WeiboUser> list = weiboUserRepository.findByNicknameLike("%" + userText + "%");
            return   new PageResult( list.size(),list);
        }

        return   new PageResult( weiboUserRepository.findAll(PageRequestOf(page, rows, Sort.by(Sort.Direction.DESC, "createTime"))));

    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @RequestMapping("delete")
    @ResponseBody
    public CommonResult delete(Integer id  ){
        weiboUserRepository.deleteById(id);
        return  new CommonResult();

    }
}
