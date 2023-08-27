package com.admin.scannerproject.service;

import lombok.Data;

@Data
public class SeatBookingResponseDto {
	
	private Long seatId;
    private String message;
	public Long getSeatId() {
		return seatId;
	}
	public void setSeatId(Long seatId) {
		this.seatId = seatId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
    
    

}
