package com.heart.smmsupload.service.impl;

import com.heart.smmsupload.dao.SMMSIpDao;
import com.heart.smmsupload.pojo.SMMSIp;
import com.heart.smmsupload.service.SMMSIpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: Heart
 * @Date: 2019/3/18 15:25
 */
@Service
public class SMMSIpServiceImpl implements SMMSIpService {

    @Autowired
    private SMMSIpDao smmsIpDao;

    @Override
    public int saveSMMSIp(SMMSIp smmsIp) {
        return smmsIpDao.insertSMMSIp(smmsIp);
    }

    @Override
    public int removeSMMSIp(SMMSIp smmsIp) {
        return smmsIpDao.deleteSMMSIp(smmsIp);
    }

    @Override
    public SMMSIp findSMMSIp(SMMSIp smmsIp) {
        return smmsIpDao.selectSMMSIp(smmsIp);
    }

    @Override
    public List<SMMSIp> findSMMSIpByUserId(Integer userId) {
        return smmsIpDao.selectSMMSIpByUserId(userId);
    }
}
