package top.moyeye.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name = "t_comment")
public class Comment {

    /**
     * 评论id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer commentId;

    /**
     * 微博用户
     */
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private WeiboUser weiboUser;

    /**
     * 微博用户id
     */
    private  Integer weiboId;

    /**
     * 评论内容
     */
    private  String commentText;

    /**
     *创建时间
     */
    private  String createTime;

    /**
     * 构造评论器
     * @param commentText
     * @param weiboId
     * @param currentUser
     * @return
     */
    public Comment buildComment(String commentText,Integer weiboId, WeiboUser currentUser){
        this.setCommentText(commentText);
        this.setWeiboId(weiboId);
        this.setWeiboUser(currentUser);
        return  this;
    }
}
