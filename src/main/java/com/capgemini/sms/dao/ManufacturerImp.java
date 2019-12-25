package com.capgemini.sms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.sms.beans.Dealer;
import com.capgemini.sms.beans.LoginBean;
import com.capgemini.sms.beans.Products;

@Repository
public class ManufacturerImp implements Manufacturer {

	@PersistenceUnit
	private EntityManagerFactory emf;

	@Override
	public LoginBean manufLogin(String userId, String password) {

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

	} // End of manufLogin

	@Override
	public boolean addDealer(Dealer dealer) {
		LoginBean bean = new LoginBean();
		bean.setUserId(dealer.getDealerId()+"");
		bean.setPassword(dealer.getDealerPassword());
		bean.setRole("dealer");
		EntityManager manager = emf.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		boolean isAdded = false;
		try {
			tx.begin();
			manager.persist(dealer);
			manager.persist(bean);
			tx.commit();
			isAdded = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		manager.close();

		return isAdded;

	}// addDealer

	@Override
	public Dealer getDealer(int dealerId) {
		EntityManager manager = emf.createEntityManager();
		Dealer dealer = manager.find(Dealer.class, dealerId);
		manager.close();
		return dealer;
	}

	@Override
	public boolean updateDealer(Dealer dealer) {
		EntityManager entityManager = emf.createEntityManager();
		Dealer dealerDetails = entityManager.find(Dealer.class, dealer.getDealerId());
		boolean isUpdate = false;
		if (dealerDetails != null) {
			Integer dealerId = dealer.getDealerId();
			if (dealerId > 0) {
				dealerDetails.setDealerId(dealerId);
			}
			String dealerName = dealer.getDealerName();
			if (dealerName != null) {
				dealerDetails.setDealerName(dealerName);
			}
			String location = dealer.getDealerLocation();
			if (location != null) {
				dealerDetails.setDealerLocation(location);
			}

			long dealerPhone = dealer.getDealerContactNo();
			if (dealerPhone != 0) {
				dealerDetails.setDealerContactNo(dealerPhone);
			}

			String password = dealer.getDealerPassword();
			if (password != null) {
				dealerDetails.setDealerPassword(password);
			}

			try {
				EntityTransaction transaction = entityManager.getTransaction();
				transaction.begin();
				entityManager.persist(dealerDetails);
				transaction.commit();
				isUpdate = true;

			} catch (Exception e) {
				e.printStackTrace();
			}
			entityManager.close();
		}
		return isUpdate;
	}// dealerUpdate

	// dealerDelete
	@Override
	public boolean deleteDealer(int dealerId) {
		EntityManager entityManager = emf.createEntityManager();
		boolean isDeleted = false;

		try {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			Dealer dealer = entityManager.find(Dealer.class, dealerId);
			entityManager.remove(dealer);
			tx.commit();
			isDeleted = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		entityManager.close();
		return isDeleted;

	}// dealerDelete

	@Override
	public List<Dealer> getAllDealer() {
		EntityManager manager = emf.createEntityManager();
		String jpql = "from Dealer";
		Query query = manager.createQuery(jpql);

		List<Dealer> dealerList = null;
		try {
			dealerList = query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dealerList;

	}

	@Override
	public boolean addProduct(Products products) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		boolean isAdded = false;
		try {
			tx.begin();
			manager.persist(products);
			tx.commit();
			isAdded = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		manager.close();

		return isAdded;
	}

	@Override
	public Products getProduct(int productId) {
		EntityManager manager = emf.createEntityManager();
		Products products = manager.find(Products.class, productId);
		manager.close();
		return products;
	}

	@Override
	public boolean updateProduct(Products products) {
		EntityManager entityManager = emf.createEntityManager();
		Products product = entityManager.find(Products.class, products.getProductId());
		boolean isUpdate = false;
		if (product != null) {
			Integer productId = products.getProductId();
			if (productId > 0) {
				product.setProductId(productId);
			}
			String productName = products.getProductName();
			if (productName != null) {
				product.setProductName(productName);
			}
			double productPrice = products.getProductPrice();
			if (productPrice > 0) {
				product.setProductPrice(productPrice);
			}
			String productStock = products.getProductStock();
			if (productStock != null) {
				product.setProductStock(productStock);
			}

			try {
				EntityTransaction transaction = entityManager.getTransaction();
				transaction.begin();
				entityManager.persist(product);
				transaction.commit();
				isUpdate = true;

			} catch (Exception e) {
				e.printStackTrace();
			}
			entityManager.close();
		}
		return isUpdate;
	}// updateProduct

	@Override
	public boolean deleteProduct(int productId) {
		EntityManager entityManager = emf.createEntityManager();
		boolean isDeleted = false;

		try {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			Products products= entityManager.find(Products.class, productId);
			entityManager.remove(products);
			tx.commit();
			isDeleted = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		entityManager.close();
		return isDeleted;
	}//deleteProduct

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
