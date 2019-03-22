package com.heart.smmsupload.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping("/index")
    public ModelAndView indexPage() {
        return new ModelAndView("index");
    }

    @RequestMapping("/uploadindex")
    public ModelAndView uploadIndexPage() {
        return new ModelAndView("uploadIndex");
    }

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
