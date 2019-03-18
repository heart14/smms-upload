package com.heart.smmsupload.service;

import com.heart.smmsupload.pojo.SMMSIp;

import java.util.List;

/**
 * @Description:
 * @Author: Heart
 * @Date: 2019/3/18 15:24
 */
public interface SMMSIpService {

    int saveSMMSIp(SMMSIp smmsIp);

    int removeSMMSIp(SMMSIp smmsIp);

    List<SMMSIp> findSMMSIpByUserId(Integer userId);

    SMMSIp findSMMSIp(SMMSIp smmsIp);
}
