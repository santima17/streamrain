package com.tsi2.streamrain.bussines.tenant.implementations;

import com.tsi2.streamrain.bussines.tenant.interfaces.IDAOTenantBussines;
import com.tsi2.streamrain.context.StremRainDataContextLoader;
import com.tsi2.streamrain.dao.implementations.StreamRainMySQLMainDAO;
import com.tsi2.streamrain.dao.interfaces.IDAOService;
import com.tsi2.streamrain.model.main.Tenants;

public class DAOTenantBussinesImpl implements IDAOTenantBussines{

	public boolean saveTenant(Tenants tenant) {
		IDAOService daoService = (StreamRainMySQLMainDAO) StremRainDataContextLoader.contextLoader().getBean("daoMainService");
		daoService.save(tenant, null);
		return true; 
	}

}
