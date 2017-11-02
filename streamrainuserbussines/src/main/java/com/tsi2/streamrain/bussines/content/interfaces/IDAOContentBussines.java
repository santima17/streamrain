package com.tsi2.streamrain.bussines.content.interfaces;

import com.tsi2.streamrain.model.generator.Contents;

public interface IDAOContentBussines {
	
	boolean saveContent(final Contents contents, final String tenantID);

}
