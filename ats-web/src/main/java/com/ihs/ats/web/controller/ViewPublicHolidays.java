package com.ihs.ats.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ihs.ats.constants.SystemPermissions;
import com.ihs.ats.constants.WebGlobals;
import com.ihs.ats.context.Context;
import com.ihs.ats.context.ServiceContext;
import com.ihs.ats.data.DataDisplayController;
import com.ihs.ats.data.DataSearchForm;
import com.ihs.ats.data.GlobalParams.SearchFilter;
import com.mysql.jdbc.StringUtils;
import com.ihs.ats.api.Leave;
import com.ihs.ats.api.PublicHoliday;
//import org.ird.unfepi.model.Vaccinator;
//import org.ird.unfepi.utils.UnfepiUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Controller
@RequestMapping(value="/viewPublicHolidays")
public class ViewPublicHolidays extends DataDisplayController {

	public ViewPublicHolidays() {
	
		super("dataForm", new  DataSearchForm("public_holidays", "Public Holidays", SystemPermissions.VIEW_VOLUNTEER_DATA, true));

	}
	
	@RequestMapping(method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		int totalRows=0;
    	Map<String, Object> model = new HashMap<String, Object>();
    	String workGroupId = getStringFilter(SearchFilter.PROGRAM_ID, req);
		String workGroupName = getStringFilter(SearchFilter.NAME_PART, req);
		req.setAttribute("editOrUpdateMessage", req.getParameter("editOrUpdateMessage"));
		ServiceContext sc = Context.getServices();
		String userID = getStringFilter(SearchFilter.ID, req);
		String partOfName = getStringFilter(SearchFilter.NAME_PART, req);
		
		try{
			List<PublicHoliday> list=new ArrayList();
		/*CHECK HERE!!	List<Vaccinator> vacList=new ArrayList();
			*/
			String action = req.getParameter("action");
			String pagerOffset = req.getParameter("pager.offset");
		
			
			if(userID != null){
				list = sc.getPublicHolidaysService().getAllPublicHolidays(true, 0, WebGlobals.DEFAULT_PAGING_MAX_PAGE_ITEMS, null);
		
			}
			else{
				list = sc.getPublicHolidaysService().getAllPublicHolidays(true, 0, WebGlobals.DEFAULT_PAGING_MAX_PAGE_ITEMS, null);
			}
				totalRows = list.size();
			addModelAttribute(model, "leaves", list);
			/*for(int i = 0 ; i < list.size() ; i++){
				System.out.println(list.get(i).getMappedId() + " "+sc.getVaccinationService().findVaccinatorById(list.get(i).getMappedId()).getFirstName());
				vacList.add(sc.getVaccinationService().findVaccinatorById(list.get(i).getMappedId()));
			}
			addModelAttribute(model, "vacs", vacList);*/

	
			
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
