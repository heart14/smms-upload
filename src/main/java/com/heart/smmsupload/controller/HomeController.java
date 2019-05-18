package com.heart.smmsupload.controller;

import com.heart.smmsupload.pojo.SMMSUser;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 页面控制器
 */
@RequestMapping
@RestController
public class HomeController {

    @RequestMapping("/home")
    public ModelAndView homePage() {
        return new ModelAndView("home");
    }

    @RequestMapping("/login")
    public ModelAndView loginPage() {
        return new ModelAndView("login");
    }

//    @RequestMapping("/index")
//    public ModelAndView indexPage() {
//        return new ModelAndView("index");
//    }

//    @RequestMapping("/uploadindex")
//    public ModelAndView uploadIndexPage() {
//        return new ModelAndView("uploadIndex");
//    }

//    @RequiresRoles("admin")
//    @RequestMapping("/historyindex")
//    public ModelAndView historyIndexPage() {
//        return new ModelAndView("historyIndex");
//    }

//    @RequestMapping("/403")
//    public ModelAndView unAuthcPage() {
//        return new ModelAndView("403");
//    }
//
//    @RequestMapping("/error")
//    public ModelAndView errorPage() {
//        return new ModelAndView("error");
//    }
}
