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
import top.moyeye.dao.WeiboUserRepository;
import top.moyeye.service.CommentService;
import top.moyeye.service.FavoriteService;
import top.moyeye.service.LikeService;
import top.moyeye.service.WeiboService;

import java.util.List;
import java.util.Optional;

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

    @Autowired
    WeiboUserRepository weiboUserRepository;
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
    public PageResult findAllByUser(Weibo setWeiboUser, PageRequest postTime) {
        Page<Weibo> byWeiboUser = weiboRepository.findByWeiboUser(setWeiboUser.getWeiboUser(), postTime);
        commentService.setWeiboComment(byWeiboUser.getContent());
        favoriteService.isFavorite(byWeiboUser.getContent(),setWeiboUser.getWeiboUser());
        likeService.isLike(byWeiboUser.getContent(),setWeiboUser.getWeiboUser());
        return  new PageResult(byWeiboUser);
    }

    @Override
    public PageResult findByUserId(Integer id, PageRequest pageRequest) {
        Optional<WeiboUser> byId = weiboUserRepository.findById(id);
        Page<Weibo> all = weiboRepository.findByWeiboUser(weiboUserRepository.findById(id).get(), pageRequest);
        if(byId.isPresent()){
            favoriteService.isFavorite(all.getContent(),byId.get());
            likeService.isLike(all.getContent(),byId.get());
        }
        commentService.setWeiboComment(all.getContent());
       return new PageResult(all);
    }


}
