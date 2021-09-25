package com.BugTracker.dto;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class DownloadFileDto extends BaseDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String userId;
	
	private BigInteger fileId;
	
	private String fileName;
	
	private String encodedFile;
	
	private Timestamp createdTmpstmp;
	
	public String getFileName() {
		return fileName;
	}

	public String getEncodedFile() {
		return encodedFile;
	}

	public Timestamp getCreatedTmpstmp() {
		return createdTmpstmp;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setEncodedFile(String encodedFile) {
		this.encodedFile = encodedFile;
	}

	public void setCreatedTmpstmp(Timestamp createdTmpstmp) {
		this.createdTmpstmp = createdTmpstmp;
	}

	public String getUserId() {
		return userId;
	}

	public BigInteger getFileId() {
		return fileId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setFileId(BigInteger fileId) {
		this.fileId = fileId;
	}

}
