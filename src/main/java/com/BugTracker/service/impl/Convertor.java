package com.BugTracker.service.impl;

import java.util.Map;

import com.BugTracker.dto.BaseDto;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Convertor {

	public static BaseDto convert(Map<String, Object> requestData) {
		ObjectMapper objectMapper = new ObjectMapper();
		BaseDto baseDto = objectMapper.convertValue(requestData, BaseDto.class);
		return baseDto;
	}
}
