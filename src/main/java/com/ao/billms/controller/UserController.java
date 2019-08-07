package com.ao.billms.controller;

import com.ao.billms.entities.User;
import com.ao.billms.mapper.UserMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;


@Controller
public class UserController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    UserMapper userMapper;
    

    @GetMapping("/users")
    public String list(Map<String, Object> map, User user) {
        logger.info("userList" + user);

        List<User> users = userMapper.getUsers(user);

        map.put("users", users);
        map.put("username", user.getUsername());

        return "user/list";
    }

    /**
     * type = null 进入查看详情页面view.html，
     * type=update 则是进入update.html
     */
    @GetMapping("/user/{id}")
    public String view(@PathVariable("id") Integer id,
                       @RequestParam(value="type", defaultValue = "view") String type,
                       Map<String, Object> map) {
        logger.info("查询" + id + "的详细信息");

        User user = userMapper.getUserById(id);

        map.put("user", user);

        // type = null 则进入view.html， type=update 则是进入update.html
        return "user/" + type;
    }

    //修改供应商信息
    @PutMapping("/user")
    public String update(User user) {
        logger.info("更改信息。。。");
        //更新操作
        userMapper.updateUser(user);

        return "redirect:users";
    }

    //前往添加 页面
    @GetMapping("/user")
    public String toAddPage() {
        return "user/add";
    }


    //添加数据
    @PostMapping("/user")
    public String add(User user) {
        logger.info("添加数据" + user);
        //保存数据操作
        userMapper.addUser(user);

        return "redirect:/users";
    }

    //删除
    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable("id") Integer id) {
        logger.info("删除操作, id=" + id);
        userMapper.deleteUserById(id);

        return "redirect:/users";
    }

    @GetMapping("/user/pwd")
    public String toUpdatePwdPage() {
        return "main/password";
    }

    @ResponseBody
    @GetMapping("/user/pwd/{oldPwd}")
    public Boolean checkPwd(HttpSession session, @PathVariable("oldPwd") String oldPwd) {
        logger.info("旧密码:" + oldPwd);
        //1.从Session中获取当前登录用户的User对象
        User user = (User) session.getAttribute("login_user");
        if(user.getPassword().equals(oldPwd)) {
            //输入的旧密码正确
            return true;
        }
        return false;
    }

    @PostMapping("/user/pwd")
    public String updatePwd(HttpSession session, String password) {
        logger.info(password);
        //1.从Session中获取当前登录用户信息
        User user = (User) session.getAttribute("login_user");
        //2. 更新密码
        user.setPassword(password);
        //3. 提交到数据库
        userMapper.updateUser(user);
        //4. 注销重新登录
        return "redirect:/logout";
    }


}
