package top.moyeye.service;

import top.moyeye.bean.Weibo;
import top.moyeye.bean.WeiboUser;
import top.moyeye.bean.common.CommonResult;

import java.util.List;

/**
 * 收藏服务
 */
public interface FavoriteService {
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
     * 设置微博是否收藏
     * @param weiboList
     * @param currentUser
     * @return
     */
    List<Weibo> isFavorite(List<Weibo> weiboList, WeiboUser currentUser);

    /**
     * 查询当前用户收藏微博
     * @param currentUser
     * @return
     */
    List<Weibo> findByUser(WeiboUser currentUser);
}
