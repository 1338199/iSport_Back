package com.judge.pose.controller;

import com.judge.pose.dao.ExercisesMapper;
import com.judge.pose.dao.UserHasExercisesMapper;
import com.judge.pose.domain.Exercises;
import com.judge.pose.model.ResultModel;
import com.judge.pose.model.ResultModel2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class UseExercisesController {
    @Autowired
    private UserHasExercisesMapper userHasExercisesMapper;
    @Autowired
    private ExercisesMapper exercisesMapper;


    @RequestMapping(value = "/user/{id}/{type}/courses", method = RequestMethod.GET)
    @ResponseBody
    public ResultModel2 getUserCourses(@PathVariable("id") int id,@PathVariable("type") String type){
        List<Map<String,Object> > result = userHasExercisesMapper.GetUserCourses(id,type);

        ResultModel2 resultModel2 = new ResultModel2(result);
        return resultModel2;
    }


    /*@RequestMapping(value = "/user/{id}/{exercisesId}/courses", method = RequestMethod.GET)

    @ResponseBody
    public String IsUserWithCourses(@PathVariable("id") int id,@PathVariable("ex_id") int ex_id){
        int result = userHasExercisesMapper.IsUserWithCourses(id,ex_id);
        if(result >= 1){
            return "Yes";
        }
        else{
            return "No";
        }

    }*/



    @RequestMapping(value = "/user/{id}/courses/{exercisesId}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteUserCourses(@PathVariable("id") int id,@PathVariable("exercisesId") int exercisesId){
        if(userHasExercisesMapper.CheckDeletion(id,exercisesId)!=0){
            userHasExercisesMapper.DeleteCourse(id,exercisesId);
            return "delete success";
        }else{
            return "delete failed";
        }

    }

}
