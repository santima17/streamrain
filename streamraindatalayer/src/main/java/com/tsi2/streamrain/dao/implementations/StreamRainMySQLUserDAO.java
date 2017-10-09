package com.tsi2.streamrain.dao.implementations;

import org.hibernate.Session;

import com.tsi2.streamrain.context.DBHibernateUtil;
import com.tsi2.streamrain.dao.interfaces.IDAOUserService;
import com.tsi2.streamrain.model.generator.Users;

public class StreamRainMySQLUserDAO extends StreamRainMySQLDAO implements IDAOUserService {

	public boolean findByNickname(String nickname, String tenantID) {
		Session dbSession = DBHibernateUtil.getSessionFactoryGenerator(tenantID);
		Users user = (Users) dbSession.createQuery("select u from Users u where u.nickname = :nickname")
        .setString("nickname", nickname)
        .uniqueResult();
		return user != null;
	}

}
