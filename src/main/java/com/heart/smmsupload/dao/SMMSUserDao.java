package com.heart.smmsupload.dao;

import com.heart.smmsupload.pojo.SMMSUser;
import org.springframework.stereotype.Repository;

@Repository
public interface SMMSUserDao {

    int insertSMMSUser(SMMSUser smmsUser);

    int deleteSMMSUserByPrimaryKey(Integer userId);

    int updateSMMSUserByPrimaryKey(SMMSUser smmsUser);

    SMMSUser selectSMMSUserByPrimaryKey(Integer userId);

    SMMSUser selectSMMSUserByUsername(String username);

    SMMSUser selectSMMSUser(SMMSUser smmsUser);

}