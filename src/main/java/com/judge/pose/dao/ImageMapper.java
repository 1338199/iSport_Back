package com.judge.pose.dao;

import com.judge.pose.domain.Image;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface ImageMapper extends Mapper<Image> {
    List<String> StartExercise(int id);


    @Select("select exercises.id, exercises.title, exercises.description, image.address " +
            "    from exercises, image, exercises_has_image" +
            "    where exercises.id = exercises_has_image.exercises_id and exercises_has_image.index_ = 1 " +
            "    and exercises.type = #{type} and exercises_has_image.image_id = image.id")
    List<Map<String,Object> > GetAllCourses(@Param("type") String type);

    @Select("select exercises.id, exercises.title, exercises.comments, image.address, exercises.commentUser,exercises.type " +
            "    from exercises, image, exercises_has_image" +
            "    where exercises.id = exercises_has_image.exercises_id and exercises_has_image.index_ = 1 " +
            "    and  exercises_has_image.image_id = image.id")
    List<Map<String,Object> > GetAllCoursesNew();
    List<Map<String,Object> >GetRecommendation(int id);

    @Select("select count(*) " +
            "    from user_has_exercises " +
            "    where user_has_exercises.user_id = #{id} and user_has_exercises.exercises_id = #{ex_id}")
    int IsUserWithCourses(@Param("id") int id,@Param("ex_id") Integer ex_id);

    @Select("select max(id) " +
            "from image")
    Integer getMaxId();

    @Select("select i.* " +
            "from image i, exercises_has_image e " +
            "where i.id = e.image_id and e.exercises_id=#{exId}")
    ArrayList<Image> selectImagesByEx(@Param("exId") Integer exId);

    @Update("update exercises "+
            "set exercises.comments= #{comment} , exercises.commentUser = #{commentUser} "+
            "where exercises.id  = #{exId}")
    void updateComment(@Param("exId") Integer exId, @Param("commentUser") String commentUser, @Param("comment") String comment);
}