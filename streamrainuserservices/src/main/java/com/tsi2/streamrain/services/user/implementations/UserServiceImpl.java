package com.tsi2.streamrain.services.user.implementations;


import com.tsi2.streamrain.bussines.user.interfaces.IDAOUserBussines;
import com.tsi2.streamrain.bussines.user.implementations.DAOUserBussinesImpl;
import com.tsi2.streamrain.context.StremRainFacadesContextLoader;
import com.tsi2.streamrain.context.StremRainUserBussinesContextLoader;
import com.tsi2.streamrain.converters.interfaces.IConverter;
import com.tsi2.streamrain.converters.user.UserConverter;

import com.tsi2.streamrain.datatypes.user.UserDto;
import com.tsi2.streamrain.model.generator.Users;
import com.tsi2.streamrain.services.user.interfaces.IUserService;

public class UserServiceImpl implements IUserService{

	public boolean saveUser(final UserDto u, final String tenantID) {
		IDAOUserBussines daoService = (DAOUserBussinesImpl) StremRainUserBussinesContextLoader.contextLoader().getBean("userBussines");
		IConverter userConverter = (UserConverter)StremRainFacadesContextLoader.contextLoader().getBean("userConverter");
		daoService.saveUser((Users)userConverter.deConverter(u), tenantID);
		return true;
	}

	public boolean existsUserXNickName(String nickname, String tenantID) {
		IDAOUserBussines daoService = (DAOUserBussinesImpl) StremRainUserBussinesContextLoader.contextLoader().getBean("userBussines");
		return daoService.findUserXNickname(nickname, tenantID);
	}

	public boolean existsUser(String nickname, String password, String tenantID) {
		IDAOUserBussines daoService = (DAOUserBussinesImpl) StremRainUserBussinesContextLoader.contextLoader().getBean("userBussines");
		return daoService.findUser(nickname, password, tenantID);
	}

	public boolean existsUserXTwitterId(String twitterId, String tenantID) {
		IDAOUserBussines daoService = (DAOUserBussinesImpl) StremRainUserBussinesContextLoader.contextLoader().getBean("userBussines");
		return daoService.findUserXTwitterId(twitterId, tenantID);
	}

	
		
}
