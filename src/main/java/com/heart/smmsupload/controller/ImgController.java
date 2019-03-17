package com.heart.smmsupload.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 图片上传控制器
 */
@RequestMapping("/img")
@RestController
public class ImgController {

    private static final Logger logger = LoggerFactory.getLogger(ImgController.class);

    @Value("IMG_STORE_PATH")
    String imgPath;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String imgUpload(@RequestParam("multipartFiles") MultipartFile[] multipartFiles) {
        logger.info("(*Φ皿Φ*)    ↓↓↓↓↓↓↓↓    文件上传开始");

        Map<String, String> map = new HashMap<>();
        List<MultipartFile> list = new ArrayList<>();
        for (MultipartFile multipartFile : multipartFiles) {
            logger.info("文件名 : " + multipartFile.getOriginalFilename());
            map.put("name", multipartFile.getOriginalFilename());
        }

        logger.info("(*Φ皿Φ*)    ↑↑↑↑↑↑↑↑    文件上传结束");
        return null;
    }
}
