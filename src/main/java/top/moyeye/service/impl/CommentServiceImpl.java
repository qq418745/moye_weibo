package top.moyeye.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.moyeye.bean.Comment;
import top.moyeye.bean.Weibo;
import top.moyeye.bean.WeiboUser;
import top.moyeye.bean.common.CommonResult;
import top.moyeye.dao.CommentRepository;
import top.moyeye.dao.WeiboRepository;
import top.moyeye.service.CommentService;

import java.util.List;


@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    WeiboRepository weiboRepository;

    @Override
    public CommonResult delete(Integer commentId) {
        commentRepository.deleteById(commentId);
        return new CommonResult();
    }

    @Override
    public CommonResult save(String commentText, Integer weiboId, WeiboUser currentUser) {
        commentRepository.save(new Comment().buildComment(commentText, weiboId, currentUser));
        return new CommonResult();
    }

    @Override
    public List<Weibo> setWeiboComment(List<Weibo> weibos) {
        weibos.forEach(w->w.setComments(  commentRepository.findByWeiboId(w.getWeiboId())));
        return weibos;
    }


}
