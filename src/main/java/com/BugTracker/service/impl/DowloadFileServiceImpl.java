package com.BugTracker.service.impl;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Map;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.BugTracker.adapters.DownloadFileAdapter;
import com.BugTracker.dao.SessionFactoryCreator;
import com.BugTracker.dto.BaseDto;
import com.BugTracker.dto.DownloadFileDto;
import com.BugTracker.entity.SystemFiles;
import com.BugTracker.service.BugTrackerService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component("downloadFileServiceImpl")
public class DowloadFileServiceImpl extends BugTrackerService{
	
	@Autowired
	private SessionFactoryCreator sessionFactoryCreator;
	
	@Override
	public Object downloadResource(Map<String, Object> requestData,
			HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
		
		if(requestData==null) {
			return new BaseDto();
		}else {
			ObjectMapper objectMapper = new ObjectMapper();
			DownloadFileDto downloadDto = objectMapper.convertValue(requestData, DownloadFileDto.class);
			
			Session currentSession = sessionFactoryCreator.getSession();
			Query query = currentSession.createQuery("from SystemFiles where file_id="+String.valueOf(downloadDto.getFileId()));
			SystemFiles entity = (SystemFiles) query.getSingleResult();
			if(entity==null) {
				return new BaseDto();
			}else {
				try {
					byte[] bytesOfFile = Files.readAllBytes(Paths.get(entity.getFilePath()));
					String encodedFile = Base64.getEncoder().encodeToString(bytesOfFile);
					return DownloadFileAdapter.convertEntityToModel(downloadDto, entity, encodedFile);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		return new BaseDto();
	}

	
}
