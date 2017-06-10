package com.mohress.edp.controller;

import com.mohress.edp.model.Teacher;
import com.mohress.edp.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("")
public class TeacherController {
	@Autowired
	ITeacherService teacherService;
	
	@RequestMapping(value="teacher-list",method= RequestMethod.GET)
    public ModelAndView listTeacher(){
        ModelAndView mav = new ModelAndView();
        List<Teacher> sl = teacherService.list();
        
        // 放入转发参数
        mav.addObject("sl", sl);
        // 放入jsp路径
        mav.setViewName("teacher-list");
        return mav;
    }
	
	@RequestMapping(value="teacher-list/delete",method= RequestMethod.POST)
	@ResponseBody
	public String doDelete(HttpServletRequest request, HttpServletResponse response){
		String s = request.getParameter("id");
		try {
		    int b = Integer.valueOf(s).intValue();
		    teacherService.deleteOne(b);
		    return "{\"success\":true}";
		} catch (NumberFormatException e) {
		    e.printStackTrace();
		}
		return "{\"success\":false}";
	}
	
	@RequestMapping(value="teacher-list/deleteall",method= RequestMethod.POST)
	@ResponseBody
	public String doDeleteAll( @RequestParam(value = "ids[]",required = false,defaultValue = "") String[] ids){
		int lens = ids.length;
		for(int i=0;i<lens;i++){
			try {
			    int b = Integer.valueOf(ids[i]).intValue();
			    teacherService.deleteOne(b);
			} catch (NumberFormatException e) {
			    e.printStackTrace();
			    return "{\"success\":false}";
			}
		}
		return "{\"success\":true}";
	}
	
	@RequestMapping(value="teacher-update",method= RequestMethod.GET)
    public ModelAndView teacherUpdate(@RequestParam int id){
		ModelAndView mav = new ModelAndView();
		
		Teacher teacher = teacherService.getOne(id);
		mav.addObject("id",id);
		mav.addObject("teacher",teacher);
		
        // ����jsp·��
        mav.setViewName("teacher-update");
        return mav;
	}
	
	@RequestMapping(value="teacher-update/submit",method= RequestMethod.GET)
	@ResponseBody
	public String doUpdate(HttpServletRequest request, HttpServletResponse response){
		String teacherid = request.getParameter("teacherid");
		String name = request.getParameter("name");
		teacherService.updateOne(teacherid, name);
		return "{\"success\":true}";
	}
	
	@RequestMapping(value="teacher-add",method= RequestMethod.GET)
    public ModelAndView teacherAdd(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mav = new ModelAndView();
		
        // ����jsp·��
        mav.setViewName("teacher-add");
        return mav;
	}
	
	@RequestMapping(value="teacher-add/submit",method= RequestMethod.GET)
	@ResponseBody
	public String doAdd(HttpServletRequest request, HttpServletResponse response){
		
		String name = request.getParameter("name");
		teacherService.insertOne(name);
		return "{\"success\":true}";
	}
	
	@RequestMapping(value="teacher-list/data-source",method= RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> doDataTestPOST(@RequestParam int draw, @RequestParam int start, @RequestParam int length){
		return teacherService.getData(draw,start,length);
	}
}