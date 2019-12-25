package com.capgemini.sms.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
@JsonRootName(value = "manufacturer")
@Entity
@Table(name = "manufacturer")
public class ManufacturerBean {
		@JsonProperty
		@Column
		private String manufacturerName;

		@Id
		@JsonProperty
		@Column
		private int manufacturerId;

		@JsonProperty
		@Column
		private String manufacturerLocation;

		@JsonProperty
		@Column
		private String manufacturerPassword;
		
		@JsonProperty
		@Column
		private long manufacturerContactNo;


		public long getManufacturerContactNo() {
			return manufacturerContactNo;
		}

		public void setManufacturerContactNo(long manufacturerContactNo) {
			this.manufacturerContactNo = manufacturerContactNo;
		}

		public String getManufacturerName() {
			return manufacturerName;
		}

		public void setManufacturerName(String manufacturerName) {
			this.manufacturerName = manufacturerName;
		}

		public int getManufacturerId() {
			return manufacturerId;
		}

		public void setManufacturerId(int manufacturerId) {
			this.manufacturerId = manufacturerId;
		}

		public String getManufacturerLocation() {
			return manufacturerLocation;
		}

		public void setManufacturerLocation(String manufacturerLocation) {
			this.manufacturerLocation = manufacturerLocation;
		}

		public String getManufacturerPassword() {
			return manufacturerPassword;
		}

		public void setManufacturerPassword(String manufacturerPassword) {
			this.manufacturerPassword = manufacturerPassword;
		}

		@Override
		public String toString() {
			return "Manufacturer [manufacturerName=" + manufacturerName + ", manufacturerId=" + manufacturerId
					+ ", manufacturerLocation=" + manufacturerLocation + ", manufacturerPassword=" + manufacturerPassword
					+ ", manufacturerContactNo=" + manufacturerContactNo + "]";
		}
		

	}
