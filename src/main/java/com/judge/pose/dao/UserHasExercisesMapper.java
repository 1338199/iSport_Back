package com.judge.pose.dao;

import com.judge.pose.domain.UserHasExercises;


import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface UserHasExercisesMapper extends Mapper<UserHasExercises> {
    void DeleteCourse( int id, int ex_id);
    int CheckDeletion(int id,int ex_id);
    List<Map<String,Object> > GetUserCourses(int id,String type);
    int IsUserWithCourses(int id,int ex_id);
}