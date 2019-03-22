package com.heart.smmsupload.service;

import com.heart.smmsupload.pojo.SMMSUser;

/**
 * @Description:
 * @Author: Heart
 * @Date: 2019/3/18 15:24
 */
public interface SMMSUserService {

    int saveSMMSUser(SMMSUser smmsUser);

    int removeSMMSUserByPrimaryKey(Integer userId);

    int editSMMSUserByPrimaryKey(SMMSUser smmsUser);

    SMMSUser findSMMSUserByPrimaryKey(Integer userId);

    SMMSUser findSMMSUserByUsername(String username);

    SMMSUser findSMMSUser(SMMSUser smmsUser);
}
