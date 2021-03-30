package top.moyeye.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import top.moyeye.bean.Weibo;
import top.moyeye.service.WeiboService;

import java.util.List;

@Controller
@RequestMapping("weibo")
public class WeiboController {

    @Autowired
    WeiboService weiboService;

    @RequestMapping("send")
    public Weibo send(Weibo weibo){
      return   weiboService.save(weibo);
    }

    @RequestMapping("p/findAll")
    public List<Weibo> findAll(Weibo weibo){
        return weiboService.findAll(weibo);
    }

}
