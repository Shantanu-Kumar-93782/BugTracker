package com.BugTracker.dto;

public class BaseDto {

	private Message info = new Message();
	
	private Message error = new Message();

	public Message getInfo() {
		return info;
	}

	public void setInfo(String msgId, String msgDesc) {
		this.info.setMsgId(msgId);
		this.info.setMsgDesc(msgDesc);
	}

	public Message getError() {
		return error;
	}

	public void setError(String msgId, String msgDesc) {
		this.error.setMsgId(msgId);
		this.error.setMsgDesc(msgDesc);
	}
	
	
}
