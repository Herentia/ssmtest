package com.pb.datasourcewitch;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DataSources extends AbstractRoutingDataSource {
	
	//利用ThreadLocal解决线程安全问题
	private static final ThreadLocal<String> dataSourceHandler = new ThreadLocal<String>();
	
	public static void setDataSource(String dataSource) {
		dataSourceHandler.set(dataSource);
	}
	
	public static String getDataSource() {
		return dataSourceHandler.get();
	}
	
	public static void clearDataSource() {
		dataSourceHandler.remove();
	}

	@Override
	protected Object determineCurrentLookupKey() {
		return getDataSource();
	}

}
