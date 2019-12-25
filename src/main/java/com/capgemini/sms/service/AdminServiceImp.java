package com.capgemini.sms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.sms.beans.LoginBean;
import com.capgemini.sms.beans.ManufacturerBean;
import com.capgemini.sms.beans.Products;
import com.capgemini.sms.dao.Admin;


@Service
public class AdminServiceImp implements AdminService {

	@Autowired
	private Admin adminDao;

	@Override
	public LoginBean adminLogin(String userId, String password) {
		return adminDao.adminLogin(userId, password);
	}
	
	@Override
	public boolean addManufacturer(ManufacturerBean manufacturer) {
		return adminDao.addManufacturer(manufacturer);
	}

	@Override
	public ManufacturerBean getManufacturer(int manufacturerId) {
		return adminDao.getManufacturer(manufacturerId);
	}

	@Override
	public boolean updateManufacturer(ManufacturerBean manufacturer) {
		return adminDao.updateManufacturer(manufacturer);
	}

	@Override
	public boolean deleteManufacturer(int manufacturerId) {
		return adminDao.deleteManufacturer(manufacturerId);
	}

	@Override
	public List<Products> viewAllProducts() {
		return adminDao.viewAllProducts();
		}

	@Override
	public List<ManufacturerBean> viewAllManufacturers() {
	return	adminDao.viewAllManufacturers();
	}

	
}
