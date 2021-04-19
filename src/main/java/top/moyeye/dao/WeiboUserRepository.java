package top.moyeye.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import top.moyeye.bean.WeiboUser;

import java.util.ArrayList;
import java.util.List;

public interface WeiboUserRepository extends JpaRepository<WeiboUser, Integer> {

    WeiboUser findByUsername(String username);

    WeiboUser findByEmail(String email);

    @Query("select w from WeiboUser w where w.userId in (:ids)")
    List<WeiboUser> findInFollowUserId(ArrayList<Integer> ids);

    List<WeiboUser> findByNicknameLike(String s);
}
