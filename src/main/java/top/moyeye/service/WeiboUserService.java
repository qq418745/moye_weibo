package top.moyeye.service;

import top.moyeye.bean.WeiboUser;

public interface WeiboUserService {

    WeiboUser findByName(String name);

    WeiboUser findById(Integer id);

    WeiboUser findByEmail(String email);

    WeiboUser save(WeiboUser user);

    WeiboUser add(WeiboUser user);


}
