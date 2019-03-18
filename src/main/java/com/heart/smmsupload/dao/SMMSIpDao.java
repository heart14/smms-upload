package com.heart.smmsupload.dao;

import com.heart.smmsupload.pojo.SMMSIp;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SMMSIpDao {

    int insertSMMSIp(SMMSIp smmsIp);

    int deleteSMMSIp(SMMSIp smmsIp);

    List<SMMSIp> selectSMMSIpByUserId(Integer userId);

    SMMSIp selectSMMSIp(SMMSIp smmsIp);

}