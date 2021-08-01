package com.itauge.sport.controller;

import com.alibaba.fastjson.JSON;
import com.itauge.sport.dao.MenuDao;
import com.itauge.sport.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class MenuController {
    @Autowired
    MenuDao menuDao;

    @GetMapping("/menu")
    public String getAllMenus(){

        HashMap<String, Object> data = new HashMap<>();
        int status = 404;//錯誤404,成功200

        List<Menu> menus = menuDao.getMenus();
        if (menus != null){
            data.put("menus",menus);
            data.put("flag",200);
        }else {
            data.put("flag",404);
        }
        String s = JSON.toJSONString(data);

        return s;

    }
}
