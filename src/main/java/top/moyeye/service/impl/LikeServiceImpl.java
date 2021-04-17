package top.moyeye.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.moyeye.bean.Like;
import top.moyeye.bean.Weibo;
import top.moyeye.bean.WeiboUser;
import top.moyeye.bean.common.CommonResult;
import top.moyeye.dao.LikeRepository;
import top.moyeye.service.LikeService;

import java.util.HashMap;
import java.util.List;

@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    LikeRepository likeRepository;

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
}
