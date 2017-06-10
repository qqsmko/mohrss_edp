package com.mohress.edp.controller;

import com.mohress.edp.model.Class;
import com.mohress.edp.service.IClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

//import com.jmr.model.t_completion;
//import com.jmr.service.ICompletionService;

@Controller
@RequestMapping("")
public class CompletionController {
	@Autowired
    IClassService t;
	
	@RequestMapping("completion-set")
    public ModelAndView listStudent(){
        ModelAndView mav = new ModelAndView();
        List<Class> sl = t.listFinishied();
        
        // 放入转发参数
        mav.addObject("sl", sl);
        // 放入jsp路径
        mav.setViewName("completion-set");
        return mav;
    }
	
	@RequestMapping("completion-check")
    public ModelAndView completionCheck(@RequestParam int checkstate){
        ModelAndView mav = new ModelAndView();
        List<Class> sl = t.listFinishied();
        
        // 放入转发参数
        mav.addObject("sl", sl);
        mav.addObject("checkState", checkstate);
        System.out.println(checkstate);
        // 放入jsp路径
        mav.setViewName("completion-check");
        return mav;
    }
	
	@RequestMapping("completion-detail")
    public ModelAndView completionDetail(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("completion-detail");
        return mav;
    }
	
	@RequestMapping("completion-info")
    public ModelAndView completionInfo(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("completion-info");
        return mav;
    }
	
	@RequestMapping("completion-checking")
    public ModelAndView completionChecking(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("completion-checking");
        return mav;
    }
}
