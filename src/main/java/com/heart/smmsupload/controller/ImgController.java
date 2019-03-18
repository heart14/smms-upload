package com.heart.smmsupload.controller;

import com.alibaba.fastjson.JSONObject;
import com.heart.smmsupload.pojo.SMMSImage;
import com.heart.smmsupload.pojo.SMMSUser;
import com.heart.smmsupload.response.SMMSResponse;
import com.heart.smmsupload.service.SMMSImageService;
import com.heart.smmsupload.util.HttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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

    /**
     * 图片上传 支持批量上传
     *
     * @param multipartFiles
     * @return
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public SMMSResponse imgUpload(@RequestParam("multipartFiles") MultipartFile[] multipartFiles, HttpServletRequest request) {

        SMMSResponse smmsResponse = new SMMSResponse();
        SMMSUser smmsUser = (SMMSUser) request.getSession().getAttribute("currentUser");
        if (smmsUser == null) {
            logger.info("用户未登录！");
            smmsResponse.setMsg("用户未登录！");
            return smmsResponse;
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
        smmsResponse.setData(data);

        //清理本地缓存文件
        boolean delete = false;
        for (File tempfile : list) {
            if (tempfile.exists()) {
                delete = tempfile.delete();
            }
        }
        logger.info("清理本地临时文件{}", delete ? "完毕" : "失败");
        return smmsResponse;
    }

    /**
     * 查询所有历史上传图片
     *
     * @return
     */
    @RequestMapping("/history")
    public String getUploadHistory() {
        logger.info("查询历史上传图片");
        return HttpUtils.doGet(historyApiUrl);
    }

    /**
     * 删除所有历史上传图片
     *
     * @param request
     * @return
     */
    @RequestMapping("/clear")
    public String clearUploadHistory(HttpServletRequest request) {
        SMMSUser smmsUser = (SMMSUser) request.getSession().getAttribute("currentUser");
        if (smmsUser == null) {
            logger.info("用户未登录！");
            return "用户未登录！";
        }
        logger.info("当前用户 : {}", smmsUser);
        logger.info("清除历史上传图片，用户id : {}", smmsUser.getUserId());
        int editSMMSImageByUserId = smmsImageService.editSMMSImageByUserId(smmsUser.getUserId());
        logger.info("成功删除 {} 张图片", editSMMSImageByUserId);
        return HttpUtils.doGet(clearApiUrl);
    }
}
