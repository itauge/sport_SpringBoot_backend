package com.itauge.sport.controller;

import com.alibaba.fastjson.JSON;
import com.itauge.sport.dao.UserDao;
import com.itauge.sport.entity.QueryInfo;
import com.itauge.sport.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserDao userDao;

    @GetMapping("/alluser")
    public String getAllUser(QueryInfo queryInfo){
        //加百分號,用於模糊查詢
        int numbers = userDao.getUserCounts("%" + queryInfo.getQuery() + "%");
        int pageStart = (queryInfo.getPageNum() - 1) * queryInfo.getPageSize();

        List<User> allUser = userDao.getAllUser("%" + queryInfo.getQuery() + "%", pageStart, queryInfo.getPageSize());
        HashMap<String, Object> res = new HashMap<>();
        res.put("numbers",numbers);
        res.put("user",allUser);
        return JSON.toJSONString(res);
    }

    @PutMapping("/updateState")
    public String updateUserState(@RequestParam("id")int id,
                                  @RequestParam("state") boolean state){
        int i = userDao.updateState(id, state);
        return i > 0?"success":"error";
    }

    @RequestMapping("/addUser")
    public String addUser(@RequestBody User user){
        user.setRole("普通用戶");
        user.setState(false);
        int i = userDao.addUser(user);
        return i>0?"success":"error";
    }

    @RequestMapping("/delUser/{id}")
    public String delUser(@PathVariable("id") Integer id){
        int i = userDao.deleteUser(id);
        return i>0?"success":"error";
    }

    @RequestMapping("/getUserById/{id}")
    public String getUpdateUser(@PathVariable("id") Integer id){
        User user = userDao.getUpdateUser(id);
        return JSON.toJSONString(user);
    }

    @RequestMapping("/updateUser")
    public String updateUser(@RequestBody User user){
        int i = userDao.editUser(user);
        return i>0?"success":"error";

    }

}
