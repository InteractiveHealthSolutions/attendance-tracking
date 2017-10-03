package com.ihs.ats.Data;

import com.ihs.ats.Data.GlobalParams.ServiceType;
import com.ihs.ats.constants.SystemPermissions;

public class DataViewForm extends DataForm{
	private static final ServiceType serviceType = ServiceType.DATA_VIEW;

	public DataViewForm () {
		super(serviceType);
	}
	public DataViewForm(String formName, String formTitle, SystemPermissions permission, boolean isInsertable){
		super(formName, formTitle, permission, serviceType, isInsertable);
	}
}
