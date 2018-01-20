/**
 * Copyright &copy; 2015-2020 <a href="http://www.coffee.org/">coffee</a> All rights reserved.
 */
package com.coffee.modules.sys.dao;

import com.coffee.common.persistence.CrudDao;
import com.coffee.common.persistence.annotation.MyBatisDao;
import com.coffee.modules.sys.entity.SystemConfig;

/**
 * 系统配置DAO接口
 * @author liugf
 * @version 2016-02-07
 */
@MyBatisDao
public interface SystemConfigDao extends CrudDao<SystemConfig> {
	
}