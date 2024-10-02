package com.javaweb.reponsitory.entity;

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
@Table(name = "building")
public class BuildingEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	// neu khong muon tang dan thi value k co tham so
	//generatedValue de chon cach sinh gia tri cho khoa chinh
	
	@Column(name="name")
	private String name;
	
	@Column(name="ward")
	private String ward;
	
	@Column(name="street")
	private String street;
	

	@Column(name="numberofbasement")
	private Long numberOfBasement;
	
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
	
//	@Column(name="brokeragefee")
//	private Long brokeragefee;
	
	@ManyToOne
	@JoinColumn(name = "districtid")
	private DistrictEntity district;
	
	
	@OneToMany(mappedBy = "buildings",fetch =FetchType.LAZY)
	private List<RentAreaEntity> items= new ArrayList<>();
	
	
	public DistrictEntity getDistrict() {
		return district;
	}
	public void setDistrict(DistrictEntity district) {
		this.district = district;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	
	public Long getNumberofbasement() {
		return numberOfBasement;
	}
	public void setNumberofbasement(Long numberofbasement) {
		this.numberOfBasement = numberofbasement;
	}
	public String getManagername() {
		return managerName;
	}
	public void setManagername(String managername) {
		this.managerName = managername;
	}
	public String getManagerphonenumber() {
		return managerPhoneNumber;
	}
	public void setManagerphonenumber(String managerphonenumber) {
		this.managerPhoneNumber = managerphonenumber;
	}
	public Long getFloorarea() {
		return floorArea;
	}
	public void setFloorarea(Long floorarea) {
		this.floorArea = floorarea;
	}
	public Long getRentprice() {
		return rentPrice;
	}
	public void setRentprice(Long rentprice) {
		this.rentPrice = rentprice;
	}
	public Long getServicefee() {
		return serviceFee;
	}
	public void setServicefee(Long servicefee) {
		this.serviceFee = servicefee;
	}
//	public Long getBrokeragefee() {
//		return brokeragefee;
//	}
//	public void setBrokeragefee(Long brokeragefee) {
//		this.brokeragefee = brokeragefee;
//	}
	
	public List<RentAreaEntity> getItems() {
		return items;
	}
	public void setItems(List<RentAreaEntity> items) {
		this.items = items;
	}
}
