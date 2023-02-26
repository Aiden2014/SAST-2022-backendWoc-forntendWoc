package com.sast.woc.controller;

import com.sast.woc.entity.User;
import com.sast.woc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author xun&&Aiden2014
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
            return "操作成功";
        }else{
            throw new RuntimeException("操作失败");
        }
    }

    /**
     * 根据用户名查找用户
     * @param userName 用户名
     * @return User
     */
    @GetMapping("/find_user_info")
    public User findUser(String userName) {
        if(userService.findUser(userName)==null){
            throw new RuntimeException("操作失败");
        }
        return userService.findUser(userName);
    }
    /**
     * 完成修改功能
     * @param user 用户实体类
     * @return 修改成功返回 success
     */
    @RequestMapping("/change")
    public String changeUser(User user) {
        if(userService.findUser(user.getUserName())==null){

            throw new RuntimeException("操作失败");
        }else{
            userService.change(user);
            return "操作成功";
        }
    }
}
