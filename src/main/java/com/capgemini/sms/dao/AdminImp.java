package com.capgemini.sms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.sms.beans.LoginBean;
import com.capgemini.sms.beans.ManufacturerBean;
import com.capgemini.sms.beans.Products;

@Repository
public class AdminImp implements Admin {

	@PersistenceUnit
	private EntityManagerFactory emf;
	
	
	@Override
	public LoginBean adminLogin(String userId, String password) {
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

		} // End of adminLogin


	@Override
	public boolean addManufacturer(ManufacturerBean manufacturer) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		boolean isAdded = false;
		try {
			tx.begin();
			manager.persist(manufacturer);
			tx.commit();
			isAdded = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		manager.close();

		return isAdded;
	}


	@Override
	public ManufacturerBean getManufacturer(int manufacturerId) {
		EntityManager manager = emf.createEntityManager();
		ManufacturerBean manufacturer = manager.find(ManufacturerBean.class, manufacturerId);
		manager.close();
		return manufacturer;
	}


	@Override
	public boolean updateManufacturer(ManufacturerBean manufacturer) {
		EntityManager entityManager = emf.createEntityManager();
		ManufacturerBean manufacturerUpdate=entityManager.find(ManufacturerBean.class, manufacturer.getManufacturerId());
		boolean isUpdate = false;
		if(manufacturerUpdate!=null) {
			
			String manufacturerName= manufacturer.getManufacturerName();
			if(manufacturerName!=null) {
				manufacturerUpdate.setManufacturerName(manufacturerName);
			}
			String manufacturerLocation=manufacturer.getManufacturerLocation();
			if(manufacturerLocation!=null) {
				manufacturerUpdate.setManufacturerLocation(manufacturerLocation);
			}
			
			String manufacturerPassword=manufacturer.getManufacturerPassword();
			if(manufacturerPassword!=null) {
				manufacturerUpdate.setManufacturerPassword(manufacturerPassword);
			}
			long contactNo=manufacturer.getManufacturerContactNo();
			if(contactNo>0) {
				manufacturerUpdate.setManufacturerContactNo(contactNo);
			}
			
				try {
					EntityTransaction transaction = entityManager.getTransaction();
					transaction.begin();
					entityManager.persist(manufacturerUpdate);
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
	public boolean deleteManufacturer(int manufacturerId) {
		EntityManager entityManager = emf.createEntityManager();
		boolean isDeleted = false;

		try {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			ManufacturerBean manufacturer=entityManager.find(ManufacturerBean.class, manufacturerId);
			entityManager.remove(manufacturer);
			tx.commit();
			isDeleted = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		entityManager.close();
		return isDeleted;
	}


	@Override
	public List<ManufacturerBean> viewAllManufacturers() {
		EntityManager manager = emf.createEntityManager();
		String jpql = "from ManufacturerBean";
		javax.persistence.Query query = manager.createQuery(jpql);
		List<ManufacturerBean> manList=null;
		try {
			manList = query.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return manList;
	}


	@Override
	public List<Products> viewAllProducts() {
		EntityManager manager = emf.createEntityManager();
		String jpql = "from Products";
		javax.persistence.Query query = manager.createQuery(jpql);
		List<Products> productList=null;
		try {
			productList = query.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return productList;
	}
	
	

}
