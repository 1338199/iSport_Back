package com.judge.pose.util;

import com.judge.pose.model.ImageStoreModel;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class FileUtils {

    /**
     * @param file     文件
     * @param filePath 文件存放路径
     * @param fileName 源文件名
     * @return
     */
    public static ImageStoreModel upload(MultipartFile file, String filePath, String fileName) throws Exception {

        ImageStoreModel imageStoreModel = new ImageStoreModel();
        String realName = getFileName(fileName);
        String realPath = filePath + "/" + realName;
        imageStoreModel.setRealPhotoName(realName);
        File dest = new File(realPath);
        if(!dest.getParentFile().exists()){
            dest.getParentFile().mkdirs();
        }
        try {
            //保存文件
            file.transferTo(dest);
            imageStoreModel.setResult(true);
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            imageStoreModel.setResult(false);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            imageStoreModel.setResult(false);
        }
        return imageStoreModel;
    }
    /**
     * 生成新的文件名
     * @param fileOriginName 源文件名
     * @return
     */
    public static String getFileName(String fileOriginName){
        return getUUID() + getSuffix(fileOriginName);
    }

    /**
     * 获取文件后缀
     * @param fileName
     * @return
     */
    public static String getSuffix(String fileName){
        return fileName.substring(fileName.lastIndexOf("."));
    }

    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }

}

