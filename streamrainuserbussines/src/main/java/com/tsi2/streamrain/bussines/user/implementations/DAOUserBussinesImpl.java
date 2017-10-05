package com.tsi2.streamrain.bussines.user.implementations;

import com.tsi2.streamrain.bussines.user.interfaces.IDAOUserBussines;
import com.tsi2.streamrain.context.StremRainDataContextLoader;
import com.tsi2.streamrain.dao.interfaces.IDAOService;
import com.tsi2.streamrain.dao.implementations.StreamRainMySQLDAO;
import com.tsi2.streamrain.model.generator.Users;

public class DAOUserBussinesImpl implements IDAOUserBussines{

	public boolean saveUser(Users u) {
		IDAOService daoService = (StreamRainMySQLDAO) StremRainDataContextLoader.contextLoader().getBean("daoUserService");
		daoService.save(u);
		return true; 
	}

	

}
