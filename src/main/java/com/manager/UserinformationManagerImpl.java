package com.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserinformationManagerImpl implements UserInformationManager {
	@Autowired
	EndPointManager endPointManager;

	@Override
	public String getUserFirstLastName(String emailId) {
		return endPointManager.getUserFirstLastName(emailId);
		
	}

}
