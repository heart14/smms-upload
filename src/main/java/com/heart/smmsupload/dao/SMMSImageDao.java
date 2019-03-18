package com.heart.smmsupload.dao;

import com.heart.smmsupload.pojo.SMMSImage;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SMMSImageDao {

    int insertSMMSImage(SMMSImage smmsImage);

    int deleteSMMSImageByPrimaryKey(Integer imageId);

    int updateSMMSImageByPrimaryKey(SMMSImage smmsImage);

    int updateSMMSImageByUserId(Integer userId);

    SMMSImage selectSMMSImageByPrimaryKey(Integer imageId);

    List<SMMSImage> selectSMMSImageListByUserId(Integer userId);

}