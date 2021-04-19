package top.moyeye.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.moyeye.bean.Favorite;
import top.moyeye.bean.Weibo;
import top.moyeye.bean.WeiboUser;
import top.moyeye.bean.common.CommonResult;
import top.moyeye.dao.FavoriteRepository;
import top.moyeye.dao.WeiboRepository;
import top.moyeye.service.CommentService;
import top.moyeye.service.FavoriteService;
import top.moyeye.service.LikeService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class FavoriteServiceImpl implements FavoriteService {

    @Autowired
    FavoriteRepository favoriteRepository;

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
        favoriteRepository.save(new Favorite().buildFavorite(weibo, currentUser));
        return new CommonResult();
    }

    @Override
    public CommonResult delete(Weibo weibo, WeiboUser currentUser) {
        //获取用户所有收藏
        List<Favorite>  list = favoriteRepository.findByUserId(currentUser.getUserId());

        list.forEach(l-> {
            if(l.getWeiboId().equals(weibo.getWeiboId())){
                favoriteRepository.delete(l);
            }
        });
        return  new CommonResult();
    }

    @Override
    public List<Weibo> isFavorite(List<Weibo> weiboList, WeiboUser currentUser) {
        //获取用户所有收藏
       List<Favorite>  list = favoriteRepository.findByUserId(currentUser.getUserId());
       //hash查询
       HashMap<Integer, Favorite> m = new HashMap<>();
       list.forEach(f -> m.put(f.getWeiboId(),f));

       //给微博加上是否收藏
        weiboList.forEach(w->w.setFavorite(m.containsKey(w.getWeiboId())));
        return weiboList;
    }

    @Override
    public List<Weibo> findByUser(WeiboUser currentUser) {
        ArrayList<Weibo> weibos = new ArrayList<>();
        favoriteRepository.findByUserId(currentUser.getUserId()).forEach(s->{
            weibos.add(weiboRepository.findById(s.getWeiboId()).get());
        });
        commentService.setWeiboComment(weibos);
        favoriteService.isFavorite(weibos,currentUser);
        likeService.isLike(weibos,currentUser);
        return weibos;
    }
}
