package top.moyeye.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

import static top.moyeye.consts.IConst.DEFAULT_TIME_PATTERN;

@Accessors(chain = true)
@NoArgsConstructor
@Getter
@Setter
@ToString()
@Entity
@Table(name = "t_weibo")
public class Weibo {

    /**
     * 微博id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer weiboId;

    /**
     * 微博用户
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private WeiboUser weiboUser;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = DEFAULT_TIME_PATTERN, timezone="GMT+8")
    private Timestamp postTime;

    /**
     * 微博内容
     */
    private String content;

    /**
     * 图片
     */
    private String pic1;

    private String pic2;

    private String pic3;

    private String pic4;

    private String pic5;

    private String pic6;

    private String pic7;

    private String pic8;

    private String pic9;

    private String topic;

    /**
     * 是否收藏
     */
    @Transient
    private boolean favorite;

    /**
     * 是否点赞
     */
    @Transient
    private boolean like;

    /**
     * 评论
     */
    @Transient
    private List<Comment> comments;

}
