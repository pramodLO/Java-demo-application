package com.admin.scannerproject.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bookseat")
public class BookSeatEntity {

	
	
	public long getSeatid() {
		return seatid;
	}


	public void setSeatid(long seatid) {
		this.seatid = seatid;
	}


	public Byte getIsBooked() {
		return isBooked;
	}


	public void setIsBooked(Byte isBooked) {
		this.isBooked = isBooked;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long seatid;
	

	@Column(name="seatBooked")
	private Byte isBooked=0;
 

	
	
}
