package top.moyeye.service;


import top.moyeye.bean.Weibo;
import top.moyeye.bean.WeiboUser;
import top.moyeye.bean.common.CommonResult;
import java.util.List;

/**
 *评论服务
 */

public interface CommentService {

    /**
     * 删除评论
     * @param commentId
     * @return
     */
     CommonResult delete(Integer commentId);

    /**
     * 保存评论
     * @param commentText
     * @param weiboId
     * @param currentUser
     * @return
     */
     CommonResult save(String commentText, Integer weiboId, WeiboUser currentUser);

    /**
     * 给weibos 设置用户评论
     * @param weibos 微博
     * @return
     */
     List<Weibo> setWeiboComment(List<Weibo> weibos);

    /**
     * 查询当前用户评论微博
      * @param currentUser
     * @return
     */
    List<Weibo> findByUser(WeiboUser currentUser);
}
