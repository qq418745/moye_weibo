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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer commentId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private WeiboUser weiboUser;

    private  Integer weiboId;

    private  String commentText;

    private  String createTime;

    public Comment buildComment(String commentText,Integer weiboId, WeiboUser currentUser){
        this.setCommentText(commentText);
        this.setWeiboId(weiboId);
        this.setWeiboUser(currentUser);
        return  this;
    }
}
