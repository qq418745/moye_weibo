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
@Table(name = "t_favorite")
public class Favorite {

    /**
     * 收藏id
     */
    @Id
    private  String favoriteId;

    /**
     * 微博id
     */
    private  Integer weiboId;

    /**
     * 用户id
     */
    private  Integer userId;

    /**
     * 创建时间
     */
    private  String createTime;

    /**
     * set微博id
     * @param weibo
     * @param user
     */
    public void setFavoriteId(Weibo weibo,WeiboUser user) {
        this.favoriteId = weibo.getWeiboId()+ "_"+ user.getUserId() + "_" +System.currentTimeMillis();
    }

    /**
     * 构造收藏对象
     * @param weibo
     * @param user
     * @return
     */
    public Favorite  buildFavorite(Weibo weibo, WeiboUser user){
        this.favoriteId = weibo.getWeiboId()+ "_"+ user.getUserId() + "_" +System.currentTimeMillis();
        this.weiboId =  weibo.getWeiboId();
        this.userId =  user.getUserId();
        return this;
    }
}
