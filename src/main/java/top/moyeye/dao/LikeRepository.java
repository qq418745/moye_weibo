package top.moyeye.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import top.moyeye.bean.Like;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like ,String> {
    List<Like> findByUserId(Integer userId);
}
