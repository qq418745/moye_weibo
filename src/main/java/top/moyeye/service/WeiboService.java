package top.moyeye.service;

import top.moyeye.bean.Weibo;

import java.util.List;
import java.util.Optional;

public interface WeiboService {

    Weibo save(Weibo weibo);

    List<Weibo> findAll(Weibo weibo);

    List<Weibo> findAllByUser(Weibo weibo);
}
