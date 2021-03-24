package top.moyeye.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import top.moyeye.bean.WeiboUser;

public interface WeiboUserRepository extends JpaRepository<WeiboUser, Integer> {
    WeiboUser findByUsername(String username);
}
