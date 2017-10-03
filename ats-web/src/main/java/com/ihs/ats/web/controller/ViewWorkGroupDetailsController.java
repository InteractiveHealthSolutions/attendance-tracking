package com.ihs.ats.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ihs.ats.Data.DataDisplayController;
import com.ihs.ats.Data.DataViewForm;
import com.ihs.ats.constants.SystemPermissions;
import com.ihs.ats.constants.WebGlobals;
import com.ihs.ats.context.Context;
import com.ihs.ats.context.ServiceContext;
//import org.ird.unfepi.model.VaccinationCenter;
//import org.ird.unfepi.model.Vaccinator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewWorkGroupDetailsController extends DataDisplayController{

	ViewWorkGroupDetailsController() {
		super("popupForm", new  DataViewForm("WorkGroup_details", "Work Group Details", SystemPermissions.VIEW_VACCINATORS_DATA, false));
	}
	@RequestMapping(value="/workGroupDetails", method=RequestMethod.GET)
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse resp) throws Exception {
		
		ServiceContext sc = Context.getServices();
		String workGroupTypeId = request.getParameter("workGroupTypeId");
		System.out.println(workGroupTypeId);
		Map<String, Object> model = new HashMap<String, Object>();
		try{
			addModelAttribute(model, "workDetailsList", sc.getWorkGroupTypeService().getAllWorkGroupByTypeId(Integer.parseInt(workGroupTypeId)));
			return showForm(model);
		}catch (Exception e) {
			e.printStackTrace();
			request.getSession().setAttribute("exceptionTrace",e);
			return new ModelAndView("exception");		
		}
		finally{
			sc.closeSession();
		}
	}
}
