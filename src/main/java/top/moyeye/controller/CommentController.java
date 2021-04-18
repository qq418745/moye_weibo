package top.moyeye.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.moyeye.bean.common.CommonResult;
import top.moyeye.service.CommentService;

/**
 * 评论
 */
@Controller
@RequestMapping("comment")
public class CommentController extends BaseController{

    @Autowired
    CommentService commentService;

    /**
     * 添加评论
     * @param commentText 评论内容
     * @param weiboId 微博id
     * @return
     */
    @RequestMapping("add")
    @ResponseBody
    public CommonResult add(String commentText, Integer weiboId) {
     return   commentService.save(commentText,weiboId,currentUser());
    }


    /**
     * 删除评论
     * @param commentId 评论id
     * @return
     */
    @RequestMapping("delete")
    @ResponseBody
    public CommonResult add(Integer commentId) {
        return     commentService.delete(commentId);
    }
}
