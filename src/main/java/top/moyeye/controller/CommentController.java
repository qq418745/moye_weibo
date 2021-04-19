package top.moyeye.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.moyeye.bean.Comment;
import top.moyeye.bean.common.CommonResult;
import top.moyeye.bean.common.PageResult;
import top.moyeye.dao.CommentRepository;
import top.moyeye.service.CommentService;

import java.util.List;

/**
 * 评论
 */
@Controller
@RequestMapping("comment")
public class CommentController extends BaseController{

    @Autowired
    CommentService commentService;

    @Autowired
    CommentRepository commentRepository;

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


    /**
     * 查询评论
     * @param commentText 搜索内容
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("findAll")
    @ResponseBody
    public PageResult findAll(String commentText ,int page, int rows) {
        if(commentText != null && (!commentText.equals(""))){
            List<Comment> list = commentRepository.findByCommentTextLike("%" + commentText + "%");
            return   new PageResult( list.size(),list);
        }

        return   new PageResult( commentRepository.findAll(PageRequestOf(page, rows, Sort.by(Sort.Direction.DESC, "createTime"))));

    }
}
