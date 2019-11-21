package com.judge.pose.service;

import com.judge.pose.dao.ExercisesHasImageMapper;
import com.judge.pose.dao.ExercisesMapper;
import com.judge.pose.dao.ImageMapper;
import com.judge.pose.domain.Exercises;
import com.judge.pose.domain.ExercisesHasImage;
import com.judge.pose.domain.Image;
import com.judge.pose.util.QiniuUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;

@Service
public class FileService {

    @Autowired
    private ImageMapper imageMapper;
    @Autowired
    private ExercisesMapper exercisesMapper;
    @Autowired
    private ExercisesHasImageMapper exercisesHasImageMapper;

    public void qiniuUpload(MultipartFile file, Integer exerciseId, String filename, String desc) throws IOException {
        byte[] uploadBytes = file.getBytes();
        String key = exerciseId+"_"+filename;
        String domain = "pqx56p2qu.bkt.clouddn.com/";
        String url = domain + key;
        System.out.println(url);
        QiniuUpload.uploadBytes(uploadBytes,key);
        updateDB(url, exerciseId,  desc);
    }

    void updateDB(String url, Integer exerciseId,  String desc) {
        // insert entity
        Integer id = generateImageId();
        Image image = new Image(id, url, desc);
        try {
            imageMapper.insert(image);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error Occur While Adding image to the database");
        } finally {
//            Image tempImg = imageMapper.selectByPrimaryKey(image.getId());
////            if (tempImg.getAddress()!=null) {
////                System.out.println("Insert successfully");
////            } else {
////                System.out.println("Insert Fail");
////                return;
////            }
        }

        // build relation
        Integer index = generateImageIndex(exerciseId, image.getId());
        ExercisesHasImage relation = new ExercisesHasImage(exerciseId,image.getId(),index);
        exercisesHasImageMapper.insert(relation);
    }

    int generateImageId() {
        Integer id = imageMapper.getMaxId();
        if (id == null) {
            id = 1;
        } else {
            id++;
        }
        return id;
    }

    int generateImageIndex(Integer exId, Integer imageId) {
        Integer index = exercisesHasImageMapper.getMaxIndex(exId, imageId);
        if (index == null) {
            index = 1;
        } else {
            index ++;
        }
        return index;
    }
}
