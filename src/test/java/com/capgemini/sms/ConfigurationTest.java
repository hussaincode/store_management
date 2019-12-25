package com.capgemini.sms;

import org.springframework.context.annotation.Configuration;

import com.capgemini.sms.dao.Admin;
import com.capgemini.sms.dao.AdminImp;
import com.capgemini.sms.dao.Dealer;
import com.capgemini.sms.dao.DealerImp;
import com.capgemini.sms.dao.Manufacturer;
import com.capgemini.sms.dao.ManufacturerImp;

@Configuration
public class ConfigurationTest {

	public Manufacturer getManufacturer() {
		return new ManufacturerImp();
	}
	public Dealer getDealer() {
		return new DealerImp();
		
	}
	public Admin getAdmin() {
		return new AdminImp();
		
	}
}
