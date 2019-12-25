package com.capgemini.sms.service;

import java.util.List;

import com.capgemini.sms.beans.DealerWareHouse;
import com.capgemini.sms.beans.LoginBean;
import com.capgemini.sms.beans.Orders;
import com.capgemini.sms.beans.Products;

public interface DealerService {
	public LoginBean dealerLogin(String userId, String password);
public boolean placeOrder(Orders orders);
	
	public boolean cancelOrder(int orderId);
	
	public boolean updateOrder(Orders orders);
	
	public Orders getOrder(int orderId);

	public List<Orders> ordersList();
	
	public List<Products> getAllProduct();

	public boolean addProductDealer(DealerWareHouse dealer); 
	
	public boolean updateProuctDealer(DealerWareHouse dealer);
	
	public List<DealerWareHouse> productList();
}
