package com.tsi2.streamrain.services.category.implementations;

import com.tsi.streamrain.datatypes.category.CategoryDto;
import com.tsi2.streamrain.bussines.category.implementations.DAOCategoryBussinesImpl;
import com.tsi2.streamrain.bussines.category.interfaces.IDAOCategoryBussines;
import com.tsi2.streamrain.context.StremRainFacadesContextLoader;
import com.tsi2.streamrain.context.StremRainUserBussinesContextLoader;
import com.tsi2.streamrain.converters.category.CategoryConverter;
import com.tsi2.streamrain.converters.interfaces.IConverter;
import com.tsi2.streamrain.model.generator.Categories;
import com.tsi2.streamrain.services.category.interfaces.ICategoryService;

public class CategoryServiceImpl implements ICategoryService {

	public boolean saveCategory(final CategoryDto c, final String tenantID) {
		IDAOCategoryBussines daoService = (DAOCategoryBussinesImpl) StremRainUserBussinesContextLoader.contextLoader().getBean("categoryBussines");
		IConverter catConverter = (CategoryConverter)StremRainFacadesContextLoader.contextLoader().getBean("categoryConverter");
		daoService.saveCategory((Categories)catConverter.deConverter(c), tenantID);
		return true;
	}
	
}
