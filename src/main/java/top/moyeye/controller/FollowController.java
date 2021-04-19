package top.moyeye.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.moyeye.bean.Follow;
import top.moyeye.bean.WeiboUser;
import top.moyeye.bean.common.CommonResult;
import top.moyeye.bean.common.PageResult;
import top.moyeye.dao.FollowRepository;
import top.moyeye.dao.WeiboUserRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * 关注
 */
@Controller
@RequestMapping("follow")
public class FollowController extends BaseController{

    @Autowired
    FollowRepository followRepository;

    @Autowired
    WeiboUserRepository weiboUserRepository;
    /**
     * 添加关注
     * @param id
     * @return
     */
    @RequestMapping("currentUser/add")
    @ResponseBody
    public CommonResult currentUserAdd(Integer id){
        if(id != null){
        followRepository.save(new Follow().setUserId(currentUser().getUserId()).setFollowUserId(id));
        }
        return  new CommonResult();
    }

    /**
     * 取消关注
     * @param id
     * @return
     */
     @RequestMapping("currentUser/delete")
     @ResponseBody
     public CommonResult currentUserDelete(Integer id){
         if(id != null){
             List<Follow> follows = followRepository.unDelete(currentUser().getUserId(), id);
             follows.forEach(s->followRepository.deleteById(s.getId()));
         }
         return  new CommonResult();
     }

    /**
     * 获取粉丝
     * @param id
     * @return
     */
    @RequestMapping("p/follow")
    @ResponseBody
    public PageResult pfollow(Integer id){
        List<Follow>   follows =   followRepository.findByFollowUserId(id);
        ArrayList<Integer> ids = new ArrayList<>();
        follows.forEach(s->ids.add(s.getUserId()));
        List<WeiboUser>   users  = weiboUserRepository.findInFollowUserId(ids);
        return  new PageResult(users.size(),users);
    }

    /**
     * 获取我的关注
     * @param id
     * @return
     */
    @RequestMapping("p/unFollow")
    @ResponseBody
    public PageResult punFollow(Integer id){
        List<Follow>   follows =   followRepository.findByUserId(id);
        ArrayList<Integer> ids = new ArrayList<>();
          follows.forEach(s->ids.add(s.getFollowUserId()));
        List<WeiboUser>   users  = weiboUserRepository.findInFollowUserId(ids);
        return  new PageResult(users.size(),users);
    }

    /**
     * 获取粉丝
     * @return
     */
    @RequestMapping("follow")
    @ResponseBody
    public PageResult follow(){
        List<Follow>   follows =   followRepository.findByFollowUserId(currentUser().getUserId());
        ArrayList<Integer> ids = new ArrayList<>();
        follows.forEach(s->ids.add(s.getUserId()));
        List<WeiboUser>   users  = weiboUserRepository.findInFollowUserId(ids);
        return  new PageResult(users.size(),users);
    }

    /**
     * 获取我的关注
     * @return
     */
    @RequestMapping("unFollow")
    @ResponseBody
    public PageResult unFollow(){
        List<Follow>   follows =   followRepository.findByUserId(currentUser().getUserId());
        ArrayList<Integer> ids = new ArrayList<>();
        follows.forEach(s->ids.add(s.getFollowUserId()));
        List<WeiboUser>   users  = weiboUserRepository.findInFollowUserId(ids);
        return  new PageResult(users.size(),users);
    }

    /**
     * 是否关注
     * @param id
     * @return
     */
    @RequestMapping("p/isFollow")
    @ResponseBody
    public boolean isFollow(Integer id){
        if(isLogin()){
            if(id != null){
                List<Follow> follows = followRepository.unDelete(currentUser().getUserId(), id);
                if(!follows.isEmpty()){
                  return  true;
                }
            }
        }
        return false;
    }

}
