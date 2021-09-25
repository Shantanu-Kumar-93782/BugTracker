package com.BugTracker.adapters;

import com.BugTracker.dto.LoginDto;
import com.BugTracker.entity.UserProfile;

public class LoginAdapter {

	public static LoginDto convertEntityToModel(LoginDto model, UserProfile entity) {
		
		model.setUserId(entity.getUserId());
		model.setFirstName(entity.getFirstName());
		model.setMidName(entity.getMidName());
		model.setLastName(entity.getLastName());
		model.setUserPassword(null);
		return model;
	}
}
