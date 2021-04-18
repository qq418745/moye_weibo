package top.moyeye.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.moyeye.bean.common.PageResult;
import top.moyeye.bean.Weibo;
import top.moyeye.service.WeiboService;


import java.util.List;

@Controller
@RequestMapping("weibo")
public class WeiboController extends BaseController{

    @Autowired
    WeiboService weiboService;

    @RequestMapping("send")
    @ResponseBody
    public Weibo send(@RequestBody Weibo weibo){
      return  weiboService.save(weibo.setWeiboUser( currentUser()));
    }

    @RequestMapping("currentUser/findAll")
    @ResponseBody
    public List<Weibo> currentUserFindAll(@RequestBody Weibo weibo){
        return  weiboService.findAllByUser(weibo.setWeiboUser( currentUser()));
    }

    @RequestMapping("p/findAll")
    @ResponseBody
    public PageResult findAll(@RequestBody Weibo weibo, int page, int rows){
        return weiboService.findAll(weibo,(isLogin() ? currentUser() : null), PageRequestOf(page, rows, Sort.by(Sort.Direction.DESC, "postTime")));
    }

}
