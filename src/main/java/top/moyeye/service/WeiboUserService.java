package top.moyeye.service;

import top.moyeye.bean.WeiboUser;

public interface WeiboUserService {

    WeiboUser findByName(String name);
}
