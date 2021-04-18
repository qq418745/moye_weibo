package top.moyeye.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import top.moyeye.bean.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Integer> {

    List<Comment> findByWeiboId(Integer weiboId);

    @Query("select c from Comment c  where c.weiboUser.userId = :weiboId")
    List<Comment> findByWeiboUser(Integer weiboId);

}
