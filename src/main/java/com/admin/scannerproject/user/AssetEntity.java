package com.admin.scannerproject.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
@Table(name = "addassets")

public class AssetEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		 private long id;
	
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long seatid;
	
	
		@Column(name="building_no")
		private Integer buildingno;
		
		@Column(name="floor")
		private Integer floor;
		
		@Column(name="cubical_no")
		private Integer cubicalno;
		
		
		
		private String Status;
		
		
		public String getStatus() {
			return Status;
		}


		public void setStatus(String status) {
			Status = status;
		}


		@OneToOne
	
		@JoinColumn(name="seatBooking")
		private UserEntity seatIdBook;

		
		public long getSeatid() {
			return seatid;
		}


		public void setSeatid(long seatid) {
			this.seatid = seatid;
		}


	

		public UserEntity getSeatIdBook() {
			return seatIdBook;
		}


		public void setSeatIdBook(UserEntity seatIdBook) {
			this.seatIdBook = seatIdBook;
		}


		@Column(name="isactive")
		private Byte isActive=1;


		public long getId() {
			return id;
		}


		public void setId(long id) {
			this.id = id;
		}


		public Integer getBuildingno() {
			return buildingno;
		}


		public void setBuildingno(Integer buildingno) {
			this.buildingno = buildingno;
		}


		public Integer getFloor() {
			return floor;
		}


		public void setFloor(Integer floor) {
			this.floor = floor;
		}


		public Integer getCubicalno() {
			return cubicalno;
		}


		public void setCubicalno(Integer cubicalno) {
			this.cubicalno = cubicalno;
		}


		public Byte getIsActive() {
			return isActive;
		}


		public void setIsActive(Byte isActive) {
			this.isActive = isActive;
		}


}
		