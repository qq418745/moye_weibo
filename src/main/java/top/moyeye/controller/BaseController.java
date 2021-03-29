package top.moyeye.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import top.moyeye.bean.WeiboUser;
import top.moyeye.security.UserDetail;
import top.moyeye.service.WeiboUserService;

public abstract class BaseController {

    @Autowired
    protected WeiboUserService weiboUserService;
    /**
     * 获取当前用户
     * @return weiboUser
     */
    protected WeiboUser currentUser() {
        UserDetail principal = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return principal == null ? null :  weiboUserService.findById(principal.getUser().getUserId()) ;
    }
}
