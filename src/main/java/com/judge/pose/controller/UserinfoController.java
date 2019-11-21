package com.judge.pose.controller;

import com.judge.pose.dao.UserinfoMapper;
import com.judge.pose.model.ImageStoreModel;
import com.judge.pose.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UserinfoController {
    @Autowired
    private UserinfoMapper userinfoMapper;



    @RequestMapping(value = "/user/information", method = RequestMethod.PUT)
    @ResponseBody
    public String  updateUserinfo(@RequestParam(value="id") int id, @RequestParam(value="age",required = false)int age,
                                  @RequestParam(value="gender",required = false)int gender, @RequestParam(value="avatar",required = false) java.lang.String avatar){
        if(userinfoMapper.CheckUpdate(id)!=0){
            userinfoMapper.UpdateUserInfo(id,age,gender);
            return "update success";
        }else{
            return "delete failed";
        }
    }
    public String upLoad(MultipartFile file){
        ImageStoreModel imageStoreModel= new ImageStoreModel();
        imageStoreModel.setResult(false);
        String filePath = "C:\\image";
        try{
            ImageStoreModel temp = FileUtils.upload(file, filePath, file.getOriginalFilename());
            imageStoreModel.setResult(temp.isResult());
            imageStoreModel.setRealPhotoName(temp.getRealPhotoName());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        if (imageStoreModel.isResult()==true) {
            // 上传成功，给出页面提示
            return  imageStoreModel.getRealPhotoName();
        } else {
            return null;
        }
    }
}
