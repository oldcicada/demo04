package com.cicada.common;


import org.apache.commons.dbutils.QueryRunner;

import com.cicada.util.JdbcUtil;

public class BaseDao {
	private QueryRunner runner=new QueryRunner(JdbcUtil.getDataSource());

	public QueryRunner getRunner() {
		return runner;
	}

	public void setRunner(QueryRunner runner) {
		this.runner = runner;
	}
	
}
