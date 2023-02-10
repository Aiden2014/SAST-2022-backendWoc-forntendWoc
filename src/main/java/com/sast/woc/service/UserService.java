package com.sast.woc.service;

import com.sast.woc.entity.User;

/**
 * @Author xun
 * @create 2023/1/3 16:35
 */
public interface UserService {
    // 这是一个接口的方法，这个方法的具体实现在 UserServiceImpl 里面，你也可以点这个方法左边的小按键进入。
    String sample(String value);
    boolean delUser(String userName);
    User findUser(String userName);
    int addUser(User user);
    String login(String userName,String password);

    void change(User user);
}
