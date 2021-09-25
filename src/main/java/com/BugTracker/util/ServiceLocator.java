package com.BugTracker.util;

import java.util.Arrays;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.BugTracker.BugTrackerApplication;
import com.BugTracker.service.BugTrackerService;
import com.BugTracker.service.impl.LoginServiceImpl;

public class ServiceLocator extends BugTrackerService{
	
	
	public Object saveResource(Map<String, Object> requestData,
								HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.refresh();
		Object resultObject = context.getBean((String)requestData.get("serviceName"), BugTrackerService.class).saveResource(requestData, httpRequest, httpResponse);
		context.close();
		return resultObject;
	}
	
	
	public Object getResource(Map<String, Object> requestData,
			HttpServletRequest httpRequest, HttpServletResponse httpResponse) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BugTrackerApplication.class);
		System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
		String serviceName=(String) requestData.get("serviceName");
		requestData.remove("serviceName");
		Object resultObject = context.getBean(serviceName, BugTrackerService.class).getResource(requestData, httpRequest, httpResponse);
		context.close();
		return resultObject;
	}
	
	public Object downloadResource(Map<String, Object> requestData,
			HttpServletRequest httpRequest, HttpServletResponse httpResponse) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BugTrackerApplication.class);
		System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
		String serviceName=(String) requestData.get("serviceName");
		requestData.remove("serviceName");
		Object resultObject = context.getBean(serviceName, BugTrackerService.class).downloadResource(requestData, httpRequest, httpResponse);
		context.close();
		return resultObject;
	}

	
	public Object updateResource(Map<String, Object> requestData,
			HttpServletRequest httpRequest, HttpServletResponse httpResponse) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.refresh();
		Object resultObject = context.getBean((String)requestData.get("serviceName"), BugTrackerService.class).updateResource(requestData, httpRequest, httpResponse);
		context.close();
		return resultObject;
	}
}