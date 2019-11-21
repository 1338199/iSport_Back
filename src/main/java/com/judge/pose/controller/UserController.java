package com.judge.pose.controller;


import com.judge.pose.dao.UserMapper;
import com.judge.pose.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/test")
    @ResponseBody
    public String test(HttpServletRequest request) {
        String uid = request.getParameter("uid");

        return uid;
    }

    @RequestMapping(value = "/user/{id}/name", method = RequestMethod.GET)
    @ResponseBody
    public String getUserName(@PathVariable("id") int id){
        String name = userMapper.GetUserNameById(id);
        if(name != null) {
            return name;
        }
        else{
            return "Id don't exist";
        }
    }

    @RequestMapping(value = "/user/{id}/Signiture", method = RequestMethod.GET)
    @ResponseBody
    public String getUserSigniture(@PathVariable("id") int id){
        String signiture = userMapper.GetUserSigniture(id);
        if(signiture != null) {
            return signiture;
        }
        else{
            return "Id don't exist";
        }
    }



    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    @ResponseBody
    public String register(@RequestParam("userName") String userName, @RequestParam("password") String password,
                           @RequestParam("phone") String phone, @RequestParam("email") String email) {
       if(userMapper.checkUserExisted(userName) < 1) {
            User user = new User();
            user.setName(userName);
            user.setPassword(password);
            user.setPhone(phone);
            user.setEmail(email);
            userMapper.register(user);
            return "Register Successfully";
        }else{

            return "Username already existed";

        }

    }

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestParam("userName") String userName, @RequestParam("password") String password, HttpServletRequest request) {
        //check user
        User user = userMapper.getUserByName(userName);
        if (user == null || user.getId() == null) {
            return "User doesn't exist!";
        }
        if (user.getPassword().equals(password)) {
            HttpSession session = request.getSession();
            if(session.getAttribute("userId")!=null) {
                System.out.println("您已登录");
                return user.getId().toString();

            }
            else {
                session.setAttribute("userId", user.getId());
                System.out.println("登录成功");
                return user.getId().toString();
            }
        } else {
            return "Password or Username incorrect!";
        }
    }

    @RequestMapping(value = "/user/hasCourse")
    @ResponseBody
    public Integer UserHasCourse(@RequestParam("exId") Integer exId, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Integer userId = session.getAttribute("userId") == null?1:(Integer)session.getAttribute("userId");
        System.out.println(userId);
        return userMapper.userTakeCourse(userId,exId);
    }



}
