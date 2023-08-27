	package com.admin.scannerproject.service;
	
	public class AssetDto {
	    private Integer buildingno;
	    private Integer floor;
	    private Integer cubicalno;
		public AssetDto(Integer buildingno, Integer floor, Integer cubicalno) {
			super();
			this.buildingno = buildingno;
			this.floor = floor;
			this.cubicalno = cubicalno;
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
	
	    
	    
	    // Getters and setters
	}