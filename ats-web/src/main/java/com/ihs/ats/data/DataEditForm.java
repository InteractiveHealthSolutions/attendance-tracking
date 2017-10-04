package com.ihs.ats.data;

import com.ihs.ats.constants.SystemPermissions;
import com.ihs.ats.data.GlobalParams.ServiceType;

public class DataEditForm extends DataForm{
	private static final ServiceType serviceType = ServiceType.DATA_EDIT;

	public DataEditForm () {
		super(serviceType);
	}
	public DataEditForm(String formName, String formTitle, SystemPermissions permission){
		super(formName, formTitle, permission, serviceType, false);
	}
}
