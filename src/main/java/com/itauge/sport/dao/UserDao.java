package com.itauge.sport.dao;

import com.itauge.sport.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    public User getUserByMessage(@Param("username") String username, @Param("password") String password);
    public List<User> getAllUser(@Param("username") String username,@Param("pageStart") int PageStart,@Param("pageSize")int pageSize);
    public Integer getUserCounts(@Param("username") String username);
    public int updateState(@Param("id") Integer id, @Param("state") Boolean state);
    public int addUser(User user);
    public int deleteUser(@Param("id") Integer id);
    public User getUpdateUser(Integer id);
    public int editUser (User user);
}
