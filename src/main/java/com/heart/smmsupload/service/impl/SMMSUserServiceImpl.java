package com.heart.smmsupload.service.impl;

import com.heart.smmsupload.dao.SMMSUserDao;
import com.heart.smmsupload.pojo.SMMSUser;
import com.heart.smmsupload.service.SMMSUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: Heart
 * @Date: 2019/3/18 15:25
 */
@Service
public class SMMSUserServiceImpl implements SMMSUserService {

    @Autowired
    private SMMSUserDao smmsUserDao;

    @Override
    public int saveSMMSUser(SMMSUser smmsUser) {
        return smmsUserDao.insertSMMSUser(smmsUser);
    }

    @Override
    public int removeSMMSUserByPrimaryKey(Integer userId) {
        return smmsUserDao.deleteSMMSUserByPrimaryKey(userId);
    }

    @Override
    public int editSMMSUserByPrimaryKey(SMMSUser smmsUser) {
        return smmsUserDao.updateSMMSUserByPrimaryKey(smmsUser);
    }

    @Override
    public SMMSUser findSMMSUser(SMMSUser smmsUser) {
        return smmsUserDao.selectSMMSUser(smmsUser);
    }

    @Override
    public SMMSUser findSMMSUserByPrimaryKey(Integer userId) {
        return smmsUserDao.selectSMMSUserByPrimaryKey(userId);
    }

    @Override
    public SMMSUser findSMMSUserByUsername(String username) {
        return smmsUserDao.selectSMMSUserByUsername(username);
    }

}
