package com.judge.pose.dao;

import com.judge.pose.domain.User;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

public interface UserMapper extends Mapper<User> {
    /*@Insert({"INSERT INTO `pose`.`user` (password,name,phone,email) " +
            "value(#{password},#{name},#{phone},#{email})"})*/
    void register( User user);

    @Select("select count(*) " +
            "from user " +
            "where name = #{name}")
    Integer checkUserExisted(@Param("name") String name);

    java.lang.String GetUserNameById(int id);

    java.lang.String GetUserSigniture(int id);


    @Select("select u.* " +
            "from user u " +
            "where u.name=#{uname}")
    User getUserByName(@Param("uname") String name);

    @Select("select count(*) from user_has_exercises where user_id=#{userId} and exercises_id=#{exId}")
    Integer userTakeCourse(@Param("userId") Integer userId, @Param("exId") Integer exId);
}