package com.judge.pose.dao;

import com.judge.pose.domain.Exercises;

import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

public interface ExercisesMapper extends Mapper<Exercises> {
    String StartExercise(String title);


//    @Select("select e.* " +
//            "from exercises e " +
//            "where e.id = #{exId}")
}