package com.capgemini.sms;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.sms.beans.Dealer;
import com.capgemini.sms.beans.LoginBean;
import com.capgemini.sms.beans.Orders;
import com.capgemini.sms.beans.Products;
import com.capgemini.sms.dao.Admin;
import com.capgemini.sms.dao.Manufacturer;

import junit.framework.TestCase;

@SpringBootTest
public class StoremanagementsystemApplicationTests {
	@Autowired
	private Manufacturer manufacturer;

	@Autowired
	private com.capgemini.sms.dao.Dealer dealer;
	
	@Autowired
	private Admin admin;

	@Test
	public void addDealerTest() {
		Dealer dealer = new Dealer();
		dealer.setDealerId(2345);
		dealer.setDealerName("sadfgs");
		dealer.setDealerLocation("bhopla");
		dealer.setDealerContactNo(878465647l);
		dealer.setDealerPassword("fsd4hjg5");
		assertEquals(false, manufacturer.addDealer(dealer));
	}

	@Test
	public void getDealerTest() {
		Dealer dealer = manufacturer.getDealer(103);
		assertEquals(103, dealer.getDealerId());

	}

	@Test
	public void deleteDealerTest() {
		Dealer dealer = manufacturer.getDealer(104);
		assertEquals(false, manufacturer.deleteDealer(104));

	}

	@Test
	public void updateDealerTest() {
		Dealer dealer = new Dealer();
		dealer.setDealerId(103);
		dealer.setDealerName("vasundhara");
		dealer.setDealerContactNo(9398104918l);
		dealer.setDealerLocation("chittoor");
		dealer.setDealerPassword("vasu1234");
		assertEquals(true, manufacturer.updateDealer(dealer));
	}

	@Test
	public void getAllDealer() {
		List<Dealer> dealerList = null;
		try {
			dealerList = manufacturer.getAllDealer();
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertNotNull(dealerList);
	}

	// productTestCases

	@Test
	public void addProductTest() {
		Products product = new Products();
		product.setProductId(10);
		product.setProductName("Laptop");
		product.setProductPrice(10000.40);
		product.setProductStock("avaulable");
		product.setManufacturerId(12);
		product.setProductImg("https://cdn.pixabay.com/photo/2013/03/02/02/41/city-89197__480.jpg");

		assertEquals(false, manufacturer.addProduct(product));
	}

	@Test
	public void getProductTest() {
		Products product = manufacturer.getProduct(111);
		assertEquals(111, product.getProductId());

	}

	@Test
	public void deleteProduct() {
		Products product = manufacturer.getProduct(113);
		assertEquals(false, manufacturer.deleteProduct(113));

	}

	@Test
	public void updateProductTest() {
		Products product = new Products();
		product.setProductId(112);
		product.setManufacturerId(76);
		product.setProductName("Camera");
		product.setProductPrice(30000);
		product.setProductStock("unavailable");
		product.setProductImg("https://cdn.pixabay.com/photo/2016/01/27/04/32/books-1163695__480.jpg");
		assertEquals(true, manufacturer.updateProduct(product));
	}

	@Test
	public void getAllProductTest() {
		List<Products> productList = null;
		try {
			productList = manufacturer.getAllProduct();
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertNotNull(productList);
	}

	// DealerDAO test cases

	@Test
	public void placeOrderTest() {
		Orders order = new Orders();
		order.setDealerId(103);
		order.setDealerName("vasundhara");
		order.setDealerContactNumber(9398104918l);
		order.setDealerLocation("chittoor");
		order.setManufactureId(1);
		order.setProductName("laptops");
		order.setQuantity(15);
		assertEquals(false, dealer.placeOrder(order));
	}

	@Test
	public void getOrderTest() {
		Orders order = dealer.getOrder(1);
		assertEquals(1, order.getOrderId());

	}

	@Test
	public void ordersListTest() {
		List<Orders> orderList = null;
		try {
			orderList = dealer.ordersList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertNotNull(orderList);
	}

	@Test
	public void updateOrderTest() {
		Orders order = new Orders();
		order.setOrderId(1);
		order.setDealerId(103);
		order.setDealerName("vasundhara");
		order.setDealerLocation("madhanapalli");
		order.setDealerContactNumber(9398104918l);
		order.setManufactureId(76);
		order.setProductName("camera");
		order.setQuantity(25);
		assertEquals(false, dealer.updateOrder(order));
	}
	
	@Test
	public void productList() {
		List<Orders> orderList = null;
		try {
			orderList = dealer.ordersList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertNotNull(orderList);
	}
	
	/*
	 * @Test public void adminLoginTest() {
	 * TestCase.assertNull(admin.adminLogin(123, "saddam")); }
	 */
}
