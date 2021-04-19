package top.moyeye.service;

import org.springframework.data.domain.PageRequest;
import top.moyeye.bean.WeiboUser;
import top.moyeye.bean.common.PageResult;
import top.moyeye.bean.Weibo;

import java.util.List;

/**
 * 微博服务
 */
public interface WeiboService {
    /**
     * 保存
     * @param weibo
     * @return
     */
    Weibo save(Weibo weibo);

    /**
     * 查询微博
     * @param weibo
     * @param user
     * @param pageRequest
     * @return
     */
    PageResult findAll(Weibo weibo, WeiboUser user, PageRequest pageRequest);

    /**
     * 查询微博根据微博用户
     * @param setWeiboUser
     * @param postTime
     * @return
     */
    PageResult findAllByUser(Weibo setWeiboUser, PageRequest postTime);

    /**
     * 查询微博根据用户id
     * @param id
     * @param postTime
     * @return
     */
    PageResult findByUserId(Integer id, PageRequest postTime);
}
