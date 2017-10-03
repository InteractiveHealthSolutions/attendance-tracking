package com.ihs.ats.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ihs.ats.Data.DataDisplayController;
import com.ihs.ats.Data.DataSearchForm;
import com.ihs.ats.Data.GlobalParams.SearchFilter;
import com.ihs.ats.constants.SystemPermissions;
import com.ihs.ats.constants.WebGlobals;
import com.ihs.ats.context.Context;
import com.ihs.ats.context.ServiceContext;
import com.mysql.jdbc.StringUtils;
import com.ihs.ats.api.WorkGroupType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewWorkGroupController extends DataDisplayController{

	ViewWorkGroupController() {
		super("dataForm", new  DataSearchForm("workgroup", "Workgroup", SystemPermissions.VIEW_VOLUNTEER_DATA, true));
	}
	
	@RequestMapping(value="/viewWorkGroup", method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
    	
		String workGroupId = getStringFilter(SearchFilter.PROGRAM_ID, req);
		String workGroupName = getStringFilter(SearchFilter.NAME_PART, req);


		int totalRows=0;
    	Map<String, Object> model = new HashMap<String, Object>();
		
		req.setAttribute("editOrUpdateMessage", req.getParameter("editOrUpdateMessage"));
		ServiceContext sc = Context.getServices();
		try{
			List<WorkGroupType> list=new ArrayList();
			String action = req.getParameter("action");
			String pagerOffset = req.getParameter("pager.offset");		
			list = sc.getWorkGroupTypeService().getAllworkGroup(true, 0, WebGlobals.DEFAULT_PAGING_MAX_PAGE_ITEMS, null);	
			totalRows = list.size();
			addModelAttribute(model, "workGroupType", list);
			addModelAttribute(model, "workGroup", sc.getWorkGroupTypeService().getAllWorkGroup(true, 0, WebGlobals.DEFAULT_PAGING_MAX_PAGE_ITEMS, null));		
			addModelAttribute(model, "totalRows", list.size());
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
	
	public static String getStringFilter(SearchFilter filter, HttpServletRequest req){
		return (StringUtils.isEmptyOrWhitespaceOnly(req.getParameter(filter.FILTER_NAME()))) ? null : req.getParameter(filter.FILTER_NAME());
	}

}
