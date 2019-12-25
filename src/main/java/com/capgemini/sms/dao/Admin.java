package com.capgemini.sms.dao;

import java.util.List;

import com.capgemini.sms.beans.LoginBean;
import com.capgemini.sms.beans.ManufacturerBean;
import com.capgemini.sms.beans.Products;

public interface Admin {

	public LoginBean adminLogin(String userId, String password);
	
	public boolean addManufacturer(ManufacturerBean manufacturer);

	public ManufacturerBean getManufacturer(int manufacturerId);

	public boolean updateManufacturer(ManufacturerBean manufacturer);

	public boolean deleteManufacturer(int manufacturerId);
	public List<ManufacturerBean> viewAllManufacturers();
	
	public List<Products> viewAllProducts();
	
}
