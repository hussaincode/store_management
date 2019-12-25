package com.capgemini.sms.dao;

import java.util.List;

import com.capgemini.sms.beans.Dealer;
import com.capgemini.sms.beans.Products;
import com.capgemini.sms.beans.LoginBean;

public interface Manufacturer {
	public LoginBean manufLogin(String userId, String password);
	public boolean addDealer(Dealer dealer);

	public Dealer getDealer(int dealerId);

	public boolean updateDealer(Dealer dealer);

	public boolean deleteDealer(int dealerId);
	
	public List<Dealer> getAllDealer();
	
	public boolean addProduct(Products products);

	public Products getProduct(int productId);
	
	public List<Products> getAllProduct();

	public boolean updateProduct(Products products);

	public boolean deleteProduct(int productId);

	
}
