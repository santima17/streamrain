package com.tsi2.streamrain.services.tenants.interfaces;

import com.tsi2.streamrain.datatypes.tenant.TenantDto;

public interface ITenantService {

	public boolean saveTenant(final TenantDto tenant);
}
