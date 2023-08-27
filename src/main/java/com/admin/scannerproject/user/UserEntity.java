package com.admin.scannerproject.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "userdetails")
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;

		@Column(name="employee_name")
		private String employeename;
		
		@Column(name="email_id")
		private String emailid;
		
		@Column(name="employee_designation")
		private String employeedesignation;
		
		@Column(name="password")
		private Integer password;
		
//		@GeneratedValue(strategy = GenerationType.IDENTITY)
//		 @Column(name = "qr_code_Id")
//		 private String qrCodeId;
		
		@OneToOne(mappedBy = "seatIdBook")
		private AssetEntity seatBooking;

		@Column(name="isactive")
		private Byte isActive=1;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getEmployeename() {
			return employeename;
		}

		public void setEmployeename(String employeename) {
			this.employeename = employeename;
		}

		public String getEmailid() {
			return emailid;
		}

		public void setEmailid(String emailid) {
			this.emailid = emailid;
		}

		public String getEmployeedesignation() {
			return employeedesignation;
		}

		public void setEmployeedesignation(String employeedesignation) {
			this.employeedesignation = employeedesignation;
		}

		public Integer getPassword() {
			return password;
		}

		public void setPassword(Integer password) {
			this.password = password;
		}

	

		public AssetEntity getSeatBooking() {
			return seatBooking;
		}

		public void setSeatBooking(AssetEntity seatBooking) {
			this.seatBooking = seatBooking;
		}

		public Byte getIsActive() {
			return isActive;
		}

		public void setIsActive(Byte isActive) {
			this.isActive = isActive;
		}
		
}

	

			






