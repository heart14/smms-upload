package com.heart.smmsupload.service.impl;

import com.heart.smmsupload.dao.SMMSImageDao;
import com.heart.smmsupload.pojo.SMMSImage;
import com.heart.smmsupload.service.SMMSImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: Heart
 * @Date: 2019/3/18 15:24
 */
@Service
public class SMMSImageServiceImpl implements SMMSImageService {

    @Autowired
    private SMMSImageDao smmsImageDao;

    @Override
    public int saveSMMSImage(SMMSImage smmsImage) {
        return smmsImageDao.insertSMMSImage(smmsImage);
    }

    @Override
    public int removeSMMSImageByPrimaryKey(Integer imageId) {
        return smmsImageDao.deleteSMMSImageByPrimaryKey(imageId);
    }

    @Override
    public int editSMMSImageByPrimaryKey(SMMSImage smmsImage) {
        return smmsImageDao.updateSMMSImageByPrimaryKey(smmsImage);
    }

    @Override
    public int editSMMSImageByUserId(Integer userId) {
        return smmsImageDao.updateSMMSImageByUserId(userId);
    }

    @Override
    public List<SMMSImage> findSMMSImageListByUserId(Integer userId) {
        return smmsImageDao.selectSMMSImageListByUserId(userId);
    }

    @Override
    public SMMSImage findSMMSImageByPrimaryKey(Integer imageId) {
        return smmsImageDao.selectSMMSImageByPrimaryKey(imageId);
    }
}
