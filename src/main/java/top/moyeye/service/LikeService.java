package top.moyeye.service;

import top.moyeye.bean.Weibo;
import top.moyeye.bean.WeiboUser;
import top.moyeye.bean.common.CommonResult;

import java.util.List;

/**
 * 点赞服务
 */
public interface LikeService {
    /**
     * 保存
     * @param weibo
     * @param currentUser
     * @return
     */
    CommonResult save(Weibo weibo, WeiboUser currentUser);

    /**
     * 删除
     * @param weibo
     * @param currentUser
     * @return
     */
    CommonResult delete(Weibo weibo, WeiboUser currentUser);

    /**
     * 查询当前用户点赞微博
     * @param weiboList
     * @param currentUser
     * @return
     */
    List<Weibo> isLike(List<Weibo> weiboList, WeiboUser currentUser);

    /**
     * 查询微博根据当前用户
     * @param currentUser
     * @return
     */
    List<Weibo> findByUser(WeiboUser currentUser);
}
