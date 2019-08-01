package com.ao.billms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @PostMapping("/login")
    public String login(String username, String password, Map<String,Object> map, HttpSession session){
        // if user name not null ,  password =123
        if(!StringUtils.isEmpty(username)&&"123".equals(password)){
            //login success
            session.setAttribute("login_user",username);
            return "redirect:/main.html";

        }else{
            //login fail
            map.put("msg","username or password incorrect");
            return "main/login";
        }


    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        //clean user info in the session
            session.removeAttribute("login_user");
        //destory the session
            session.invalidate();
        //redirect to index page
            return "redirect:/index.html";

    }
}
