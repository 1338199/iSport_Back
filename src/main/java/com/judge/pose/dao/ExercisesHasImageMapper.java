package com.judge.pose.dao;

import com.judge.pose.domain.ExercisesHasImage;

import com.judge.pose.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component("exercisesHasImageMapper")
public interface ExercisesHasImageMapper extends Mapper<ExercisesHasImage> {
    @Select("select max(index_) " +
            "from exercises_has_image " +
            "where exercises_id = #{exId} ")
    Integer getMaxIndex(@Param("exId") Integer exId, @Param("imageId") Integer imageId);
}