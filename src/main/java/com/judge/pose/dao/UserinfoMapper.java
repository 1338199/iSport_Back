package com.judge.pose.dao;

import com.judge.pose.domain.Userinfo;

import tk.mybatis.mapper.common.Mapper;

public interface UserinfoMapper extends Mapper<Userinfo> {
    int CheckUpdate(int id);
    void UpdateUserInfo(int id, int age, int gender);

}