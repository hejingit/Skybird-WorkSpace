package com.baseframe.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baseframe.common.dao.MyMapper;
import com.baseframe.model.AuthUser;

public interface AuthUserMapper extends MyMapper<AuthUser> {

	AuthUser queryByUsername(@Param("username") String username);

	List<AuthUser> queryList(@Param("user")AuthUser user);

	List<Integer> queryRoleUids(@Param("roleid")int roleid);
}