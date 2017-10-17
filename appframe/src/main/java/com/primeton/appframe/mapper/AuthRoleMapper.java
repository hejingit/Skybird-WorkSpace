package com.primeton.appframe.mapper;

import org.apache.ibatis.annotations.Param;

import com.primeton.appframe.common.dao.MyMapper;
import com.primeton.appframe.model.AuthRole;

public interface AuthRoleMapper extends MyMapper<AuthRole> {

	AuthRole queryRoleById(@Param("roleid")Integer roleid);
	
	AuthRole queryByRolename(@Param("rolename") String rolename);
}