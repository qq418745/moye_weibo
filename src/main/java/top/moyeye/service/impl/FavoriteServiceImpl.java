package top.moyeye.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.moyeye.bean.Favorite;
import top.moyeye.bean.Weibo;
import top.moyeye.bean.WeiboUser;
import top.moyeye.bean.common.CommonResult;
import top.moyeye.dao.FavoriteRepository;
import top.moyeye.service.FavoriteService;
import top.moyeye.service.fw.FwService;
import top.moyeye.service.fw.Processor;

import java.util.HashMap;
import java.util.List;

@Service
public class FavoriteServiceImpl implements FavoriteService {

    @Autowired
    FavoriteRepository favoriteRepository;

    @Autowired
    FwService fwService;

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
}
