package com.nguyenhung.Model;

public class BuildingRequestDTO {
  private String name, ward, street;
  private long districtId, rentprice;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getWard() {
	return ward;
}
public void setWard(String ward) {
	this.ward = ward;
}
public String getStreet() {
	return street;
}
public void setStreet(String street) {
	this.street = street;
}
public long getDistrictId() {
	return districtId;
}
public void setDistrictId(long districtId) {
	this.districtId = districtId;
}
public long getRentprice() {
	return rentprice;
}
public void setRentprice(long rentprice) {
	this.rentprice = rentprice;
}
}
