package com.tsi2.streamrain.dao.interfaces;

public interface IDAOUserService extends IDAOService {
	
	public boolean findByNickname(final String nickname, final String tenantID);

}
