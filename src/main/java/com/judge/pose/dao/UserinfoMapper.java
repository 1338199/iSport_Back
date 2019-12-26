package com.judge.pose.dao;

import com.judge.pose.domain.Userinfo;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

public interface UserinfoMapper extends Mapper<Userinfo> {
    int CheckUpdate(int id);
    void UpdateUserInfo(int id, int age, int gender);
    @Update("update user "+
            "set user.name= #{userName} , user.email= #{email} , user.phone= #{tel} , user.password = #{password} "+
            "where user.id  = #{userId} ")
    void UpdateUser(@Param("userId") Integer userId, @Param("userName") String userName, @Param("email") String email, @Param("tel") String tel,
                    @Param("password") String password);
}