package com.tsi2.streamrain.bussines.user.implementations;

import com.tsi2.streamrain.bussines.user.interfaces.IDAOUserBussines;
import com.tsi2.streamrain.context.StremRainDataContextLoader;
import com.tsi2.streamrain.dao.interfaces.IDAOUserService;
import com.tsi2.streamrain.dao.implementations.StreamRainMySQLUserDAO;
import com.tsi2.streamrain.model.generator.Users;

public class DAOUserBussinesImpl implements IDAOUserBussines{

	public boolean saveUser(final Users u, final String tenantID) {
		IDAOUserService daoService = (StreamRainMySQLUserDAO) StremRainDataContextLoader.contextLoader().getBean("daoUserService");
		daoService.save(u, tenantID);
		return true; 
	}

	public boolean findUserXNickname(String nickname, String tenantID) {
		IDAOUserService daoService = (StreamRainMySQLUserDAO) StremRainDataContextLoader.contextLoader().getBean("daoUserService");
		return daoService.findByNickname(nickname, tenantID); 
	}

	public boolean findUser(String nickname, String password, String tenantID) {
		IDAOUserService daoService = (StreamRainMySQLUserDAO) StremRainDataContextLoader.contextLoader().getBean("daoUserService");
		return daoService.findByNicknamePassword(nickname, password, tenantID); 
	}

	public boolean findUserXTwitterId(String twitterId, String tenantID) {
		IDAOUserService daoService = (StreamRainMySQLUserDAO) StremRainDataContextLoader.contextLoader().getBean("daoUserService");
		return daoService.findByTwitterId(twitterId, tenantID); 
	}

	

}
