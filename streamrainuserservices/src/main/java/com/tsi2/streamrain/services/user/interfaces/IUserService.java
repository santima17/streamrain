package com.tsi2.streamrain.services.user.interfaces;

import com.tsi2.streamrain.datatypes.user.UserDto;

public interface IUserService {
	
	public boolean saveUser(final UserDto u, final String tenantID);
	
	public boolean existsUserXNickName (final String nickname, final String tenantID);

}
