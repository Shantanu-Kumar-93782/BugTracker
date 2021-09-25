package com.BugTracker.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BugTrackerService {

	public Object getResource(Map<String, Object> requestData, HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
		return null;
	}
	
	public Object saveResource(Map<String, Object> requestData, HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
		return null;
	}
	
	public Object updateResource(Map<String, Object> requestData, HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
		return null;
	}
	
	public Object downloadResource(Map<String, Object> requestData, HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
		return null;
	}
}
