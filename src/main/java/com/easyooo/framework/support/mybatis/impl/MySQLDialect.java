package com.easyooo.framework.support.mybatis.impl;

import java.text.MessageFormat;

import com.easyooo.framework.support.mybatis.Dialect;
import com.easyooo.framework.support.mybatis.Order;

/**
 * MySQL方言
 * 
 * @author Killer
 */
public class MySQLDialect implements Dialect {

	final String PAGING_SQL_TPL = "SELECT * FROM ({0}) T LIMIT ?,?";

	final String COUNTING_SQL_TPL = "SELECT COUNT(1) FROM ({0}) T";

	@Override
	public String getPagingSQL(String sql) {
		return MessageFormat.format(PAGING_SQL_TPL, sql);
	}

	@Override
	public String getCountingSQL(String sql) {
		return MessageFormat.format(COUNTING_SQL_TPL, sql);
	}

	@Override
	public Order[] order() {
		return new Order[]{Order.OFFSET, Order.LIMIT};
	}
}
