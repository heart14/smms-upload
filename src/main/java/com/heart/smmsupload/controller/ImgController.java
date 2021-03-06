package com.heart.smmsupload.controller;

import com.alibaba.fastjson.JSONObject;
import com.heart.smmsupload.pojo.SMMSImage;
import com.heart.smmsupload.pojo.SMMSIp;
import com.heart.smmsupload.pojo.SMMSUser;
import com.heart.smmsupload.response.SMMSResponse;
import com.heart.smmsupload.service.SMMSImageService;
import com.heart.smmsupload.service.SMMSIpService;
import com.heart.smmsupload.util.HttpUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * 图片上传控制器
 */
@RequestMapping("/img")
@RestController
public class ImgController {

    private static final Logger logger = LoggerFactory.getLogger(ImgController.class);

    @Value("${IMG_STORE_PATH}")
    String imgPath;

    @Value("${UPLOAD_API_URL}")
    String uploadApiUrl;

    @Value("${HISTORY_API_URL}")
    String historyApiUrl;

    @Value("${CLEAR_API_URL}")
    String clearApiUrl;

    @Autowired
    private SMMSImageService smmsImageService;

    @Autowired
    private SMMSIpService smmsIpService;


    /**
     * 用户首页 展示用户所有图片
     * @param request
     * @return
     */
    @RequestMapping("/smms")
    public ModelAndView smmsPage(HttpServletRequest request) {
        logger.info("↓↓↓↓ 查询当前用户所有图片 ↓↓↓↓");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");

        SMMSUser smmsuser = (SMMSUser) request.getSession().getAttribute("SMMSUSER");
        List<SMMSImage> smmsImageListByUserId = smmsImageService.findSMMSImageListByUserId(smmsuser.getUserId());
        logger.info("图片共 :{} ,当前用户 :{}", smmsImageListByUserId.size(), smmsuser);

        modelAndView.addObject("smmsUser", smmsuser);
        modelAndView.addObject("smmsImageList", smmsImageListByUserId);
        logger.info("↑↑↑↑ 查询当前用户所有图片 ↑↑↑↑");
        return modelAndView;
    }

    /**
     * 图片上传 支持批量上传
     *
     * @param multipartFiles
     * @return
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ModelAndView imgUpload(@RequestParam("multipartFiles") MultipartFile[] multipartFiles, HttpServletRequest request) {
        logger.info("↓↓↓↓ 图片上传 ↓↓↓↓");
        SMMSResponse smmsResponse = new SMMSResponse();
        SMMSUser smmsUser = (SMMSUser) request.getSession().getAttribute("SMMSUSER");
        if (smmsUser == null) {
            logger.info("用户未登录！");
            smmsResponse.setMsg("用户未登录！");
            return new ModelAndView("login");
        }
        logger.info("当前用户 : {}", smmsUser);
        logger.info("开始进行图片上传");

        List<File> list = new ArrayList<>();
        File file = null;
        int failNum = 0;

        //将上传的文件缓存至本地
        logger.info("建立临时文件缓存");
        for (MultipartFile multipartFile : multipartFiles) {
            try {
                File targetDir = new File(imgPath);
                if (!targetDir.exists()) {
                    targetDir.mkdirs();
                }
                file = new File(imgPath + "\\" + multipartFile.getOriginalFilename());
                multipartFile.transferTo(file);
                list.add(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //上传至sm.ms
        logger.info("上传至http://sm.ms");
        String resp = "";
        String tempIp = "";
        List<Map<String, String>> data = new ArrayList<>();
        for (File tempfile : list) {
            resp = HttpUtils.doPostImage(uploadApiUrl, tempfile);
            Map<String, String> map = new HashMap<>();
            SMMSImage smmsImage = new SMMSImage();
            if ("success".equals(JSONObject.parseObject(resp).getString("code"))) {
                String filename = JSONObject.parseObject(JSONObject.parseObject(resp).getString("data")).getString("filename");
                String url = JSONObject.parseObject(JSONObject.parseObject(resp).getString("data")).getString("url");
                String delete = JSONObject.parseObject(JSONObject.parseObject(resp).getString("data")).getString("delete");
                Integer width = JSONObject.parseObject(JSONObject.parseObject(resp).getString("data")).getInteger("width");
                Integer height = JSONObject.parseObject(JSONObject.parseObject(resp).getString("data")).getInteger("height");
                String storename = JSONObject.parseObject(JSONObject.parseObject(resp).getString("data")).getString("storename");
                Integer size = JSONObject.parseObject(JSONObject.parseObject(resp).getString("data")).getInteger("size");
                String path = JSONObject.parseObject(JSONObject.parseObject(resp).getString("data")).getString("path");
                String hash = JSONObject.parseObject(JSONObject.parseObject(resp).getString("data")).getString("hash");
                long timestamp = JSONObject.parseObject(JSONObject.parseObject(resp).getString("data")).getLong("timestamp");
                String ip = JSONObject.parseObject(JSONObject.parseObject(resp).getString("data")).getString("ip");

                tempIp = ip;

                smmsImage.setFilename(filename);
                smmsImage.setStorename(storename);
                smmsImage.setSize(size);
                smmsImage.setWidth(width);
                smmsImage.setHeight(height);
                smmsImage.setHash(hash);
                smmsImage.setDeleteUrl(delete);
                smmsImage.setUrl(url);
                smmsImage.setPath(path);
                smmsImage.setStatus(0);
                smmsImage.setUserId(smmsUser.getUserId());
                smmsImage.setUserIp(ip);
                smmsImage.setCreateTime(new Date(timestamp * 1000));

                map.put("filename", filename);
                map.put("url", url);
                map.put("delete", delete);
            } else {
                failNum++;
                String errMsg = JSONObject.parseObject(resp).getString("msg");

                smmsImage.setFilename(tempfile.getName());
                smmsImage.setStatus(1);
                smmsImage.setMsg(errMsg);
                smmsImage.setUserId(smmsUser.getUserId());
                smmsImage.setCreateTime(new Date());

                map.put("filename", tempfile.getName());
                map.put("errMsg", errMsg);
            }
            smmsImageService.saveSMMSImage(smmsImage);
            data.add(map);
        }
        smmsResponse.setMsg("图片上传完毕， 共" + list.size() + "， 失败" + failNum);
        smmsResponse.setData(data.toString());

        SMMSIp smmsIp = new SMMSIp();
        smmsIp.setUserId(smmsUser.getUserId());
        smmsIp.setUserIp(tempIp);
        if (smmsIpService.findSMMSIp(smmsIp) == null) {
            smmsIpService.saveSMMSIp(smmsIp);
        }

        //清理本地缓存文件
        boolean delete = false;
        for (File tempfile : list) {
            if (tempfile.exists()) {
                delete = tempfile.delete();
            }
        }
        logger.info("清理本地临时文件{}", delete ? "完毕" : "失败");
        logger.info("↑↑↑↑ 图片上传 ↑↑↑↑");
        return smmsPage(request);
    }

    /**
     * 查询所有用户历史上传图片（过时）
     *
     * @return
     */
    @RequiresRoles({"admin"})//需要admin才可以访问
    @RequestMapping("/history")
    public List<SMMSImage> getUploadHistory() {
        logger.info("↓↓↓↓ 查询所有用户历史上传图片 ↓↓↓↓");
        List<SMMSImage> allSMMSImage = smmsImageService.findAllSMMSImage();
        logger.info("↑↑↑↑ 查询所有用户历史上传图片 ↑↑↑↑");
//        return HttpUtils.doGet(historyApiUrl);
        return allSMMSImage;
    }

    /**
     * 删除所有用户历史上传图片（过时）
     *
     * @param request
     * @return
     */
    @RequiresRoles("admin")//需要admin才可以访问
    @RequestMapping("/clear")
    public SMMSResponse clearUploadHistory(HttpServletRequest request) {
        logger.info("↓↓↓↓ 删除所有用户历史上传图片 ↓↓↓↓");
        SMMSResponse smmsResponse = new SMMSResponse();

        SMMSUser smmsUser = (SMMSUser) request.getSession().getAttribute("SMMSUSER");
        if (smmsUser == null) {
            logger.info("用户登录信息已过期！");
            smmsResponse.setMsg("用户登录信息已过期！请重新登录");
            return smmsResponse;
        }
        logger.info("当前用户id :{}", smmsUser.getUserId());

        //获取所有图片 请求删除图片api
        List<SMMSImage> allSMMSImage = smmsImageService.findAllSMMSImage();
        for (SMMSImage smmsImage : allSMMSImage) {
            logger.info("删除 :{}", smmsImage.getDeleteUrl());
            HttpUtils.doGet(smmsImage.getDeleteUrl());
        }
        //更新数据库所有图片状态为2
        int editAllSMMSImageStatus = smmsImageService.editAllSMMSImageStatus();
        logger.info("数据库删除数量 :{} ,API删除数量 :{}", editAllSMMSImageStatus, allSMMSImage.size());

        smmsResponse.setMsg("数据库删除数量 " + editAllSMMSImageStatus + " ,API删除数量 " + allSMMSImage.size());
        logger.info("↑↑↑↑ 删除所有用户历史上传图片 ↑↑↑↑");
        return smmsResponse;
    }

    /**
     * 查询当前用户所有历史上传图片
     *
     * @param request
     * @return
     */
    @RequestMapping("/getUsersAllImage")
    public SMMSResponse getUsersAllImage(HttpServletRequest request) {
        logger.info("查询当前用户所有图片");
        SMMSResponse smmsResponse = new SMMSResponse();
        SMMSUser smmsUser = (SMMSUser) request.getSession().getAttribute("SMMSUSER");
        logger.info("当前用户 : {}", smmsUser);

        List<SMMSImage> smmsImageListByUserId = smmsImageService.findSMMSImageListByUserId(smmsUser.getUserId());
        List<Map<String, String>> list = new ArrayList<>();
        if (smmsImageListByUserId != null && smmsImageListByUserId.size() > 0) {
            for (SMMSImage smmsImage : smmsImageListByUserId) {
                Map<String, String> map = new HashMap<>();
                map.put("imageid", smmsImage.getImageId().toString());
                map.put("filename", smmsImage.getFilename());
                map.put("url", smmsImage.getUrl());
                map.put("delurl", smmsImage.getDeleteUrl());
                list.add(map);
            }
            smmsResponse.setMsg("查询成功，共 " + list.size());
            smmsResponse.setData(list.toString());
            return smmsResponse;
        }
        smmsResponse.setMsg("查询成功，共 0");
        smmsResponse.setData(null);

        return smmsResponse;
    }

    /**
     * 删除当前用户的所有历史上传图片
     *
     * @param request
     * @return
     */
    @RequestMapping("/removeUsersAllImage")
    public SMMSResponse removeUsersAllImage(HttpServletRequest request) {
        logger.info("↓↓↓↓ 删除当前用户所有图片 ↓↓↓↓");
        SMMSResponse smmsResponse = new SMMSResponse();
        SMMSUser smmsUser = (SMMSUser) request.getSession().getAttribute("SMMSUSER");
        logger.info("当前用户 :{}", smmsUser);

        List<SMMSImage> smmsImageListByUserId = smmsImageService.findSMMSImageListByUserId(smmsUser.getUserId());
        for (SMMSImage smmsImage : smmsImageListByUserId) {
            logger.info("删除 :{}", smmsImage.getDeleteUrl());
            HttpUtils.doGet(smmsImage.getDeleteUrl());
        }

        int editSMMSImageByUserId = smmsImageService.editSMMSImageByUserId(smmsUser.getUserId());
        smmsResponse.setMsg(editSMMSImageByUserId + " 张图片已删除");
        logger.info("↑↑↑↑ 删除当前用户所有图片 ↑↑↑↑");
        return smmsResponse;
    }
}
