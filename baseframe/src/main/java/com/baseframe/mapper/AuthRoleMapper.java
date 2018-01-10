package com.baseframe.mapper;

import org.apache.ibatis.annotations.Param;

import com.baseframe.common.dao.MyMapper;
import com.baseframe.model.AuthRole;

public interface AuthRoleMapper extends MyMapper<AuthRole> {

	AuthRole queryRoleById(@Param("roleid")Integer roleid);
	
	AuthRole queryByRolename(@Param("rolename") String rolename);
}