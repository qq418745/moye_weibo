package top.moyeye.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.moyeye.bean.common.CommonResult;
import top.moyeye.bean.common.PageResult;
import top.moyeye.bean.Weibo;
import top.moyeye.dao.WeiboRepository;
import top.moyeye.dao.WeiboUserRepository;
import top.moyeye.service.CommentService;
import top.moyeye.service.FavoriteService;
import top.moyeye.service.LikeService;
import top.moyeye.service.WeiboService;


import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("weibo")
public class WeiboController extends BaseController{

    @Autowired
    WeiboService weiboService;

    @Autowired
    WeiboRepository weiboRepository;

    @Autowired
    LikeService likeService;

    @Autowired
    FavoriteService favoriteService;

    @Autowired
    CommentService commentService;

    @Autowired
    WeiboUserRepository weiboUserRepository;

    @RequestMapping("send")
    @ResponseBody
    public Weibo send(@RequestBody Weibo weibo){
        //话题
        if(weibo.getContent().contains("#")){
            String topic  = weibo.getContent().split("#")[1].split(" ")[0];
            weibo.setTopic(topic);
        }
        //@
        if(weibo.getContent().contains("@")){
        }

      return  weiboService.save(weibo.setWeiboUser( currentUser()));
    }

    @RequestMapping("delete")
    @ResponseBody
    public CommonResult send(Integer id){
        weiboRepository.deleteById(id);
        return  new CommonResult();
    }

    @RequestMapping("currentUser/findAll")
    @ResponseBody
    public PageResult currentUserFindAll(@RequestBody Weibo weibo, int page, int rows){

        return  weiboService.findAllByUser(weibo.setWeiboUser( currentUser()) , PageRequestOf(page, rows, Sort.by(Sort.Direction.DESC, "postTime")));
    }
    @RequestMapping("currentUser/findByStar")
    @ResponseBody
    public PageResult currentUserFindByStar(@RequestBody Weibo weibo, int page, int rows){
        List<Weibo> weibos = favoriteService.findByUser(currentUser());
        return  new PageResult(weibos.size(),weibos);
    }
    @RequestMapping("currentUser/findByLike")
    @ResponseBody
    public PageResult currentUserFindByLike(@RequestBody Weibo weibo, int page, int rows){
        List<Weibo> weibos = likeService.findByUser(currentUser());
        return  new PageResult(weibos.size(),weibos);
    }
    @RequestMapping("currentUser/findByComment")
    @ResponseBody
    public PageResult currentUserFindByComment(@RequestBody Weibo weibo, int page, int rows){
        List<Weibo> weibos = commentService.findByUser(currentUser());
        return  new PageResult(weibos.size(),weibos);
    }

    @RequestMapping("p/findAll")
    @ResponseBody
    public PageResult pFindAll(@RequestBody Weibo weibo, int page, int rows){
        return weiboService.findAll(weibo,(isLogin() ? currentUser() : null), PageRequestOf(page, rows, Sort.by(Sort.Direction.DESC, "postTime")));
    }
    @RequestMapping("findAll")
    @ResponseBody
    public PageResult findAll(@RequestBody Weibo weibo, int page, int rows){
        return weiboService.findAll(weibo, null, PageRequestOf(page, rows, Sort.by(Sort.Direction.DESC, "postTime")));
    }
    @RequestMapping("p/findAllByUserId")
    @ResponseBody
    public PageResult findAllByUserId(Integer id, int page, int rows){
        return weiboService.findByUserId(id, PageRequestOf(page, rows, Sort.by(Sort.Direction.DESC, "postTime")));
    }

}
