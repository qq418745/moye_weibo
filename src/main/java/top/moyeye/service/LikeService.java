package top.moyeye.service;

import top.moyeye.bean.Weibo;
import top.moyeye.bean.WeiboUser;
import top.moyeye.bean.common.CommonResult;

import java.util.List;

public interface LikeService {

    CommonResult save(Weibo weibo, WeiboUser currentUser);

    CommonResult delete(Weibo weibo, WeiboUser currentUser);

    List<Weibo> isLike(List<Weibo> weiboList, WeiboUser currentUser);

    List<Weibo> findByUser(WeiboUser currentUser);
}
