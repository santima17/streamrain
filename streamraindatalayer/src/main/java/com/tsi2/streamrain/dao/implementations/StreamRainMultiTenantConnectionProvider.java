package com.tsi2.streamrain.dao.implementations;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;

public class StreamRainMultiTenantConnectionProvider implements MultiTenantConnectionProvider {
	
	private static final long serialVersionUID = 1L;

	public boolean isUnwrappableAs(Class arg0) {
		return false;
	}

	public <T> T unwrap(Class<T> arg0) {
		return null;
	}

	public Connection getAnyConnection() throws SQLException {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUsername("root");
		dataSource.setPassword("apagon23");
		dataSource.setUrl("jdbc:mysql://localhost:3306/generator?zeroDateTimeBehavior=convertToNull");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setDefaultAutoCommit(true);
		final Connection connection = dataSource.getConnection();
		return connection;
	}

	public Connection getConnection(String tenantID) throws SQLException {

		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUsername("root");
		dataSource.setPassword("apagon23");
		dataSource.setUrl("jdbc:mysql://localhost:3306/generator?zeroDateTimeBehavior=convertToNull");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setDefaultAutoCommit(true);
		final Connection connection = dataSource.getConnection();
		return connection;
	}

	public void releaseAnyConnection(Connection arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public void releaseConnection(String arg0, Connection arg1) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public boolean supportsAggressiveRelease() {
		// TODO Auto-generated method stub
		return false;
	}

}
