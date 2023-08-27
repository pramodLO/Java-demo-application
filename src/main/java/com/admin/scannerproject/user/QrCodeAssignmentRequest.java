package com.admin.scannerproject.user;

public class QrCodeAssignmentRequest {

    private long userId;
    private String qrCodeName;
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getQrCodeName() {
		return qrCodeName;
	}
	public void setQrCodeName(String qrCodeName) {
		this.qrCodeName = qrCodeName;
	}

    // Getters and setters
    
}