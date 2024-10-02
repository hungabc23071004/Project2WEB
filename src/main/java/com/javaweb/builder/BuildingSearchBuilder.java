package com.javaweb.builder;

import java.util.ArrayList;
import java.util.List;
//tao object luu yeu cau cua frontend
public class BuildingSearchBuilder {

	private String name;
	private Long floorArea;
	private String ward;
	private String street;
	private String districtId;
	private Integer numberOfBasement;
	private List<String> typeCode = new ArrayList<>();
	private String managerName;
	private String managerPhoneNumber;
	private Long rentPriceFrom;
	private Long rentPriceTo;
	private Long areaFrom;
	private Long areaTo;
	private Long staffid;

	private BuildingSearchBuilder (Builder builder){ 
		this.name = builder.name; 
		this.floorArea = builder.floorArea;
		this.ward = builder.ward;
		this.street = builder.street;
		this.districtId = builder.districtId; 
		this.numberOfBasement = builder.numberOfBasement;
		this.typeCode = builder.typeCode;
		this.managerName = builder.managerName;
		this.managerPhoneNumber = builder.managerPhoneNumber;
		this.rentPriceFrom = builder.rentPriceFrom;
		this.rentPriceTo = builder.rentPriceTo;
		this.areaFrom = builder.areaFrom;
		this.areaTo = builder.areaTo;
		this.staffid = builder.staffid;
	}

	public String getName() {
		return name;
	}

	public Long getFloorarea() {
		return floorArea;
	}

	public String getWard() {
		return ward;
	}

	public String getStreet() {
		return street;
	}

	public String getDistrictid() {
		return districtId;
	}

	public Integer getNumberofbasement() {
		return numberOfBasement;
	}

	public List<String> getTypecode() {
		return typeCode;
	}

	public String getManagername() {
		return managerName;
	}

	public String getManagerphonenumber() {
		return managerPhoneNumber;
	}

	public Long getRentPriceFrom() {
		return rentPriceFrom;
	}

	public Long getRentPriceTo() {
		return rentPriceTo;
	}

	public Long getAreaFrom() {
		return areaFrom;
	}

	public Long getAreaTo() {
		return areaTo;
	}

	public Long getStaffid() {
		return staffid;
	}

	public static class Builder {
		private String name;
		private Long floorArea;
		private String ward;
		private String street;
		private String districtId;
		private Integer numberOfBasement;
		private List<String> typeCode = new ArrayList<>();
		private String managerName;
		private String managerPhoneNumber;
		private Long rentPriceFrom;
		private Long rentPriceTo;
		private Long areaFrom;
		private Long areaTo;
		private Long staffid;

		public Builder setName(String name) {
			this.name = name;
			return this;
		}

		public Builder setFloorarea(Long floorarea) {
			this.floorArea = floorarea;
			return this;
		}

		public Builder setWard(String ward) {
			this.ward = ward;
			return this;
		}

		public Builder setStreet(String street) {
			this.street = street;
			return this;
		}

		public Builder setDistrictid(String districtid) {
			this.districtId = districtid;
			return this;
		}

		public Builder setNumberofbasement(Integer numberofbasement) {
			this.numberOfBasement = numberofbasement;
			return this;
		}

		public Builder setTypecode(List<String> typecode) {
			this.typeCode = typecode;
			return this;
		}

		public Builder setManagername(String managername) {
			this.managerName = managername;
			return this;
		}

		public Builder setManagerphonenumber(String managerphonenumber) {
			this.managerPhoneNumber = managerphonenumber;
			return this;
		}

		public Builder setPriceFrom(Long priceFrom) {
			this.rentPriceFrom = priceFrom;
			return this;
		}

		public Builder setPriceTo(Long priceTo) {
			this.rentPriceTo = priceTo;
			return this;
		}

		public Builder setAreaFrom(Long areaFrom) {
			this.areaFrom = areaFrom;
			return this;
		}

		public Builder setAreaTo(Long areaTo) {
			this.areaTo = areaTo;
			return this;
		}

		public Builder setStaffid(Long staffid) {
			this.staffid = staffid;
			return this;
		}
		
		public BuildingSearchBuilder build() {
			return new BuildingSearchBuilder(this);
		}

	}
}
