package com.ihs.ats.web.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import com.ihs.ats.Data.DataEntryForm;
import com.ihs.ats.Data.DataEntryFormController;
import com.ihs.ats.Data.GlobalParams;
import com.ihs.ats.constants.FormType;
import com.ihs.ats.constants.SystemPermissions;
import com.ihs.ats.context.Context;
//import org.ird.unfepi.context.LoggedInUser;
import com.ihs.ats.context.ServiceContext;
import com.ihs.ats.api.Attendance;
import com.ihs.ats.api.Leave;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@SessionAttributes("command")
@RequestMapping("/addleaves")
public class AddLeavesController extends DataEntryFormController{
	
	private static final FormType formType = FormType.VACCINATOR_ADD;
	private Date dateFormStart = new Date();
	
	public AddLeavesController(){
			super(new DataEntryForm("leaves", "Leaves (New)", SystemPermissions.ADD_VACCINATORS_DATA));

	}
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView addVaccinatorView(HttpServletRequest request, ModelAndView modelAndView){
			modelAndView.addObject("command", formBackingObject(request));
			return showForm(modelAndView, "dataForm");
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView onSubmit(@ModelAttribute("command")Leave lm,BindingResult results,
									HttpServletRequest request, HttpServletResponse response,ModelAndView modelAndView) throws Exception {
			System.out.println("HERE REACHED!!");
			ServiceContext sc = Context.getServices();	
			SimpleDateFormat parseFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = parseFormat.parse(request.getParameter("leaveDate"));
			Date EndDate = parseFormat.parse(request.getParameter("EndDate"));
			int UId = Integer.parseInt(request.getParameter("UserId"));
//			lm.setUId(UId);
//UNCOMMENT LATER			User usr = sc.getUserService().findUser(UId);
//			lm.setUserId(usr);
			lm.setLeaveDate(date);
//UNCOMMENT LATER			lm.setUserId(usr);
//UNCOMMENT LATER			LeaveValidator.validateLeavess(DataEntrySource.WEB, lm, null, results, sc, false);

			sc = Context.getServices();
			
//UNCOMMENT LATER			sc.getAttendanceService().saveLeave(lm);
			sc.commitTransaction();
			List<Date> dates = new ArrayList();
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			while (cal.getTime().before(EndDate)) {
			    cal.add(Calendar.DATE, 1);
			    dates.add(cal.getTime());
			}
			
			for(int i = 0; i < dates.size();i++){
				sc.closeSession();				
				Leave lm1 = new Leave();
				lm1.setLeaveType(lm.getLeaveType());
//UNCOMMENT LATER				lm1.setUserId(usr);
				String ddate = parseFormat.format(dates.get(i));
				
				lm1.setLeaveDate(parseFormat.parse(ddate));
				System.out.println(ddate);
				System.out.println(lm1.getLeaveDate());
				sc = Context.getServices();	
//UNCOMMENT LATER				sc.getAttendanceService().saveLeave(lm1);
				sc.commitTransaction();
			}
			
			
		//	sc.getAttendanceService().saveLeave(lm);
			return new ModelAndView(new RedirectView("viewLeaves.htm"));		
	}
	protected Leave formBackingObject(HttpServletRequest request) {
			dateFormStart = new Date();
			return new Leave();
	}
	
//	@ModelAttribute
//	protected void referenceData(HttpServletRequest request, Model model) throws Exception 
//	{
//			ServiceContext sc = Context.getServices();
//		try {
//			model.addAttribute("users", sc.getVaccinationService().getAllVaccinator(0, 20000, true, null));
//	
//		} catch (Exception e) {
//			e.printStackTrace();
//			GlobalParams.FILELOGGER.error(formType.name(), e);
//			request.setAttribute("errorMessage", "An error occurred while retrieving vaccinator reference datas. Error message is:"+e.getMessage());
//		
//		} finally {
//			sc.closeSession();
//		}
//	}
}
