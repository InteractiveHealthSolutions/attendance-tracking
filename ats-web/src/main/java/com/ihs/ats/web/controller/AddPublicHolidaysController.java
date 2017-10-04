package com.ihs.ats.web.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.ihs.ats.constants.*;
import javax.servlet.http.HttpServletResponse;

import com.ihs.ats.constants.FormType;
import com.ihs.ats.constants.SystemPermissions;
import com.ihs.ats.context.Context;
import com.ihs.ats.context.ServiceContext;
import com.ihs.ats.data.DataEntryForm;
import com.ihs.ats.data.DataEntryFormController;
import com.ihs.ats.api.Leave;
import com.ihs.ats.api.PublicHoliday;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
//@SessionAttributes("command")
@RequestMapping("/addpublic_holidays")
public class AddPublicHolidaysController extends DataEntryFormController{

	private static final FormType formType = FormType.VACCINATOR_ADD;
	private Date dateFormStart = new Date();
	
	public AddPublicHolidaysController(){
			super(new DataEntryForm("public_holidays", "Public Holidays", SystemPermissions.ADD_VACCINATORS_DATA));
			System.out.println("fjeffmfmmmfmfmmmcmfmcm");

	}
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView addVaccinatorView(HttpServletRequest request, ModelAndView modelAndView){
			modelAndView.addObject("command", formBackingObject(request));
			return showForm(modelAndView, "dataForm");
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView onSubmit(@ModelAttribute("command")PublicHoliday pb,BindingResult results,
									HttpServletRequest request, HttpServletResponse response,ModelAndView modelAndView) throws Exception {
			ServiceContext sc = Context.getServices();	
			SimpleDateFormat parseFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = parseFormat.parse(request.getParameter("datePH"));
			pb.setDatePH(date);
//			WorkGroupValidator.validatePublicHolidays(DataEntrySource.WEB, pb,  null, results, sc, false);
			System.out.println(pb.getDatePH());
				
			sc = Context.getServices();
			
			sc.getPublicHolidaysService().save(pb);
			sc.commitTransaction();
			sc.closeSession();
			
			
		//	sc.getAttendanceService().saveLeave(lm);
			return new ModelAndView(new RedirectView("viewPublicHolidays.htm"));		
	}
	
	protected PublicHoliday formBackingObject(HttpServletRequest request) {
			dateFormStart = new Date();
			return new PublicHoliday();
	}
	

	
}
