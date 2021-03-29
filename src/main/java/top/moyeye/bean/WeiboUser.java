package top.moyeye.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;


import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

import static top.moyeye.consts.IConst.DEFAULT_TIME_PATTERN;

@Accessors(chain = true)
@NoArgsConstructor
@Getter
@Setter
@ToString()
@Entity
@Table(name = "t_weibo_user")
public class WeiboUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    private String username;

    private String password;

    private String nickname;

    private String face;

    private Integer sex;

    private Date bir;

    private String province;

    private String city;

    private String email;

    private String hobby;

    private String job;

    private String user_explain;

    private String user_logo;

    @JsonFormat(pattern = DEFAULT_TIME_PATTERN, timezone="GMT+8")
    private Timestamp createTime;
}