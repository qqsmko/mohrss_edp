package com.mohress.edp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class UkeyController {
	
	@RequestMapping("ukey-list")
    public ModelAndView listStudent(){
        ModelAndView mav = new ModelAndView();

        // 放入jsp路径
        mav.setViewName("ukey-list");
        return mav;
    }
	
	@RequestMapping("ukey-check")
    public ModelAndView UkeyCheck(){
        ModelAndView mav = new ModelAndView();

        // 放入jsp路径
        mav.setViewName("ukey-check");
        return mav;
    }
	
	@RequestMapping("ukey-check-plus")
    public ModelAndView UkeyCheckPlus(){
        ModelAndView mav = new ModelAndView();

        // 放入jsp路径
        mav.setViewName("ukey-check-plus");
        return mav;
    }
}
