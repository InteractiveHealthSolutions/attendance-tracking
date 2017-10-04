package com.ihs.ats.data;

import com.ihs.ats.constants.SystemPermissions;
import com.ihs.ats.data.GlobalParams.ServiceType;

public class DataViewForm extends DataForm{
	private static final ServiceType serviceType = ServiceType.DATA_VIEW;

	public DataViewForm () {
		super(serviceType);
	}
	public DataViewForm(String formName, String formTitle, SystemPermissions permission, boolean isInsertable){
		super(formName, formTitle, permission, serviceType, isInsertable);
	}
}
