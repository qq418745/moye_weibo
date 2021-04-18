package top.moyeye.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import top.moyeye.bean.Follow;

import java.util.List;

public interface FollowRepository extends JpaRepository<Follow, Integer> {

    @Query("select f from Follow f where f.userId = :userId and f.followUserId = :id")
    List<Follow> unDelete(Integer userId, Integer id);

    List<Follow> findByFollowUserId(Integer id);

    @Query("select f  from Follow f where f.userId = :userId")
    List<Follow> findByUserId(Integer userId);
}
