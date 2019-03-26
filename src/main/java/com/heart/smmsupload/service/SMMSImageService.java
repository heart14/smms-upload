package com.heart.smmsupload.service;

import com.heart.smmsupload.pojo.SMMSImage;

import java.util.List;

/**
 * @Description:
 * @Author: Heart
 * @Date: 2019/3/18 15:24
 */
public interface SMMSImageService {

    /**
     * 保存图片上传信息
     *
     * @param smmsImage
     * @return
     */
    int saveSMMSImage(SMMSImage smmsImage);

    /**
     * 根据主键删除图片 物理删除
     *
     * @param imageId
     * @return
     */
    int removeSMMSImageByPrimaryKey(Integer imageId);

    /**
     * 修改所有图片信息
     * 魔法删除所有图片
     * @return
     */
    int editAllSMMSImageStatus();

    /**
     * 根据主键更新图片信息
     *
     * @param smmsImage
     * @return
     */
    int editSMMSImageByPrimaryKey(SMMSImage smmsImage);

    /**
     * 根据用户id更新图片信息 魔法删除一个用户下的所有图片
     *
     * @param userId
     * @return
     */
    int editSMMSImageByUserId(Integer userId);

    /**
     * 根据所有用户已上传图片
     *
     * @return
     */
    List<SMMSImage> findAllSMMSImage();

    /**
     * 根据主键查询图片
     *
     * @param imageId
     * @return
     */
    SMMSImage findSMMSImageByPrimaryKey(Integer imageId);

    /**
     * 根据用户id查询图片 查询一个用户下的所有图片
     *
     * @param userId
     * @return
     */
    List<SMMSImage> findSMMSImageListByUserId(Integer userId);
}
