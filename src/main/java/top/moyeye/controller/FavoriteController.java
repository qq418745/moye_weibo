package top.moyeye.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.moyeye.bean.Weibo;
import top.moyeye.bean.common.CommonResult;
import top.moyeye.service.FavoriteService;

/**
 * 收藏
 */

@Controller
@RequestMapping("favorite")
public class FavoriteController extends BaseController{
    /**
     * 注入收藏服务
     */
    @Autowired
    FavoriteService favoriteService;

    /**
     * 收藏添加
     * @param weibo
     * @return
     */
    @RequestMapping("add")
    @ResponseBody
    public CommonResult send(@RequestBody Weibo weibo){
        return  favoriteService.save(weibo,  currentUser());
    }

    /**
     * 收藏取消
     * @param weibo
     * @return
     */
    @RequestMapping("unAdd")
    @ResponseBody
    public CommonResult unAdd(@RequestBody Weibo weibo){
        return  favoriteService.delete(weibo, currentUser());
    }
}
