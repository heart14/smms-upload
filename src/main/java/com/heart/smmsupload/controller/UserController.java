package com.heart.smmsupload.controller;

import com.heart.smmsupload.pojo.SMMSUser;
import com.heart.smmsupload.service.SMMSUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Description:
 * @Author: Heart
 * @Date: 2019/3/18 16:50
 */
@RequestMapping("/user")
@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private SMMSUserService smmsUserService;

    /**
     * 用户登录
     *
     * @param smmsUser
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView userLogin(SMMSUser smmsUser, HttpServletRequest request) {

        logger.info("用户登录 : {} / {}", smmsUser.getUsername(), smmsUser.getPassword());

        ModelAndView modelAndView = new ModelAndView();

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(smmsUser.getUsername(), smmsUser.getPassword());

        try {
            subject.login(token);

            modelAndView.setViewName("home");
            HttpSession session = request.getSession();
            session.setAttribute("SMMSUSER", smmsUser);
            logger.info("登录成功！");
        } catch (AuthenticationException e) {
            modelAndView.setViewName("index");
            logger.info("登录失败！\n{}", e.getMessage());
        }
        return modelAndView;
    }

    /**
     * 用户注册
     *
     * @param smmsUser
     * @return
     */
    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public ModelAndView userReg(SMMSUser smmsUser) {
        logger.info("用户注册 : {} / {}", smmsUser.getUsername(), smmsUser.getPassword());

        ModelAndView modelAndView = new ModelAndView();

        SMMSUser findSmmsUser = smmsUserService.findSMMSUserByUsername(smmsUser.getUsername());
        if (findSmmsUser != null) {
            logger.info("注册失败！用户已存在");
        } else {
            smmsUser.setUserSalt(smmsUser.getUsername() + smmsUser.getPassword());
            smmsUser.setPassword(String.valueOf(new Md5Hash(new Md5Hash(smmsUser.getPassword(), smmsUser.getUserSalt()))));
            int saveSMMSUser = smmsUserService.saveSMMSUser(smmsUser);
            if (saveSMMSUser == 1) {
                logger.info("注册成功！");
            } else {
                logger.info("注册失败！");
            }
        }
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping("/logout")
    public ModelAndView userLogout() {
        logger.info("用户登出");
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return new ModelAndView("index");
    }
}
