package top.moyeye.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import top.moyeye.bean.WeiboUser;
import top.moyeye.dao.WeiboUserRepository;
import top.moyeye.service.WeiboUserService;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
public class WeiboUserServiceImpl implements WeiboUserService {

    @Autowired
    WeiboUserRepository weiboUserRepository;

    @Override
    public WeiboUser findByName(String name) {
      return   weiboUserRepository.findByUsername(name);
    }
    @Override
    public WeiboUser findById(Integer id) {
        return weiboUserRepository.findById(id).get();
    }

    @Override
    public WeiboUser findByEmail(String email) {
        return   weiboUserRepository.findByEmail(email);
    }

    @Override
    public WeiboUser save(WeiboUser user) {
        return  weiboUserRepository.save(user);
    }

    @Override
    public WeiboUser add(WeiboUser user) {
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes(StandardCharsets.UTF_8)));
        return save(user);
    }
}
