package top.moyeye.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import top.moyeye.bean.Weibo;
import top.moyeye.bean.WeiboUser;

import java.util.List;
import java.util.Map;


public interface  WeiboRepository  extends JpaRepository<Weibo, Integer> {

   Page<Weibo> findByWeiboUser(WeiboUser user, Pageable pageable);


   List<Weibo> findByContentLike(String s);

   List<Weibo>  findByTopicLike(String s);

   @Query(value = "select w.topic from t_weibo w group by w.topic order by count(w.topic) DESC  limit 5"
           ,nativeQuery = true)
    List<String> findFireTopic();
}
