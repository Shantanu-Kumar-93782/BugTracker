package com.BugTracker.controllers;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BugTracker.util.ServiceLocator;

@RestController
public class AppCtrl {

	
	@PostMapping("/getResource")
	public Object getResource(@RequestBody Map<String, Object> requestData,
								HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
		return (new ServiceLocator()).getResource(requestData, httpRequest, httpResponse);
	}
	
	@PostMapping("/saveResource")
	public Object saveResource(@RequestBody Map<String, Object> requestData,
								HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
		return (new ServiceLocator()).saveResource(requestData, httpRequest, httpResponse);
	}
	
	@PutMapping("/updateResource")
	public Object updateResource(@RequestBody Map<String, Object> requestData,
								HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
		return (new ServiceLocator()).updateResource(requestData, httpRequest, httpResponse);
	}
	
	@PostMapping("/downloadResource")
	public Object downloadResource(@RequestBody Map<String, Object> requestData,
									HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws IOException{
//		String fileUrl = (String) (new ServiceLocator()).downloadResource(requestData, null, null);
//		if(fileUrl.equals("") || fileUrl.equals("Invalid request data") || fileUrl.equals("No records Found")) {
//			return fileUrl.getBytes();
//		}else {
//			return Files.readAllBytes(Paths.get(fileUrl));
//		}
		return (new ServiceLocator()).downloadResource(requestData, httpRequest, httpResponse);
		
	}
	
	@RequestMapping("/")
	public Object indexPage() {
		return "BugTracker is up and running";
	}
	
	
}
