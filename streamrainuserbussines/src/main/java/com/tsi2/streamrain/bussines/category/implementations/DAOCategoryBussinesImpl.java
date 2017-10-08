package com.tsi2.streamrain.bussines.category.implementations;

import com.tsi2.streamrain.bussines.category.interfaces.IDAOCategoryBussines;
import com.tsi2.streamrain.context.StremRainDataContextLoader;
import com.tsi2.streamrain.dao.implementations.StreamRainMySQLDAO;
import com.tsi2.streamrain.dao.interfaces.IDAOService;
import com.tsi2.streamrain.model.generator.Categories;

public class DAOCategoryBussinesImpl implements IDAOCategoryBussines {

	public boolean saveCategory(Categories c, String tenantID) {
		IDAOService daoService = (StreamRainMySQLDAO) StremRainDataContextLoader.contextLoader().getBean("daoUserService");
		daoService.save(c, tenantID);
		return true; 
	}

}
