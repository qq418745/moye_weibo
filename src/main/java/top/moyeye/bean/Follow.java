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
@Table(name = "t_follow")
public class Follow {

    /**
     * 关注主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    /**
     * 用户id
     */
    private  Integer userId;

    /**
     * 用户粉丝id
     */
    private  Integer followUserId;
}
