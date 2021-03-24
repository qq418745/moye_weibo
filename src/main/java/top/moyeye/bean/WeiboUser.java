package top.moyeye.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
    private Integer userId;

    private String username;

    private String password;

    private String nickname;

    private String face;

    private Integer sex;

    private Date bir;

    private String province;

    private String city;
}