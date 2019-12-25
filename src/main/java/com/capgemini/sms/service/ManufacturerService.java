package com.capgemini.sms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import  com.capgemini.sms.beans.Dealer;
import com.capgemini.sms.beans.Products;
import com.capgemini.sms.beans.LoginBean;


public interface ManufacturerService {
	public LoginBean manufLogin(String userId, String password);
	
	public boolean addDealer(Dealer dealer);

	public Dealer getDealer(int dealerId);
	
	public List<Dealer> getAllDealer();

	public boolean updateDealer(Dealer dealer);

	public boolean deleteDealer(int dealerId);

	public boolean addProduct(Products products);

	public Products getProduct(int productId);
	
	public List<Products> getAllProduct();

	public boolean updateProduct(Products products);

	public boolean deleteProduct(int productId);


	
}
