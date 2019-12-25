package com.capgemini.sms.controller;

import java.util.List;

import com.capgemini.sms.beans.Dealer;
import com.capgemini.sms.beans.DealerWareHouse;
import com.capgemini.sms.beans.ManufacturerBean;
import com.capgemini.sms.beans.Orders;
import com.capgemini.sms.beans.Products;
import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class ManagementResponse {
	private int statusCode;
	private String message;
	private String description;
	private List<Dealer> dealerList;
	private List<Products> productList;
	private Products product;
	private Dealer dealer;
	private List<Orders> orderList;
	private List<ManufacturerBean> manufacturersList;
	private Orders order;
	private DealerWareHouse wareHouse;
	private List<DealerWareHouse> wareHouseList;
	private ManufacturerBean manufacturer;
	
	
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Dealer> getDealerList() {
		return dealerList;
	}
	public void setDealerList(List<Dealer> dealerList) {
		this.dealerList = dealerList;
	}
	public List<Products> getProductList() {
		return productList;
	}
	public void setProductList(List<Products> productList) {
		this.productList = productList;
	}
	public Products getProduct() {
		return product;
	}
	public void setProduct(Products product) {
		this.product = product;
	}
	public Dealer getDealer() {
		return dealer;
	}
	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}
	public List<Orders> getOrderList() {
		return orderList;
	}
	public void setOrderList(List<Orders> orderList) {
		this.orderList = orderList;
	}
	public List<ManufacturerBean> getManufacturersList() {
		return manufacturersList;
	}
	public void setManufacturersList(List<ManufacturerBean> manufacturersList) {
		this.manufacturersList = manufacturersList;
	}
	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}
	public DealerWareHouse getWareHouse() {
		return wareHouse;
	}
	public void setWareHouse(DealerWareHouse wareHouse) {
		this.wareHouse = wareHouse;
	}
	public List<DealerWareHouse> getWareHouseList() {
		return wareHouseList;
	}
	public void setWareHouseList(List<DealerWareHouse> wareHouseList) {
		this.wareHouseList = wareHouseList;
	}
	public ManufacturerBean getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(ManufacturerBean manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	

}
