package com.BugTracker.entity;

import java.math.BigInteger;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SYSTEM_FILES")
public class SystemFiles {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="FILE_ID")
	private BigInteger fileId;
	
	@Column(name="FILE_PATH")
	private String filePath;
	
	@Column(name="CREATED_BY")
	private BigInteger createdBy;
	
	@Column(name="CREATED_TIMESTAMP")
	private Timestamp createdTmstmp;
	
	@Column(name="APPLICATION")
	private String application;
	
	@Column(name="FILE_NAME")
	private String fileName;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public BigInteger getFileId() {
		return fileId;
	}

	public String getFilePath() {
		return filePath;
	}

	public BigInteger getCreatedBy() {
		return createdBy;
	}

	public Timestamp getCreatedTmstmp() {
		return createdTmstmp;
	}

	public String getApplication() {
		return application;
	}

	public void setFileId(BigInteger fileId) {
		this.fileId = fileId;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public void setCreatedBy(BigInteger createdBy) {
		this.createdBy = createdBy;
	}

	public void setCreatedTmstmp(Timestamp createdTmstmp) {
		this.createdTmstmp = createdTmstmp;
	}

	public void setApplication(String application) {
		this.application = application;
	}
}
