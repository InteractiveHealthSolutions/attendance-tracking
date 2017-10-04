package com.ihs.ats.data;

import com.ihs.ats.constants.SystemPermissions;
import com.ihs.ats.data.GlobalParams.ServiceType;

public class DataSearchForm extends DataForm{
	private static final ServiceType serviceType = ServiceType.DATA_SEARCH;

	public DataSearchForm () {
		super(serviceType);
	}
	public DataSearchForm(String formName, String formTitle, SystemPermissions permission, boolean isInsertable){
		super(formName, formTitle, permission, serviceType, isInsertable);
	}
}
