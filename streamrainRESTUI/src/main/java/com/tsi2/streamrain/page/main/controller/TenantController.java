package com.tsi2.streamrain.page.main.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tsi2.streamrain.datatypes.tenant.TenantDto;
import com.tsi2.streamrain.services.tenants.interfaces.ITenantService;

@Controller
public class TenantController {
	
	@Resource(name="tenantService")
	ITenantService tenantService;
		
	private static final String USER_PREFIX = "/tenant/";
	
	@RequestMapping(value = "/registerTenant", method = RequestMethod.GET)
	public String showRegisterTenant () {	
		TenantDto tenant = new TenantDto();
		tenant.setId(3);
		tenant.setIp("localhost");
		tenant.setName("generator3");
		tenant.setPassword("apagon23");
		tenant.setPort(3306);
		tenant.setUser("root");
		tenantService.saveTenant(tenant);
		return USER_PREFIX + "registerTenant";
	}
	
	@RequestMapping(value = "/registerTenant", method = RequestMethod.POST)
	public String saveTenant () {
		TenantDto tenant = new TenantDto();
		tenant.setId(3);
		tenant.setIp("localhost");
		tenant.setName("generator3");
		tenant.setPassword("apagon23");
		tenant.setPort(3306);
		tenant.setUser("root");
		tenantService.saveTenant(tenant);
		return USER_PREFIX + "registerTenant";
	}

}
