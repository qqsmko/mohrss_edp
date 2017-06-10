package com.mohress.edp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class VideoController {
	
	@RequestMapping("video-list")
    public ModelAndView listStudent(){
        ModelAndView mav = new ModelAndView();

        // 放入jsp路径
        mav.setViewName("video-list");
        return mav;
    }
	
	@RequestMapping("video-branch-list")
    public ModelAndView doVideoBranchListGET(){
        ModelAndView mav = new ModelAndView();

        // 放入jsp路径
        mav.setViewName("video-branch-list");
        return mav;
    }
	
}
