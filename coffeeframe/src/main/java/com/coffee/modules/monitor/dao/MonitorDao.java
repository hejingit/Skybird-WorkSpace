/**
 * Copyright &copy; 2015-2020 <a href="http://www.coffee.org/">coffee</a> All rights reserved.
 */
package com.coffee.modules.monitor.dao;

import com.coffee.common.persistence.CrudDao;
import com.coffee.common.persistence.annotation.MyBatisDao;
import com.coffee.modules.monitor.entity.Monitor;

/**
 * 系统监控DAO接口
 * @author liugf
 * @version 2016-02-07
 */
@MyBatisDao
public interface MonitorDao extends CrudDao<Monitor> {
	
}