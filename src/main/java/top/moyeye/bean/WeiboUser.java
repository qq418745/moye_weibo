package top.moyeye.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;


import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

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

    private String explain;

    private Timestamp timestamp;
}