package com.mohress.edp.controller;

import com.mohress.edp.model.Class;
import com.mohress.edp.model.Student;
import com.mohress.edp.service.IClassService;
import com.mohress.edp.service.IStudentService;
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

@Controller
@RequestMapping("")
public class StudentController {
	@Autowired
	IStudentService t;
	@Autowired
	IClassService classService;
	
	@RequestMapping(value="student-list",method= RequestMethod.GET)
    public ModelAndView listStudent(){
        ModelAndView mav = new ModelAndView();
        List<Student> sl = t.list();
        
        // 放入转发参数
        mav.addObject("sl", sl);
        // 放入jsp路径
        mav.setViewName("student-list");
        return mav;
    }
	
	@RequestMapping(value="student-classinfo",method= RequestMethod.GET)
    public ModelAndView doClassInfoGET(){
        ModelAndView mav = new ModelAndView();
        List<Class> sl =  classService.listFinishied();
        mav.addObject("sl",sl);
        mav.setViewName("student-classinfo");
        return mav;
    }
	
	@RequestMapping(value="student-fingerprint",method= RequestMethod.GET)
    public ModelAndView doStudentFingerPrintGET(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("student-fingerprint");
        return mav;
    }
	
	@RequestMapping(value="student-image",method= RequestMethod.GET)
    public ModelAndView doStudentImageGET(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("student-image");
        return mav;
    }
	
	@RequestMapping(value="student-idcard",method= RequestMethod.GET)
    public ModelAndView doStudentIdcardGET(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("student-idcard");
        return mav;
    }
	
	@RequestMapping(value="student-list",method= RequestMethod.POST)
	@ResponseBody
	public String doPost(HttpServletRequest request, HttpServletResponse response){
		String s = request.getParameter("id");
		try {
		    int b = Integer.valueOf(s).intValue();
		    t.setOnesState(b);
		    return "{\"success\":true}";
		} catch (NumberFormatException e) {
		    e.printStackTrace();
		}
		return "{\"success\":false}";
	}
	
	@RequestMapping(value="student-list/delete",method= RequestMethod.POST)
	@ResponseBody
	public String doDelete(HttpServletRequest request, HttpServletResponse response){
		String s = request.getParameter("id");
		try {
		    int b = Integer.valueOf(s).intValue();
		    t.deleteOne(b);
		    return "{\"success\":true}";
		} catch (NumberFormatException e) {
		    e.printStackTrace();
		}
		return "{\"success\":false}";
	}
	
	@RequestMapping(value="student-list/deleteall",method= RequestMethod.POST)
	@ResponseBody
	public String doDeleteAll( @RequestParam(value = "ids[]",required = false,defaultValue = "") String[] ids){
		int lens = ids.length;
		for(int i=0;i<lens;i++){
			try {
			    int b = Integer.valueOf(ids[i]).intValue();
			    t.deleteOne(b);
			} catch (NumberFormatException e) {
			    e.printStackTrace();
			    return "{\"success\":false}";
			}
		}
		return "{\"success\":true}";
	}
	
	@RequestMapping(value="student-update",method= RequestMethod.GET)
    public ModelAndView studentUpdate(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mav = new ModelAndView();
		
		String id = request.getParameter("id");
		mav.addObject("id",id);
		
        // ����jsp·��
        mav.setViewName("student-update");
        return mav;
	}
	
	@RequestMapping(value="student-update/submit",method= RequestMethod.GET)
	@ResponseBody
	public String doUpdate(HttpServletRequest request, HttpServletResponse response){
		String studentid = request.getParameter("studentid");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String birthday = request.getParameter("birthday");
		String telephone = request.getParameter("telephone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String nation = request.getParameter("nation");
		String education = request.getParameter("education");
		String insuredstate = request.getParameter("insuredstate");
		t.updateOne(studentid, name, gender, birthday, telephone, email, address, nation, education, insuredstate);
		return "{\"success\":true}";
	}
	
	@RequestMapping("student-show")
    public ModelAndView studentShow(HttpServletRequest request, HttpServletResponse response){
		String tempId = request.getParameter("id");
		ModelAndView mav = new ModelAndView();

		try {
		    int b = Integer.valueOf(tempId).intValue();
		    Student s = t.getOne(b);
			mav.addObject("s", s);
		} catch (NumberFormatException e) {
		    e.printStackTrace();
		}
		
        // ����jsp·��
        mav.setViewName("student-show");
        return mav;
	}
	
	@RequestMapping(value="student-add",method= RequestMethod.GET)
    public ModelAndView studentAdd(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mav = new ModelAndView();
		
        // ����jsp·��
        mav.setViewName("student-add");
        return mav;
	}
	
	@RequestMapping(value="student-add/submit",method= RequestMethod.GET)
	@ResponseBody
	public String doAdd(HttpServletRequest request, HttpServletResponse response){
		
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String birthday = request.getParameter("birthday");
		String telephone = request.getParameter("telephone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String nation = request.getParameter("nation");
		String education = request.getParameter("education");
		String insuredstate = request.getParameter("insuredstate");
		t.insertOne(name,gender,birthday,telephone,email,address,nation,education,insuredstate);
		return "{\"success\":true}";
	}
}
