package com.sast.woc.controller;

import com.sast.woc.entity.User;
import com.sast.woc.service.UserService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author xun
 * @create 2023/1/3 17:13
 */
@CrossOrigin//使用@CrossOrigin注解声明类和方法允许跨域访问
@RestController
@RequestMapping("/admin")
public class AdminController {
    //请仿照 User 补充 Admin 的三层架构并完成接口
    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    /**
     * 根据用户名删除用户
     * @param userName 用户名
     * @return 删除成功返回 success
     */
    @RequestMapping("/del_user")
    public String delUser(String userName) {
        if(userService.delUser(userName)){
            return "success";
        }else{
            return "fail";
        }
        // todo 补全代码

    }

    /**
     * 根据用户名查找用户
     * @param userName 用户名
     * @return User
     */
    @GetMapping("/find_user_info")
    public User findUser(String userName) {
        return userService.findUser(userName);
        // todo 补全代码，你需要去掉下面的 null

    }
    /**
     * 完成修改功能
     * @param user 用户实体类
     * @return 修改成功返回 success
     */
    @RequestMapping("/change")
    public String changeUser(User user) {
        if(userService.findUser(user.getUserName())==null){
            return "fail";
        }else{
            userService.change(user);
            return "success";
        }
        // todo 这里需要你补全
    }
}
