package top.moyeye.security;

import top.moyeye.bean.WeiboUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * 登陆类
 * Mr.liuchengming
 * 2020-01-14 21:19
 **/
public class UserDetail  extends User {

    private WeiboUser weiboUser;

    public UserDetail(String username, String password, Collection<? extends GrantedAuthority> authorities,WeiboUser user) {
        super(username, password, authorities);
        this.weiboUser = user;
    }

    public WeiboUser getUser() {
        return this.weiboUser;
    }
}

