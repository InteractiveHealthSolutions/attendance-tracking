package com.ihs.ats.Data;

import com.ihs.ats.Data.GlobalParams.ServiceType;
import com.ihs.ats.constants.SystemPermissions;

public class DataEditForm extends DataForm{
	private static final ServiceType serviceType = ServiceType.DATA_EDIT;

	public DataEditForm () {
		super(serviceType);
	}
	public DataEditForm(String formName, String formTitle, SystemPermissions permission){
		super(formName, formTitle, permission, serviceType, false);
	}
}
