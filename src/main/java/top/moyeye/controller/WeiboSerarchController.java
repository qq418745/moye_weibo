package top.moyeye.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.moyeye.dao.WeiboRepository;
import top.moyeye.dao.WeiboUserRepository;
import java.util.List;

/**
 * 微博搜索接口 公开
 */
@Controller
@RequestMapping("weibo/p")
public class WeiboSerarchController extends BaseController{
    /**
     * 枚举常量
     */
    final  String WO = "WO" , //微博
            HT = "HT" , //话题
            YH = "YH"; //用户

    /**
     * 注入微博数据表操作对象
     */
    @Autowired
    WeiboRepository weiboRepository;

    /**
     * 注入微博用户表操作对象
     */
    @Autowired
    WeiboUserRepository weiboUserRepository;

    /**
     * 微博搜索接口
     * @param type 搜索类型
     * @param text 搜索内容
     * @return 搜索结果
     */
    @RequestMapping("search")
    @ResponseBody
    public Object search(String type,String  text){

        if(text == null || text.equals("")){
            return "{}";
        }
        if(WO.equals(type)){
          return weiboRepository.findByContentLike("%" + text + "%");
        }
        if(HT.equals(type)){
            return  weiboRepository.findByTopicLike("%" + text + "%");
        }
        if(YH.equals(type)){
            return weiboUserRepository.findByNicknameLike("%" + text + "%");
        }
        return "{}";
    }

    /**
     * 热门主题
     * @return
     */
    @RequestMapping("fireTopic")
    @ResponseBody
    public List<String> fireTopic(){
        return weiboRepository.findFireTopic();
    }
}
