package com.capgemini.sms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.sms.beans.Dealer;
import com.capgemini.sms.beans.LoginBean;
import com.capgemini.sms.beans.Products;
import com.capgemini.sms.dao.Manufacturer;
@Service
public class ManufacturerServiceImp implements ManufacturerService {
	@Autowired
	private Manufacturer manufDao;

	@Override
	public LoginBean manufLogin(String userId, String password) {
		return manufDao.manufLogin(userId, password);
	}

	@Override
	public boolean addDealer(Dealer dealer) {
		return manufDao.addDealer(dealer);
	}

	@Override
	public Dealer getDealer(int dealerId) {
		return manufDao.getDealer(dealerId);
	}

	@Override
	public List<Dealer> getAllDealer() {
			return manufDao.getAllDealer();
	}

	
	@Override
	public boolean updateDealer(Dealer dealer) {
		return manufDao.updateDealer(dealer);
	}

	@Override
	public boolean deleteDealer(int dealerId) {
		return manufDao.deleteDealer(dealerId);
	}

	@Override
	public boolean addProduct(Products products) {
		return manufDao.addProduct(products);
	}

	@Override
	public Products getProduct(int productId) {
		return manufDao.getProduct(productId);
	}

	@Override
	public boolean updateProduct(Products products) {
		return manufDao.updateProduct(products);
	}

	@Override
	public boolean deleteProduct(int productId) {
		return manufDao.deleteProduct(productId);
	}

	@Override
	public List<Products> getAllProduct() {
		return manufDao.getAllProduct();
	}

	}
