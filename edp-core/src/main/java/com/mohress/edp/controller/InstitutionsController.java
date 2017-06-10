package com.mohress.edp.controller;

import com.mohress.edp.model.Institutions;
import com.mohress.edp.service.IInstitutionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("")
public class InstitutionsController {
	@Autowired
	IInstitutionsService institutionsService;
	
	@RequestMapping(value="institutions-list",method= RequestMethod.GET)
    public ModelAndView doListGET(){
        ModelAndView mav = new ModelAndView();
        List<Institutions> sl = institutionsService.list();
        
        // 放入转发参数
        mav.addObject("sl", sl);
        // 放入jsp路径
        mav.setViewName("institutions-list");
        return mav;
    }
	
	@RequestMapping(value="institutions-list",method= RequestMethod.POST)
	@ResponseBody
	public String doListPOST(@RequestParam int id){
		System.out.println(id);
		institutionsService.setOnesState(id, 1);
        return "{\"success\":true}";
    }
	
	@RequestMapping("institutions-check")
    public ModelAndView institutionsCheck(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("institutions-check");
        return mav;
    }
	
	@RequestMapping("institutions-new")
    public ModelAndView institutionsNew(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("institutions-new");
        return mav;
    }
	
	@RequestMapping(value="institutions-new/submit",method= RequestMethod.POST)
	@ResponseBody
	public String institutionsNewPOST(@RequestBody Institutions institutions){
        institutionsService.insertOne(institutions);
        return "{\"success\":true}";
    }
	
	@RequestMapping(value="institutions-list/delete",method= RequestMethod.POST)
	@ResponseBody
	public String doDelete(@RequestParam int id){
		institutionsService.deleteOne(id);
		return "{\"success\":true}";
	}
	
	@RequestMapping(value="institutions-list/deleteall",method= RequestMethod.POST)
	@ResponseBody
	public String doDeleteAll(@RequestParam(value = "ids[]",required = false,defaultValue = "") String[] ids){
		int lens = ids.length;
		for(int i=0;i<lens;i++){
			try {
			    int b = Integer.valueOf(ids[i]).intValue();
			    institutionsService.deleteOne(b);
			} catch (NumberFormatException e) {
			    e.printStackTrace();
			    return "{\"success\":false}";
			}
		}
		return "{\"success\":true}";
	}
	
	@RequestMapping(value="institutions-update",method= RequestMethod.GET)
    public ModelAndView doUpdateGET(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mav = new ModelAndView();
		
		String id = request.getParameter("id");
		mav.addObject("id",id);
		
        // ����jsp·��
        mav.setViewName("institutions-update");
        return mav;
	}
	
	@RequestMapping(value="institutions-update/submit",method= RequestMethod.POST)
	@ResponseBody
	public Institutions doUpdatePOST(@RequestBody Institutions institutions){
		institutionsService.updateOne(institutions);
		return institutions;
	}
	
	@RequestMapping(value="institutions-list/data-source-test",method= RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> doDataPOST(@RequestParam int draw, @RequestParam int start, @RequestParam int length){
		return institutionsService.getData(draw,start,length);
	}
	
	@RequestMapping(value="institutions-list/data-source",method= RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> doDataTestPOST(@RequestParam int draw, @RequestParam int start, @RequestParam int length){
		return institutionsService.getData(draw,start,length);
	}
}
