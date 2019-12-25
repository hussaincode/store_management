package com.capgemini.sms.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@Entity
@JsonRootName(value="dealerwarehouse")
@Table(name="dealerwarehouse")
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class DealerWareHouse {
	
	@Id
	@Column
	@JsonProperty
	private int productId;
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Column
	@JsonProperty
	private String productName;
	
	@Column
	@JsonProperty
	private double productSelPrice;
	
	@Column
	@JsonProperty
	private String productStock;

	
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductSelPrice() {
		return productSelPrice;
	}

	public void setProductSelPrice(double productSelPrice) {
		this.productSelPrice = productSelPrice;
	}

	public String getProductStock() {
		return productStock;
	}

	public void setProductStock(String productStock) {
		this.productStock = productStock;
	}

	
}
