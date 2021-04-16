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

    @Id
    private  String favoriteId;

    private  Integer weiboId;

    private  Integer userId;

    private  String createTime;

    public void setFavoriteId(Weibo weibo,WeiboUser user) {
        this.favoriteId = weibo.getWeiboId()+ "_"+ user.getUserId() + "_" +System.currentTimeMillis();
    }
    public Favorite  buildFavorite(Weibo weibo, WeiboUser user){
        this.favoriteId = weibo.getWeiboId()+ "_"+ user.getUserId() + "_" +System.currentTimeMillis();
        this.weiboId =  weibo.getWeiboId();
        this.userId =  user.getUserId();
        return this;
    }
}
