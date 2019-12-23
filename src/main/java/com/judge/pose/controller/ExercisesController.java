package com.judge.pose.controller;

import com.judge.pose.dao.ExercisesMapper;
import com.judge.pose.dao.ImageMapper;
import com.judge.pose.dao.UserHasExercisesMapper;
import com.judge.pose.dao.UserMapper;
import com.judge.pose.domain.Exercises;
import com.judge.pose.domain.Image;
import com.judge.pose.domain.UserHasExercises;
import com.judge.pose.model.ResultModel;
import com.judge.pose.model.ResultModel2;
import org.apache.ibatis.javassist.expr.Instanceof;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class ExercisesController {

    @Autowired
    private ImageMapper imageMapper;
    @Autowired
    private UserHasExercisesMapper userHasExercisesMapper;
    @Autowired
    private ExercisesMapper exercisesMapper;

    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    @ResponseBody
    public ResultModel2 getAllCourses(@RequestParam("type") String type, @RequestParam("id") int id){
        List<Map<String, Object>> result = imageMapper.GetAllCourses(type);
        System.out.println(type);
        if(type.equals("all")){
            result= imageMapper.GetAllCoursesNew();
        }
        for(int i = 0;i < result.size();i++){
            System.out.println((result.get(i)).get("id") instanceof Integer);
            System.out.println((result.get(i)).get("id"));
            Integer exId = Integer.parseInt((result.get(i)).get("id").toString());
            if(imageMapper.IsUserWithCourses(id,exId)!= 0){
                result.get(i).put("Joined",1);
            }
            else{
                result.get(i).put("Joined",0);
            }
        }
        ResultModel2 resultModel2 = new ResultModel2(result);
        return resultModel2;
    }

    @RequestMapping(value = "/course/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResultModel2 getRecommendation(@PathVariable("id") int id){
        List<Map<String,Object> >result = imageMapper.GetRecommendation(id);

        ResultModel2 resultModel2 = new ResultModel2(result);
        return resultModel2;
    }

    @RequestMapping(value = "/imgs/{exercisesId}", method = RequestMethod.GET)
    @ResponseBody
    public Exercises getCourseFirstImage(@PathVariable("exercisesId") int exercisesId){
        ArrayList<Image> result =  imageMapper.selectImagesByEx(exercisesId);
        Exercises exercises = exercisesMapper.selectByPrimaryKey(exercisesId);
        if (exercises != null) {
            exercises.setImages(result);
        }
//        ResultModel resultModel = new ResultModel(result);
        return exercises;
        //return " index(totalNum) + image_url";
        //return"";s
    }

    @RequestMapping(value = "/img/{exercisesId}/image/{index}", method = RequestMethod.GET)
    @ResponseBody
    public String getCourseImageByIndex(@PathVariable("exercisesId") int exercisesId,@PathVariable("index")int index){
        return " current_index + image_url";
    }


    @RequestMapping(value = "/addCourse")
    @ResponseBody
    public String addCourse(@RequestParam("id") Integer userId, @RequestParam("exId") Integer exId) {
        UserHasExercises userHasExercises = new UserHasExercises(userId,exId);
        UserHasExercises temp = userHasExercisesMapper.selectOne(userHasExercises);
        if (temp != null && temp.getExercisesId() == userHasExercises.getExercisesId()) {
            return "This course already added";
        } else {
            userHasExercisesMapper.insert(userHasExercises);
            return "OK";

        }
    }

    @RequestMapping(value = "/updateComments")
    @ResponseBody
    public String updateComments(@RequestParam("exId") Integer exId,@RequestParam("commentUser") String commentUser, @RequestParam("comment") String comment) {
       imageMapper.updateComment(exId,commentUser,comment);
       return "OK";
    }
}

