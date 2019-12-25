package com.capgemini.sms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.sms.beans.DealerWareHouse;
import com.capgemini.sms.beans.LoginBean;
import com.capgemini.sms.beans.Orders;
import com.capgemini.sms.beans.Products;
import com.capgemini.sms.dao.Dealer;

@Service
public class DealerServiceImp implements DealerService{
		@Autowired
		private Dealer dealerDao;

		@Override
		public LoginBean dealerLogin(String userId, String password) {
			return dealerDao.dealerLogin(userId, password);
		}
		
		@Override
		public boolean placeOrder(Orders orders) {
			return dealerDao.placeOrder(orders);
		}

		@Override
		public boolean cancelOrder(int orderId) {
			return dealerDao.cancelOrder(orderId);
		}

		@Override
		public boolean updateOrder(Orders orders) {
			return dealerDao.updateOrder(orders);
		}

		@Override
		public List<Orders> ordersList() {
			return dealerDao.ordersList();
		}

		@Override
		public Orders getOrder(int orderId) {
			return dealerDao.getOrder(orderId);
		}

		@Override
		public boolean addProductDealer(DealerWareHouse dealer) {
			return dealerDao.addProductDealer(dealer);
		}

		@Override
		public boolean updateProuctDealer(DealerWareHouse dealer) {
			return dealerDao.updateProuctDealer(dealer);
		}

		@Override
		public List<DealerWareHouse> productList() {
			return dealerDao.productList();
		}
		
		@Override
		public List<Products> getAllProduct() {
			return dealerDao.getAllProduct();
		}

}
