package top.moyeye.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import top.moyeye.bean.WeiboUser;
import top.moyeye.bean.common.PageResult;
import top.moyeye.bean.Weibo;
import top.moyeye.dao.WeiboRepository;
import top.moyeye.service.CommentService;
import top.moyeye.service.FavoriteService;
import top.moyeye.service.LikeService;
import top.moyeye.service.WeiboService;

import java.util.List;

@Service
public class WeiboServiceImpl implements WeiboService {

    @Autowired
    WeiboRepository weiboRepository;

    @Autowired
    FavoriteService favoriteService;

    @Autowired
    LikeService likeService;

    @Autowired
    CommentService commentService;

    @Override
    public Weibo save(Weibo weibo) {
        return weiboRepository.save(weibo);
    }

    @Override
    public PageResult findAll(Weibo weibo, WeiboUser user, PageRequest pageRequest) {
        Page<Weibo> all = weiboRepository.findAll(pageRequest);

        if(user != null){
            favoriteService.isFavorite(all.getContent(),user);
            likeService.isLike(all.getContent(),user);
        }
        commentService.setWeiboComment(all.getContent());
        return  new PageResult(all);
    }

    @Override
    public List<Weibo> findAllByUser(Weibo weibo) {
        return  commentService.setWeiboComment( weiboRepository.findByWeiboUser(weibo.getWeiboUser(), PageRequest.of(0, 9999, Sort.by(Sort.Direction.DESC, "postTime"))));
    }
}
