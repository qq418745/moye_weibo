package top.moyeye.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import top.moyeye.bean.Weibo;
import top.moyeye.dao.WeiboRepository;
import top.moyeye.service.WeiboService;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<Weibo> findAllByUser(Weibo weibo) {
        return weiboRepository.findByWeiboUser(weibo.getWeiboUser(), PageRequest.of(0,9999, Sort.by(Sort.Direction.DESC, "postTime")));

    }
}
