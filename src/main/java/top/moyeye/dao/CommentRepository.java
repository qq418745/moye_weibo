package top.moyeye.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import top.moyeye.bean.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Integer> {

    List<Comment> findByWeiboId(Integer weiboId);
}
