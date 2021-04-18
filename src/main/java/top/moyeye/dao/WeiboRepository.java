package top.moyeye.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import top.moyeye.bean.Weibo;
import top.moyeye.bean.WeiboUser;

import java.util.List;


public interface  WeiboRepository  extends JpaRepository<Weibo, Integer> {

   Page<Weibo> findByWeiboUser(WeiboUser user, Pageable pageable);


}
