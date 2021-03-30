package top.moyeye.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.moyeye.bean.Weibo;
import top.moyeye.dao.WeiboRepository;
import top.moyeye.service.WeiboService;

import java.util.List;

@Service
public class WeiboServiceImpl implements WeiboService {

    @Autowired
    WeiboRepository weiboRepository;

    @Override
    public Weibo save(Weibo weibo) {
        return weiboRepository.save(weibo);
    }

    @Override
    public List<Weibo> findAll(Weibo weibo) {
        return weiboRepository.findAll();
    }
}
