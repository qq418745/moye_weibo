package top.moyeye.service;

import org.springframework.data.domain.PageRequest;
import top.moyeye.bean.WeiboUser;
import top.moyeye.bean.common.PageResult;
import top.moyeye.bean.Weibo;

import java.util.List;

public interface WeiboService {

    Weibo save(Weibo weibo);

    PageResult findAll(Weibo weibo, WeiboUser user, PageRequest pageRequest);


    PageResult findAllByUser(Weibo setWeiboUser, PageRequest postTime);
}
