package com.sast.woc.service;

import com.sast.woc.entity.User;

/**
 * @Author xun
 * @create 2023/1/3 16:35
 */
public interface UserService {
    boolean delUser(String userName);
    User findUser(String userName);
    int addUser(User user);
    String login(String userName,String password);

    void change(User user);
}
