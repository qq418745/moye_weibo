package top.moyeye.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
    public List<Weibo> findAll(@RequestBody Weibo weibo){
        return weiboService.findAll(weibo);
    }

}
