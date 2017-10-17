package com.tsi2.streamrain.bussines.user.interfaces;

import com.tsi2.streamrain.model.generator.Users;

public interface IDAOUserBussines {
	
	boolean saveUser(final Users u, final String tenantID);

	boolean findUserXNickname(String nickname, String tenantID);

	boolean findUser(String nickname, String password, String tenantID);

}
