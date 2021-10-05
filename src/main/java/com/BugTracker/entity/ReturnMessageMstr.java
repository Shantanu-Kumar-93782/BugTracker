package com.BugTracker.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="RETURN_MESSAGE_MSTR")
public class ReturnMessageMstr {

	private String msgId;
	
	private String msgDesc;
	
	private Timestamp createdTimestamp;

	@Id
	@Column(name="MSG_ID")
	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	@Column(name="MSG_DESCRIPTION")
	public String getMsgDesc() {
		return msgDesc;
	}

	public void setMsgDesc(String msgDesc) {
		this.msgDesc = msgDesc;
	}

	@Column(name="CREATED_TIMESTAMP")
	public Timestamp getCreatedTimestamp() {
		return createdTimestamp;
	}

	public void setCreatedTimestamp(Timestamp createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}
	
	
}
