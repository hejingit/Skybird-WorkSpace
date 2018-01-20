/**
 * Copyright &copy; 2015-2020 <a href="http://www.coffee.org/">coffee</a> All rights reserved.
 */
package com.coffee.modules.tools.dao;

import com.coffee.common.persistence.CrudDao;
import com.coffee.common.persistence.annotation.MyBatisDao;
import com.coffee.modules.tools.entity.TestInterface;

/**
 * 接口DAO接口
 * @author lgf
 * @version 2016-01-07
 */
@MyBatisDao
public interface TestInterfaceDao extends CrudDao<TestInterface> {
	
}