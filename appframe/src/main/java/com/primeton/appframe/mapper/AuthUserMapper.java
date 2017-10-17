package com.primeton.appframe.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.primeton.appframe.common.dao.MyMapper;
import com.primeton.appframe.model.AuthUser;

public interface AuthUserMapper extends MyMapper<AuthUser> {

	AuthUser queryByUsername(@Param("username") String username);

	List<AuthUser> queryList(@Param("user")AuthUser user);

	List<Integer> queryRoleUids(@Param("roleid")int roleid);
}