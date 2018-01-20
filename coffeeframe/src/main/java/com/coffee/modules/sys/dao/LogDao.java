/**
 * Copyright &copy; 2015-2020 <a href="http://www.coffee.org/">coffee</a> All rights reserved.
 */
package com.coffee.modules.sys.dao;

import com.coffee.common.persistence.CrudDao;
import com.coffee.common.persistence.annotation.MyBatisDao;
import com.coffee.modules.sys.entity.Log;

/**
 * 日志DAO接口
 * @author coffee
 * @version 2014-05-16
 */
@MyBatisDao
public interface LogDao extends CrudDao<Log> {

	public void empty();
}
