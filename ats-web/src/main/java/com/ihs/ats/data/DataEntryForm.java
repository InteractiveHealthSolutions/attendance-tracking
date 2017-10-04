package com.ihs.ats.data;

import com.ihs.ats.constants.SystemPermissions;
import com.ihs.ats.data.GlobalParams.ServiceType;

public class DataEntryForm extends DataForm{
	private static final ServiceType serviceType = ServiceType.DATA_ENTRY;

	public DataEntryForm () {
		super(serviceType);
	}
	public DataEntryForm(String formName, String formTitle, SystemPermissions permission){
		super(formName, formTitle, permission, serviceType, false);
	}
}
