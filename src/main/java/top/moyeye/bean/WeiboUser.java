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

    /**
     * 用户id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    /**
     * 用户账户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 展示
     */
    private String face;

    /**
     * 年龄
     */
    private Integer sex;

    /**
     * 生日
     */
    private Date bir;

    /**
     * 省份
     */
    private String province;

    /**
     * 地区
     */
    private String city;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 爱好
     */
    private String hobby;

    /**
     * 工作
     */
    private String job;

    /**
     * 用户自我介绍
     */
    private String userExplain;

    /**
     * 头像路径
     */
    private String userLogo;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = DEFAULT_TIME_PATTERN, timezone="GMT+8")
    private Timestamp createTime;
}