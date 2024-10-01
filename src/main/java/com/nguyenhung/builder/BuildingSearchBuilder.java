package com.nguyenhung.builder;

import java.util.ArrayList;
import java.util.List;

public class BuildingSearchBuilder {
  private String name;
  private Long floorArea;
  private String ward;
  private String street;
  private String districtId;
  private Long numberOfBasement;
  private List<String> typecode=new ArrayList<>();
  private String managerName;
  private String managerPhoneNumber;
  private Long rentPriceFrom;
  private Long rentPriceTo;
  private Long areaFrom;
  private Long areaTo;
  private Long satffId;
  private String level;
  private String direction;
  
 private BuildingSearchBuilder(Builder builder) {
	 this.name=builder.name;
	 this.floorArea=builder.floorArea;
	 this.ward=builder.ward;
	 this.street=builder.street;
	 this.districtId=builder.districtId;
	 this.numberOfBasement=builder.numberOfBasement;
	 this.typecode=builder.typecode;
     this.managerName=builder.managerName;
     this.managerPhoneNumber=builder.managerPhoneNumber;
	 this.rentPriceFrom=builder.rentPriceFrom;
	 this.rentPriceTo=builder.rentPriceTo;
	 this.areaFrom=builder.areaFrom;
	 this.areaTo=builder.areaTo;
	 this.satffId=builder.satffId;
	 this.level=builder.level;
	 this.direction=builder.direction;
 }
  
public String getLevel() {
	return level;
}
public String getDirection() {
	return direction;
}
public String getName() {
	return name;
}
public Long getFloorArea() {
	return floorArea;
}
public String getWard() {
	return ward;
}
public String getStreet() {
	return street;
}
public String getDistrictId() {
	return districtId;
}
public Long getNumberOfBasement() {
	return numberOfBasement;
}
public List<String> getTypecode() {
	return typecode;
}
public String getManagerName() {
	return managerName;
}
public String getManagerPhoneNumber() {
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
public Long getSatffId() {
	return satffId;
}
  public static class Builder{
	  private String name;
	  private Long floorArea;
	  private String ward;
	  private String street;
	  private String districtId;
	  private Long numberOfBasement;
	  private List<String> typecode=new ArrayList<>();
	  private String managerName;
	  private String managerPhoneNumber;
	  private Long rentPriceFrom;
	  private Long rentPriceTo;
	  private Long areaFrom;
	  private Long areaTo;
	  private Long satffId;
	  private String level;
	  private String direction;
	 
	  
	public Builder setLevel(String level) {
		this.level = level;
		return this;
		}
	 
		public Builder setDirection(String direction) {
			this.direction=direction;
			return this;
		}
	public Builder setName(String name) {
		this.name = name;
		return this;
	}
	public Builder setFloorArea(Long floorArea) {
		this.floorArea = floorArea;
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
	public Builder setDistrictId(String districtId) {
		this.districtId = districtId;
		return this;
	}
	public Builder setNumberOfBasement(Long numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
		return this;
	}
	public Builder setTypecode(List<String> typecode) {
		this.typecode = typecode;
		return this;
	}
	public Builder setManagerName(String managerName) {
		this.managerName = managerName;
		return this;
	}
	public Builder setManagerPhoneNumber(String managerPhoneNumber) {
		this.managerPhoneNumber = managerPhoneNumber;
		return this;
	}
	public Builder setRentPriceFrom(Long rentPriceFrom) {
		this.rentPriceFrom = rentPriceFrom;
		return this;
	}
	public Builder setRentPriceTo(Long rentPriceTo) {
		this.rentPriceTo = rentPriceTo;
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
	public Builder setSatffId(Long satffId) {
		this.satffId = satffId;
		return this;
	}
	
	  public BuildingSearchBuilder buil() {
		  return new BuildingSearchBuilder(this);
	  }
  }
}
