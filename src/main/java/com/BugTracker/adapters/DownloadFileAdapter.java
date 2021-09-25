package com.BugTracker.adapters;

import com.BugTracker.dto.DownloadFileDto;
import com.BugTracker.entity.SystemFiles;

public class DownloadFileAdapter {

	public static DownloadFileDto convertEntityToModel(DownloadFileDto model, SystemFiles entity, String encodedFile) {
		
		model.setFileId(entity.getFileId());
		model.setEncodedFile(encodedFile);
		model.setFileName(entity.getFileName());
		model.setCreatedTmpstmp(entity.getCreatedTmstmp());
		return model;
	}
}
