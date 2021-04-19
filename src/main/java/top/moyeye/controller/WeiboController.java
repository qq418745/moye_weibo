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
import java.util.List;

/**
 * 微博
 */
@Controller
@RequestMapping("weibo")
public class WeiboController extends BaseController{

    /**
     * 注入微博服务
     */
    @Autowired
    WeiboService weiboService;

    /**
     * 注入微博表操作对象
     */
    @Autowired
    WeiboRepository weiboRepository;

    /**
     * 注入点赞服务
     */
    @Autowired
    LikeService likeService;

    /**
     * 注入收藏服务
     */
    @Autowired
    FavoriteService favoriteService;

    /**
     * 注入评论服务
     */
    @Autowired
    CommentService commentService;

    /**
     * 注入微博用户表操作对象
     */
    @Autowired
    WeiboUserRepository weiboUserRepository;

    /**
     * 发微博
     * @param weibo
     * @return
     */
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

    /**
     * 删除微博
     * @param id
     * @return
     */
    @RequestMapping("delete")
    @ResponseBody
    public CommonResult delete(Integer id){
        weiboRepository.deleteById(id);
        return  new CommonResult();
    }

    /**
     * 当前用户查询全部微博
     * @param weibo
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("currentUser/findAll")
    @ResponseBody
    public PageResult currentUserFindAll(@RequestBody Weibo weibo, int page, int rows){

        return  weiboService.findAllByUser(weibo.setWeiboUser( currentUser()) , PageRequestOf(page, rows, Sort.by(Sort.Direction.DESC, "postTime")));
    }

    /**
     * 当前用户查询所用收藏
     * @param weibo
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("currentUser/findByStar")
    @ResponseBody
    public PageResult currentUserFindByStar(@RequestBody Weibo weibo, int page, int rows){
        List<Weibo> weibos = favoriteService.findByUser(currentUser());
        return  new PageResult(weibos.size(),weibos);
    }

    /**
     * 当前用户查询所有点赞
     * @param weibo
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("currentUser/findByLike")
    @ResponseBody
    public PageResult currentUserFindByLike(@RequestBody Weibo weibo, int page, int rows){
        List<Weibo> weibos = likeService.findByUser(currentUser());
        return  new PageResult(weibos.size(),weibos);
    }

    /**
     * 当前用户查询所有评论
     * @param weibo
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("currentUser/findByComment")
    @ResponseBody
    public PageResult currentUserFindByComment(@RequestBody Weibo weibo, int page, int rows){
        List<Weibo> weibos = commentService.findByUser(currentUser());
        return  new PageResult(weibos.size(),weibos);
    }

    /**
     * 公开查全部微博
     * @param weibo
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("p/findAll")
    @ResponseBody
    public PageResult pFindAll(@RequestBody Weibo weibo, int page, int rows){
        return weiboService.findAll(weibo,(isLogin() ? currentUser() : null), PageRequestOf(page, rows, Sort.by(Sort.Direction.DESC, "postTime")));
    }

    /**
     * 查全部微博
     * @param weibo
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("findAll")
    @ResponseBody
    public PageResult findAll(@RequestBody Weibo weibo, int page, int rows){
        return weiboService.findAll(weibo, null, PageRequestOf(page, rows, Sort.by(Sort.Direction.DESC, "postTime")));
    }

    /**
     * 公开根据用户id查微博
     * @param id
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("p/findAllByUserId")
    @ResponseBody
    public PageResult findAllByUserId(Integer id, int page, int rows){
        return weiboService.findByUserId(id, PageRequestOf(page, rows, Sort.by(Sort.Direction.DESC, "postTime")));
    }

}
