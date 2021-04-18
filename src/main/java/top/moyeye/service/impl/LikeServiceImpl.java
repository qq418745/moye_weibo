package top.moyeye.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.moyeye.bean.Like;
import top.moyeye.bean.Weibo;
import top.moyeye.bean.WeiboUser;
import top.moyeye.bean.common.CommonResult;
import top.moyeye.dao.LikeRepository;
import top.moyeye.dao.WeiboRepository;
import top.moyeye.service.CommentService;
import top.moyeye.service.FavoriteService;
import top.moyeye.service.LikeService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    LikeRepository likeRepository;

    @Autowired
    WeiboRepository weiboRepository;

    @Autowired
    FavoriteService favoriteService;

    @Autowired
    LikeService likeService;

    @Autowired
    CommentService commentService;

    @Override
    public CommonResult save(Weibo weibo, WeiboUser currentUser) {
        likeRepository.save(new Like().buildLike(weibo,currentUser));
        return new CommonResult();
    }

    @Override
    public CommonResult delete(Weibo weibo, WeiboUser currentUser) {
        //获取用户所有点赞
        List<Like>  list  = likeRepository.findByUserId(currentUser.getUserId());

        list.forEach(l-> {
            if(l.getWeiboId().equals(weibo.getWeiboId())){
                likeRepository.delete(l);
            }
        });
        return  new CommonResult();
    }

    @Override
    public List<Weibo> isLike(List<Weibo> weiboList, WeiboUser currentUser) {
        //获取用户所有点赞
        List<Like>  list  = likeRepository.findByUserId(currentUser.getUserId());

        //hash查询
        HashMap<Integer, Like> m = new HashMap<>();
        list.forEach(f -> m.put(f.getWeiboId(),f));

        //给微博加上是否点赞
        weiboList.forEach(w->w.setLike(m.containsKey(w.getWeiboId())));
        return  weiboList;
    }

    @Override
    public List<Weibo> findByUser(WeiboUser currentUser) {
        ArrayList<Weibo> weibos = new ArrayList<>();
         likeRepository.findByUserId(currentUser.getUserId()).forEach(s->{
             Optional<Weibo> byId = weiboRepository.findById(s.getWeiboId());
             byId.ifPresent(weibos::add);
         });
        commentService.setWeiboComment(weibos);
        favoriteService.isFavorite(weibos,currentUser);
        likeService.isLike(weibos,currentUser);
        return weibos;
    }
}
