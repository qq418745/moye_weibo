package top.moyeye.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
    protected boolean isLogin() {
        return !SecurityContextHolder.getContext().getAuthentication().getName().equals("anonymousUser");
    }

     protected   PageRequest  PageRequestOf( int page, int rows, Sort sort){
        return PageRequest.of(page - 1 , rows, sort);
     }

}
