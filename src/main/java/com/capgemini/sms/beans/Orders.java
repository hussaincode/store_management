package com.capgemini.sms.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@Entity
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonRootName(value="Orders")
@Table(name="orders")
public class Orders {
	
	@Id
	@JsonProperty
	@Column(name="order_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int orderId;
	
	@JsonProperty
	@Column(name="product_name")
	private String productName;
	
	@JsonProperty
	@Column
	private int quantity;
	
	@JsonProperty
	@Column(name="manufacture_id")
	private int manufactureId;
	
	
	@JsonProperty
	@Column(name="dealer_id")
	private int dealerId;
	
	@JsonProperty
	@Column(name="dealer_name")
	private String dealerName;
	
	@JsonProperty
	@Column(name="dealer_location")
	private String dealerLocation;
	
	@Override
	public String toString() {
		return "Orders [productName=" + productName + ", quantity=" + quantity + ", manufactureId=" + manufactureId
				+ ", dealerId=" + dealerId + ", dealerName=" + dealerName + ", dealerLocation=" + dealerLocation
				+ ", dealerContactNumber=" + dealerContactNumber + ", deliveryOrderDate=" + deliveryOrderDate
				+ ", deliveryExpectedDate=" + deliveryExpectedDate + "]";
	}

	@JsonProperty
	@Column(name="dealer_contactnum")
	private long dealerContactNumber;
	
	@JsonProperty
	@Column(name="order_date")
	private Date deliveryOrderDate;
	
	@JsonProperty
	@Column(name="expected_date")
	private Date deliveryExpectedDate;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getManufactureId() {
		return manufactureId;
	}

	public void setManufactureId(int manufactureId) {
		this.manufactureId = manufactureId;
	}

	public int getDealerId() {
		return dealerId;
	}

	public void setDealerId(int dealerId) {
		this.dealerId = dealerId;
	}

	public String getDealerName() {
		return dealerName;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}

	public String getDealerLocation() {
		return dealerLocation;
	}

	public void setDealerLocation(String dealerLocation) {
		this.dealerLocation = dealerLocation;
	}

	public long getDealerContactNumber() {
		return dealerContactNumber;
	}

	public void setDealerContactNumber(long dealerContactNumber) {
		this.dealerContactNumber = dealerContactNumber;
	}

	public Date getDeliveryOrderDate() {
		return deliveryOrderDate;
	}

	public void setDeliveryOrderDate(Date deliveryOrderDate) {
		this.deliveryOrderDate = deliveryOrderDate;
	}

	public Date getDeliveryExpectedDate() {
		return deliveryExpectedDate;
	}

	public void setDeliveryExpectedDate(Date deliveryExpectedDate) {
		this.deliveryExpectedDate = deliveryExpectedDate;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
}
