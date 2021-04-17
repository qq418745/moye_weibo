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

    @Id
    private  String likeId;

    private  Integer userId;

    private  Integer weiboId;

    private  String createTime;

    public Like  buildLike(Weibo weibo, WeiboUser user){
        this.likeId = weibo.getWeiboId()+ "_"+ user.getUserId() + "_" +System.currentTimeMillis();
        this.weiboId =  weibo.getWeiboId();
        this.userId =  user.getUserId();
        return this;
    }
}
