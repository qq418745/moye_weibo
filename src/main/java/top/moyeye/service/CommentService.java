package top.moyeye.service;

import top.moyeye.bean.Comment;
import top.moyeye.bean.Weibo;
import top.moyeye.bean.WeiboUser;
import top.moyeye.bean.common.CommonResult;

import java.util.List;

public interface CommentService {

     CommonResult delete(Integer commentId);


     CommonResult save(String commentText, Integer weiboId, WeiboUser currentUser);

     List<Weibo> setWeiboComment(List<Weibo> weibos);

}
