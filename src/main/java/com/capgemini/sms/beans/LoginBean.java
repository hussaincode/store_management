package com.capgemini.sms.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;
//@JsonRootName("loginBean")
//@JsonInclude(JsonInclude.Include.NON_DEFAULT)
//@XmlRootElement(name="login")
//@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name="login")
public class LoginBean {

	@Id
	@Column
	private String userId;
	@Column
	private String password;
	@Column
	private String role;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
}
