/**
 * Copyright &copy; 2015-2020 <a href="http://www.coffee.org/">coffee</a> All rights reserved.
 */
package com.coffee.modules.sys.dao;

import com.coffee.common.persistence.TreeDao;
import com.coffee.common.persistence.annotation.MyBatisDao;
import com.coffee.modules.sys.entity.Office;

/**
 * 机构DAO接口
 * @author coffee
 * @version 2014-05-16
 */
@MyBatisDao
public interface OfficeDao extends TreeDao<Office> {
	
	public Office getByCode(String code);
}
