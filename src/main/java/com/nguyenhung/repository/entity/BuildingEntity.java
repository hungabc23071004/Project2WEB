package com.nguyenhung.repository.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="building")
public class BuildingEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="numberofbasement")
	private Integer numberOfBasement;
	
	@Column(name="name")
	private String name;
	
	@Column(name="ward")
	private String ward;
	
	@Column(name="street")
	private String street;
	
	@Column(name="managername")
	private String managerName;
	
	@Column(name="managerphonenumber")
	private String managerPhoneNumber;
	
	@Column(name="floorarea")
	private Long floorArea;
	
	
	
	@Column(name="rentprice")
	private Long rentPrice;
	
	@Column(name="servicefee")
	private Long serviceFee;
	
	@Column(name="brokeragefee")
	private Long brokerageFee;
	
//	@Column(name="rentarea")
//	private String rentArea;
	
	@ManyToOne
	@JoinColumn(name="districtid")
	private DistrictEntity district;
	
	@OneToMany(mappedBy="building", fetch=FetchType.LAZY)
	private List<RentAreaEntity> items=new ArrayList<>();
	
	
	public List<RentAreaEntity> getItems() {
		return items;
	}

	public void setItems(List<RentAreaEntity> items) {
		this.items = items;
	}

	public DistrictEntity getDistrict() {
		return district;
	}

	public void setDistrict(DistrictEntity district) {
		this.district = district;
	}

//	public String getLevel() {
//		return level;
//	}
//
//	public void setLevel(String level) {
//		this.level = level;
//	}

//	@Column(name="level")
//	private String level;
//	


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumberOfBasement() {
		return numberOfBasement;
	}

	public void setNumberOfBasement(Integer numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
	}

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


	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerPhoneNumber() {
		return managerPhoneNumber;
	}

	public void setManagerPhoneNumber(String managerPhoneNumber) {
		this.managerPhoneNumber = managerPhoneNumber;
	}

	public Long getFloorArea() {
		return floorArea;
	}

	public void setFloorArea(Long floorArea) {
		this.floorArea = floorArea;
	}

	

	public Long getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(Long rentPrice) {
		this.rentPrice = rentPrice;
	}

	public Long getServiceFee() {
		return serviceFee;
	}

	public void setServiceFee(Long serviceFee) {
		this.serviceFee = serviceFee;
	}

	public Long getBrokerageFee() {
		return brokerageFee;
	}

	public void setBrokerageFee(Long brokerageFee) {
		this.brokerageFee = brokerageFee;
	}

//	public String getRentArea() {
//		return rentArea;
//	}
//
//	public void setRentArea(String rentArea) {
//		this.rentArea = rentArea;
//	}
	
	
	
	
}
