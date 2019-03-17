package com.heart.smmsupload.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 页面控制器
 */
@RequestMapping
@RestController
public class HomeController {

    @RequestMapping("/index")
    public ModelAndView indexPage() {
        return new ModelAndView("index");
    }

    @RequestMapping("/uploadindex")
    public ModelAndView uploadIndexPage() {
        return new ModelAndView("uploadIndex");
    }

    @RequestMapping("/historyindex")
    public ModelAndView historyIndexPage() {
        return new ModelAndView("historyIndex");
    }
}
