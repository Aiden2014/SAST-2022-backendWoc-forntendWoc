package com.sast.woc.mapper;

import com.sast.woc.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author xun&&Aiden2014
 * @create 2022/12/26 14:47
 */
@Mapper
@Repository
public interface UserMapper {
    boolean delUser(@Param("userName") String userName);
    User findUser(@Param("userName") String userName);
    int addUser(User user);
    String login(@Param("userName")String userName,@Param("password")String password);
    void change(User user);
}
