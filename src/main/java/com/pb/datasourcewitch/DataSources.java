package com.pb.datasourcewitch;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DataSources extends AbstractRoutingDataSource {
	
	//����ThreadLocal����̰߳�ȫ����
	private static final ThreadLocal<String> dataSourceHandler = new ThreadLocal<String>();
	
	public static void setDataSource(String dataSource) {
		dataSourceHandler.set(dataSource);
	}
	
	public static String getDataSource() {
		return dataSourceHandler.get();
	}
	
	public static void clearDataSource() {
		System.out.println("����л����ݿ⡣����");
		dataSourceHandler.remove();
	}

	@Override
	protected Object determineCurrentLookupKey() {
		return getDataSource();
	}

}
