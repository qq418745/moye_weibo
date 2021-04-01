package top.moyeye.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.sql.Timestamp;

import static top.moyeye.consts.IConst.DEFAULT_TIME_PATTERN;

@Accessors(chain = true)
@NoArgsConstructor
@Getter
@Setter
@ToString()
@Entity
@Table(name = "t_weibo")
public class Weibo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer weiboId;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private WeiboUser weiboUser;

    @JsonFormat(pattern = DEFAULT_TIME_PATTERN, timezone="GMT+8")
    private Timestamp postTime;

    private String content;

    private String pic1;

    private String pic2;

    private String pic3;

    private String pic4;

    private String pic5;

    private String pic6;

    private String pic7;

    private String pic8;

    private String pic9;

    private Integer commentId;

    private Integer likeId;

    private Integer favoriteId;
}
