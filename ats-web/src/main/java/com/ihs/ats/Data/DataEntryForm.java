package com.ihs.ats.Data;

import com.ihs.ats.Data.GlobalParams.ServiceType;
import com.ihs.ats.constants.SystemPermissions;

public class DataEntryForm extends DataForm{
	private static final ServiceType serviceType = ServiceType.DATA_ENTRY;

	public DataEntryForm () {
		super(serviceType);
	}
	public DataEntryForm(String formName, String formTitle, SystemPermissions permission){
		super(formName, formTitle, permission, serviceType, false);
	}
}
