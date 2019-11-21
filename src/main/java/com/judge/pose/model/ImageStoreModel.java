package com.judge.pose.model;


public class ImageStoreModel {
    private boolean result;
    private String realPhotoName;

    public boolean isResult(){
        return  result;
    }

    public String getRealPhotoName() {
        return realPhotoName;
    }

    public void setRealPhotoName(String realPhotoName) {
        this.realPhotoName = realPhotoName;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}