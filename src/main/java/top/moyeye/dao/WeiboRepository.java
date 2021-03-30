package top.moyeye.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import top.moyeye.bean.Weibo;


public interface  WeiboRepository  extends JpaRepository<Weibo, Integer> {
}
