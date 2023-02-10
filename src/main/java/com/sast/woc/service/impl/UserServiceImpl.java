package com.sast.woc.service.impl;

import com.sast.woc.entity.User;
import com.sast.woc.mapper.UserMapper;
import com.sast.woc.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * @Author xun
 * @create 2023/1/3 16:35
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * 这是sample方法的具体实现
     * @param value value
     * @return User
     */
    @Override
    public String sample(String value) {
        return userMapper.sample(value);
    }
    @Override
    public boolean delUser(String userName){
        return userMapper.delUser(userName);
    }
    @Override
    public User findUser(String userName){
        return userMapper.findUser(userName);
    }
    @Override
    public int addUser(User user){
        return userMapper.addUser(user);
    }
    @Override
    public String login(String userName,String password){
        return userMapper.login(userName,password);
    }
    @Override
    public void change(User user){
        userMapper.change(user);
    }
}
