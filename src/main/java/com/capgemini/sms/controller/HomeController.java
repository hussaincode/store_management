package com.capgemini.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.sms.beans.Dealer;
import com.capgemini.sms.beans.DealerWareHouse;
import com.capgemini.sms.beans.LoginBean;
import com.capgemini.sms.beans.ManufacturerBean;
import com.capgemini.sms.beans.Orders;
import com.capgemini.sms.beans.Products;
import com.capgemini.sms.service.AdminService;
import com.capgemini.sms.service.DealerService;
import com.capgemini.sms.service.ManufacturerService;

@CrossOrigin(allowedHeaders = "*", origins = "*", allowCredentials = "true")
@RestController
public class HomeController {

	@Autowired
	AdminService serviceAdmin;
	@Autowired
	ManufacturerService serviceManufacturer;
	@Autowired
	DealerService serviceDealer;

	@PostMapping(path = "/adminLogin", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public LoginBean loginAdmin(@RequestBody LoginBean login) {
		LoginBean userAdmin = serviceAdmin.adminLogin(login.getUserId(), login.getPassword());
		if (userAdmin != null) {
			return userAdmin;
		} else {
			return null;
		}
	} // loginAdmin()

	

	// getDealer
	@GetMapping(path = "/getDealer", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_ATOM_XML_VALUE })
	public ManagementResponse getDealer(int dealerId) {
		Dealer dealer = serviceManufacturer.getDealer(dealerId);
		ManagementResponse response = new ManagementResponse();
		if (dealer != null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Dealer details found");
			response.setDealer(dealer);

		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to found Employee details");
		}
		return response;
	}// getDealer

	// Add dealer
	@PostMapping(path = "/addDealer", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_ATOM_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_ATOM_XML_VALUE })
	public ManagementResponse addDealer(@RequestBody Dealer dealer) {
		boolean isAdded = serviceManufacturer.addDealer(dealer);
		ManagementResponse response = new ManagementResponse();

		if (isAdded) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("applicant added Successfully...");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to add Record...");
		}

		return response;
	}// addDealer()

	// updateDealer
	@PutMapping(path = "/updateDealer", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public boolean updateDealer(@RequestBody Dealer dealer) {
		return serviceManufacturer.updateDealer(dealer);
	}// updateDealer

	// deleteDealer
	@DeleteMapping(path = "/deleteDealer", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ManagementResponse deleteDealer(@RequestParam("dealerId") int dealerId) {
		boolean isDeleted = serviceManufacturer.deleteDealer(dealerId);
		ManagementResponse response = new ManagementResponse();

		if (isDeleted) {
			response.setStatusCode(201);
			response.setMessage("Sucess");
			response.setDescription("Dealer Deleted Sucessfully....");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to Delete Dealer Record!!");
		}
		return response;

	}
	// deleteDealer

	// getAllDealer
	@GetMapping(path = "/getAllDealers", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ManagementResponse getAllDealers() {
		List<Dealer> dealerList = serviceManufacturer.getAllDealer();
		ManagementResponse response = new ManagementResponse();
		if (dealerList != null && !dealerList.isEmpty()) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Dealer record found");
			response.setDealerList(dealerList);
		}

		else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to found Dealer details");
		}
		return response;
	} // getAllDealer

	// getProduct
	@GetMapping(path = "/getProduct", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_ATOM_XML_VALUE })
	public ManagementResponse getProduct(int productId) {
		Products product = serviceManufacturer.getProduct(productId);
		ManagementResponse response = new ManagementResponse();
		if (product != null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Product details found");
			response.setProduct(product);

		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to found Product details");
		}
		return response;
	}
	// getProduct

	// addProduct
	@PostMapping(path = "/addProduct", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_ATOM_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_ATOM_XML_VALUE })
	public ManagementResponse addProducts(@RequestBody Products products) {
		boolean isAdded = serviceManufacturer.addProduct(products);
		ManagementResponse response = new ManagementResponse();

		if (isAdded) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("products added Successfully...");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to add Record...");
		}

		return response;
	}// addProduct

	// updateProduct
	@PutMapping(path = "/updateProduct", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public boolean updateProducts(@RequestBody Products products) {
		return serviceManufacturer.updateProduct(products);
	}// updateProduct

	// deleteProduct
	@DeleteMapping(path = "/deleteProduct", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ManagementResponse deleteProducts(@RequestParam("productId") int productId) {
		boolean isDeleted = serviceManufacturer.deleteProduct(productId);
		ManagementResponse response = new ManagementResponse();

		if (isDeleted) {
			response.setStatusCode(201);
			response.setMessage("Sucess");
			response.setDescription("Product Deleted Sucessfully....");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to delete Product Record!!");
		}
		return response;
	}// deleteProduct

	//getAllProduct
	@GetMapping(path="/getAllProduct",
			produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ManagementResponse getAllProducts(){
		List<Products> productsList=serviceManufacturer.getAllProduct();
		ManagementResponse response= new ManagementResponse();
		if(productsList != null && !productsList.isEmpty()) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Dealer record found");
			response.setProductList(productsList);
		}
		else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to found Dealer details");
		}
		return response;
	}//getAllProduct
	
	//place order
	@PostMapping(path = "/placeOrder", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_ATOM_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_ATOM_XML_VALUE })
	public ManagementResponse placeOrder(@RequestBody Orders orders) {
		boolean isAdded = serviceDealer.placeOrder(orders);
		ManagementResponse response = new ManagementResponse();

		if (isAdded) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Order place Successfully...");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to place order...");
		}

		return response;
	}
	
	//cancel order
	
	@DeleteMapping(path = "/cancelOrder", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ManagementResponse cancelOrder(@RequestParam("order_id") int orderId) {
		boolean isDeleted = serviceDealer.cancelOrder(orderId);
		ManagementResponse response = new ManagementResponse();

		if (isDeleted) {
			response.setStatusCode(201);
			response.setMessage("Sucess");
			response.setDescription("Order Cancelled Sucessfully....");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to cancel order!!");
		}
		return response;
	}
	
	//update order
	@PutMapping(path = "/updateOrder", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public boolean updateOrder(@RequestBody Orders orders) {
		return serviceDealer.updateOrder(orders);
	}
	
	//view all orders
	@GetMapping(path = "/viewAllOrders", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ManagementResponse viewAllOrders() {
		List<Orders> orderList = serviceDealer.ordersList();
		ManagementResponse response = new ManagementResponse();
		if (orderList != null && !orderList.isEmpty()) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Dealer record found");
			response.setOrderList(orderList);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to found Dealer details");
		}
		return response;
	}

	//get order by id
	@GetMapping(path = "/getOrder", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_ATOM_XML_VALUE })
	public ManagementResponse getOrder(int orderId) {
		Orders order = serviceDealer.getOrder(orderId);
		ManagementResponse response = new ManagementResponse();
		if (order != null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Product details found");
			response.setOrder(order);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to found Product details");
		}
		return response;
	}	
	
	//add dealer product
	@PostMapping(path = "/addDealerProduct", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_ATOM_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_ATOM_XML_VALUE })
	public ManagementResponse addProductDealer(@RequestBody DealerWareHouse dealer) {
		boolean isAdded = serviceDealer.addProductDealer(dealer);
		ManagementResponse response = new ManagementResponse();

		if (isAdded) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("applicant added Successfully...");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to add Record...");
		}

		return response;
	}
	
	//update dealer product
	@PostMapping(path = "/updateDealerProduct", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public boolean updateDealerProduct(@RequestBody DealerWareHouse dealerWareHouse) {
		return serviceDealer.updateProuctDealer(dealerWareHouse);
	}

	@GetMapping(path = "/getAllDealerProducts", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ManagementResponse getAllDealerProducts() {
		List<DealerWareHouse> wareHouseList = serviceDealer.productList();
		ManagementResponse response = new ManagementResponse();
		if (wareHouseList != null && !wareHouseList.isEmpty()) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Dealer record found");
			response.setWareHouseList(wareHouseList);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to found Dealer details");
		}
		return response;
	}
	
//add manufacturer
	@PostMapping(path = "/addManufacturer", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_ATOM_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_ATOM_XML_VALUE })
	public ManagementResponse addManufacturer(@RequestBody ManufacturerBean manufacturer) {
		boolean isAdded = serviceAdmin.addManufacturer(manufacturer);
		ManagementResponse response = new ManagementResponse();

		if (isAdded) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Manufacturer added Successfully...");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to add Manufacturer...");
		}

		return response;
	}
	
	//getManufacturer
	@GetMapping(path = "/getManufacturer", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_ATOM_XML_VALUE })
	public ManagementResponse getManufacturer(int manufacturerId) {
		ManufacturerBean manufacturer = serviceAdmin.getManufacturer(manufacturerId);
		ManagementResponse response = new ManagementResponse();
		if (manufacturer != null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Manufacturer details found");
			response.setManufacturer(manufacturer);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to found Manufacturer details");
		}
		return response;
	}
	
	//updateManufacturer
	@PutMapping(path = "/updateManufacturer", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public boolean updateManufacturer(@RequestBody ManufacturerBean manufacturer) {
		return serviceAdmin.updateManufacturer(manufacturer);
	}
	
	//getAllProducts
	@GetMapping(path = "/getAllManufacturerProducts", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ManagementResponse getAllManufacturePrProducts() {
		List<Products> productList = serviceAdmin.viewAllProducts();
		ManagementResponse response = new ManagementResponse();
		if (productList != null && !productList.isEmpty()) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Product record found");
			response.setProductList(productList);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to found Product details");
		}
		return response;
	}
	
	//delete Manufacturer
	@DeleteMapping(path = "/removeManufacturer", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ManagementResponse removeManufacturer(@RequestParam("manufacturer_id") int manufacturerId) {
		boolean isDeleted = serviceAdmin.deleteManufacturer(manufacturerId);
		ManagementResponse response = new ManagementResponse();

		if (isDeleted) {
			response.setStatusCode(201);
			response.setMessage("Sucess");
			response.setDescription("Manufacturer deleted Sucessfully....");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to delete manufacturer !!");
		}
		return response;
	}
		//gte All Manufacturer
		@GetMapping(path = "/getAllManufacturer", produces = { MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_XML_VALUE })
		public ManagementResponse getAllManufacture() {
			List<ManufacturerBean> manList = serviceAdmin.viewAllManufacturers();
			ManagementResponse response = new ManagementResponse();
			if (manList != null && !manList.isEmpty()) {
				response.setStatusCode(201);
				response.setMessage("Success");
				response.setDescription("Product record found");
				response.setManufacturersList(manList);
			} else {
				response.setStatusCode(401);
				response.setMessage("Failed");
				response.setDescription("Unable to found Product details");
			}
			return response;
		}

	}

	
