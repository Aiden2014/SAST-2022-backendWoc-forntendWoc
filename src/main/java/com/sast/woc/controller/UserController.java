package com.sast.woc.controller;

import com.sast.woc.entity.Token;
import com.sast.woc.entity.User;
import com.sast.woc.service.UserService;
import com.sast.woc.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @Author xun&&Aiden2014
 * @create 2023/1/3 17:00
 */
@CrossOrigin//使用@CrossOrigin注解声明类和方法允许跨域访问
@RestController
@RequestMapping("/user")

public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    /**
     * 完成注册功能
     * @param user 用户实体类
     * @return 注册成功返回 success
     */
    @RequestMapping("/register")
    public String addUser(User user) {
        if(user.getUserName()==null||userService.findUser(user.getUserName())!=null){
            throw new RuntimeException("操作失败");
        }else{
            userService.addUser(user);
            return "操作成功";
        }
    }

    /**
     * 完成登录功能
     * @param userName 用户名
     * @param password 密码
     * @return 如果登录成功返回 {@code true}, 否则 {@code false}
     */
    @PostMapping("/login")
    public Token login(@RequestParam(defaultValue = "") String userName, @RequestParam(defaultValue = "") String password) {
        if(userService.login(userName,password)!=null){

            User user = userService.findUser(userName);
            String token = JwtUtil.createToken(user);
            Token tokenObj = new Token();
            tokenObj.setToken(token);
            return tokenObj;
        }else{
            throw new RuntimeException("用户名或密码错误");
        }
    }
}
