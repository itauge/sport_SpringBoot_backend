package com.itauge.sport.controller;

import com.alibaba.fastjson.JSON;
import com.itauge.sport.dao.UserDao;
import com.itauge.sport.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class LoginController {

    @Autowired
    UserDao userDao;

    @PostMapping("/login")
    public String login(@RequestBody User user){
        String flag = "error";
        User user1 = userDao.getUserByMessage(user.getUsername(), user.getPassword());
        HashMap<String, Object> res = new HashMap<>();
        if (user1!=null){
            flag= "ok";
        }
        res.put("flag",flag);
        res.put("user",user1);
        String res_json = JSON.toJSONString(res);
        return res_json;
    }

}
