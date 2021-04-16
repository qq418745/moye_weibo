package top.moyeye.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import top.moyeye.bean.Favorite;

import java.util.List;


public interface FavoriteRepository  extends JpaRepository<Favorite, Integer> {
    List<Favorite> findByUserId(Integer userId);
}
