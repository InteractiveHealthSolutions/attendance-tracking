package com.ihs.ats.Data;

import com.ihs.ats.Data.GlobalParams.ServiceType;
import com.ihs.ats.constants.SystemPermissions;

public class DataViewCustomForm extends DataForm{
	private static final ServiceType serviceType = ServiceType.DATA_VIEW_CUSTOM;

	public DataViewCustomForm () {
		super(serviceType);
	}
	public DataViewCustomForm(String formName, String formTitle, SystemPermissions permission, boolean isInsertable){
		super(formName, formTitle, permission, serviceType, isInsertable);
	}
}
