package top.moyeye.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Accessors(chain = true)
@NoArgsConstructor
@Getter
@Setter
@ToString()
@Entity
@Table(name = "t_like")
public class Like {

    /**
     *点赞id
     */
    @Id
    private  String likeId;

    /**
     * 用户id
     */
    private  Integer userId;

    /**
     * 微博id
     */
    private  Integer weiboId;

    /**
     * 创建时间
     */
    private  String createTime;

    /**
     * 构建点赞对象
     * @param weibo
     * @param user
     * @return
     */
    public Like  buildLike(Weibo weibo, WeiboUser user){
        this.likeId = weibo.getWeiboId()+ "_"+ user.getUserId() + "_" +System.currentTimeMillis();
        this.weiboId =  weibo.getWeiboId();
        this.userId =  user.getUserId();
        return this;
    }
}
