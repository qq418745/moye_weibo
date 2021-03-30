package top.moyeye.service;

import top.moyeye.bean.Weibo;

import java.util.List;

public interface WeiboService {

    Weibo save(Weibo weibo);

    List<Weibo> findAll(Weibo weibo);
}
