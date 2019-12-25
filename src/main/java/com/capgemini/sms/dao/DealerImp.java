package com.capgemini.sms.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.sms.beans.DealerWareHouse;
import com.capgemini.sms.beans.LoginBean;
import com.capgemini.sms.beans.Orders;
import com.capgemini.sms.beans.Products;
@Repository
public class DealerImp implements Dealer{

	@PersistenceUnit
	private EntityManagerFactory emf;
	
	@Override
	public LoginBean dealerLogin(String userId, String password) {
				EntityManager manager = emf.createEntityManager();
				String jpql = "from LoginBean where userId = :userId and password = :password";
				Query query = manager.createQuery(jpql);
				query.setParameter("userId", userId);
				query.setParameter("password", password);
				LoginBean loginBean = null;

				try {
					loginBean = (LoginBean) query.getSingleResult();
				} catch (Exception e) {
					e.printStackTrace();
				}

				return loginBean;

			} // End of dealerLogin

	@Override
	public boolean placeOrder(Orders orders) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		boolean isAdded = false;
		try {
			tx.begin();
			manager.persist(orders);
			tx.commit();
			isAdded = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		manager.close();

		return isAdded;
	
	}
	@Override
	public boolean cancelOrder(int orderId) {
		EntityManager entityManager = emf.createEntityManager();
		boolean isDeleted = false;

		try {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			Orders order=entityManager.find(Orders.class, orderId);
			entityManager.remove(order);
			tx.commit();
			isDeleted = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		entityManager.close();
		return isDeleted;
	}
	@Override
	public boolean updateOrder(Orders orders) {
		EntityManager entityManager = emf.createEntityManager();
		Orders order1=entityManager.find(Orders.class, orders.getDealerId());
		boolean isUpdate = false;
		if(order1!=null) {
		String productName= orders.getProductName();
		if(productName!=null) {
			order1.setProductName(productName);
		}
		int quantity=orders.getQuantity();
		if(quantity!=0) {
			order1.setQuantity(quantity);
		}
		Date date=orders.getDeliveryExpectedDate();
		if(date!=null) {
			order1.setDeliveryExpectedDate(date);
		}
		String location=orders.getDealerLocation();
		if(location!=null) {
			order1.setDealerLocation(location);
		}
		long contactNum=orders.getDealerContactNumber();
		if(contactNum>0) {
			order1.setDealerContactNumber(contactNum);
		}

		
			try {
				EntityTransaction transaction = entityManager.getTransaction();
				transaction.begin();
				entityManager.persist(order1);
				transaction.commit();
				isUpdate = true;

			} catch (Exception e) {
				e.printStackTrace();
			}
			entityManager.close();
	}
		return isUpdate;
	}
	@Override
	public List<Orders> ordersList() {
		EntityManager manager = emf.createEntityManager();
		String jpql = "from Orders";
		javax.persistence.Query query = manager.createQuery(jpql);
		List<Orders> orderList=null;
		try {
			orderList = query.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return orderList;
	}
	@Override
	public Orders getOrder(int orderId) {
		EntityManager manager = emf.createEntityManager();
		Orders order=manager.find(Orders.class, orderId);
		manager.close();
		return order;

	}
	@Override
	public boolean addProductDealer(DealerWareHouse dealer) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		boolean isAdded = false;
		try {
			tx.begin();
			manager.persist(dealer);
			tx.commit();
			isAdded = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		manager.close();

		return isAdded;
	
	}
	@Override
	public boolean updateProuctDealer(DealerWareHouse dealer) {
		EntityManager entityManager = emf.createEntityManager();
		DealerWareHouse wareHouse = entityManager.find(DealerWareHouse.class, dealer.getProductId());
		boolean isUpdate = false;
		if(wareHouse!=null) {
			String productStock=dealer.getProductStock();
			if(productStock!=null) {
				wareHouse.setProductStock(productStock);;
			}
				try {
					EntityTransaction transaction = entityManager.getTransaction();
					transaction.begin();
					entityManager.persist(wareHouse);
					transaction.commit();
					isUpdate = true;

				} catch (Exception e) {
					e.printStackTrace();
				}
				entityManager.close();
		}
			return isUpdate;
		
	}
	@Override
	public List<DealerWareHouse> productList() {
		EntityManager manager = emf.createEntityManager();
		String jpql = "from DealerWareHouse";
		javax.persistence.Query query = manager.createQuery(jpql);
		List<DealerWareHouse> dealerList=null;
		try {
			dealerList = query.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dealerList;
	}
	
	@Override
	public List<Products> getAllProduct() {
		EntityManager manager = emf.createEntityManager();
		String jpql = "from Products";
		Query query = manager.createQuery(jpql);
		
		List<Products> productList = null;
		try {
			productList = query.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return productList;
	}
	
	}


