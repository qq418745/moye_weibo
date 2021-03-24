package top.moyeye.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import top.moyeye.bean.WeiboUser;
import top.moyeye.dao.WeiboUserRepository;
import top.moyeye.service.WeiboUserService;
import org.springframework.stereotype.Service;

@Service
public class WeiboUserServiceImpl implements WeiboUserService {

    @Autowired
    WeiboUserRepository weiboUserRepository;
    @Override
    public WeiboUser findByName(String name) {
      return   weiboUserRepository.findByUsername(name);
    }
}
