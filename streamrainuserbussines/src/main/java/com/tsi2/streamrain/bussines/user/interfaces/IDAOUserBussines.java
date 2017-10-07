package com.tsi2.streamrain.bussines.user.interfaces;

import com.tsi2.streamrain.model.generator.Users;

public interface IDAOUserBussines {
	
	public boolean saveUser(final Users u, final String tenantID);

}
