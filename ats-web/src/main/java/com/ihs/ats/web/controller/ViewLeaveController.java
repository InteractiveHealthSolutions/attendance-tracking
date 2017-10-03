package com.ihs.ats.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ihs.ats.Data.DataDisplayController;
import com.ihs.ats.Data.DataSearchForm;
import com.ihs.ats.Data.DataViewCustomForm;
import com.ihs.ats.Data.GlobalParams.SearchFilter;
import com.ihs.ats.constants.SystemPermissions;
import com.ihs.ats.constants.WebGlobals;
import com.ihs.ats.context.Context;
import com.ihs.ats.context.ServiceContext;
import com.ihs.ats.context.*;
import com.ihs.ats.api.Leave;
import com.ihs.ats.api.WorkGroupType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Controller
@RequestMapping(value="/viewLeaves")
public class ViewLeaveController extends DataDisplayController{

	ViewLeaveController() {
		super("dataForm", new  DataSearchForm("leaves", "Leaves", SystemPermissions.VIEW_VOLUNTEER_DATA, true));
		// TODO Auto-generated constructor stub
	}
	@RequestMapping(method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		int totalRows=0;
    	Map<String, Object> model = new HashMap<String, Object>();
		ServiceContext sc = Context.getServices();
		
		try{
			List<Leave> list = new ArrayList();
			List<String> vacList=new ArrayList();
			String action = req.getParameter("action");
			String pagerOffset = req.getParameter("pager.offset");
//		uncheck!!!	list = sc.getAttendanceService().getAllLeaves(true, 0, WebGlobals.DEFAULT_PAGING_MAX_PAGE_ITEMS, null);
			totalRows = list.size();
			addModelAttribute(model, "Leaves", list);
			for(int i = 0 ; i < list.size() ; i++){
				vacList.add(list.get(i).getUserId().getName());  //For usernames
			}
			addModelAttribute(model, "vacs", vacList);
			return showForm(model);
		}
		catch (Exception e) {
			e.printStackTrace();
			req.getSession().setAttribute("exceptionTrace",e);
			return new ModelAndView("exception");
		}
		finally{
			sc.closeSession();
		}
	}	

}
