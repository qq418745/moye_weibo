package top.moyeye.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.moyeye.bean.Weibo;
import top.moyeye.bean.common.CommonResult;
import top.moyeye.service.LikeService;

/**
 * 微博收藏
 */
@Controller
@RequestMapping("like")
public class LikeController extends BaseController{

    @Autowired
    LikeService likeService;
    /**
     * 点赞添加
     * @param weibo
     * @return
     */
    @RequestMapping("add")
    @ResponseBody
    public CommonResult send(@RequestBody Weibo weibo){
        return  likeService.save(weibo,  currentUser());
    }

    /**
     * 点赞取消
     * @param weibo
     * @return
     */
    @RequestMapping("unAdd")
    @ResponseBody
    public CommonResult unAdd(@RequestBody Weibo weibo){
        return  likeService.delete(weibo, currentUser());
    }
}
