package com.tsi2.streamrain.services.tenants.implementations;

import com.tsi2.streamrain.bussines.tenant.interfaces.IDAOTenantBussines;
import com.tsi2.streamrain.bussines.tenant.implementations.DAOTenantBussinesImpl;
import com.tsi2.streamrain.context.StremRainFacadesContextLoader;
import com.tsi2.streamrain.context.StremRainUserBussinesContextLoader;
import com.tsi2.streamrain.converters.interfaces.IConverter;
import com.tsi2.streamrain.converters.tenant.TenantConverter;
import com.tsi2.streamrain.datatypes.tenant.TenantDto;
import com.tsi2.streamrain.model.main.Tenants;
import com.tsi2.streamrain.services.tenants.interfaces.ITenantService;

public class TenantServiceImpl implements ITenantService{

	@Override
	public boolean saveTenant(final TenantDto tenant) {
		IDAOTenantBussines tenantBussines = (DAOTenantBussinesImpl) StremRainUserBussinesContextLoader.contextLoader().getBean("tenantBussines");
		IConverter tenantConverter = (TenantConverter)StremRainFacadesContextLoader.contextLoader().getBean("tenantConverter");
		tenantBussines.saveTenant((Tenants)tenantConverter.deConverter(tenant));
		return false;
	}

}
