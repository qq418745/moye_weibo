package top.moyeye.service;

import top.moyeye.bean.WeiboUser;

/**
 * 微博用户服务
 */
public interface WeiboUserService {

    /**
     *查询用户根据名字
     * @param name
     * @return
     */
    WeiboUser findByName(String name);

    /**
     * 查询用户根据id
     * @param id
     * @return
     */
    WeiboUser findById(Integer id);

    /**
     * 查询用户根据邮箱
     * @param email
     * @return
     */
    WeiboUser findByEmail(String email);

    /**
     * 修改用户
     * @param user
     * @return
     */
    WeiboUser save(WeiboUser user);

    /**
     * 新建用户
     * @param user
     * @return
     */
    WeiboUser add(WeiboUser user);


}
