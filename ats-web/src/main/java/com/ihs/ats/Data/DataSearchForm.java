package com.ihs.ats.Data;

import com.ihs.ats.Data.GlobalParams.ServiceType;
import com.ihs.ats.constants.SystemPermissions;

public class DataSearchForm extends DataForm{
	private static final ServiceType serviceType = ServiceType.DATA_SEARCH;

	public DataSearchForm () {
		super(serviceType);
	}
	public DataSearchForm(String formName, String formTitle, SystemPermissions permission, boolean isInsertable){
		super(formName, formTitle, permission, serviceType, isInsertable);
	}
}
