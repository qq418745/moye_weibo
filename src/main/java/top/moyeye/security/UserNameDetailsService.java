package top.moyeye.security;

import top.moyeye.bean.WeiboUser;
import top.moyeye.service.WeiboUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Mr.coala
 * 2020-01-02 14:58
 **/
@Service()
public class UserNameDetailsService implements UserDetailsService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    WeiboUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        WeiboUser user = userService.findByName(username);
        if (user == null){
            throw new UsernameNotFoundException("Username not found");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
//        //角色
//        user.getRoles().forEach(role -> {
//
//            if ( Arrays.stream(AppConf.noPasswordLoginRoles.split(";")).sequential().anyMatch(r->
//                    role.getName().equals(r)
//            )) {
//                throw new UserPermissionException("Password login is not supported");
//            }
//            authorities.add(new SimpleGrantedAuthority(role.getName()));
//        });
        logger.info(user.getUsername()+"角色权限为："+authorities.toString());
        return new UserDetail(user.getUsername(),user.getPassword(),authorities, user);
    }
}
