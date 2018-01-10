package com.baseframe.mapper;

import java.util.List;

import com.baseframe.common.dao.MyMapper;
import com.baseframe.model.AuthRoleOperation;

public interface AuthRoleOperationMapper extends MyMapper<AuthRoleOperation> {

	void batchInsert(List<AuthRoleOperation> list);

	void delRoleOpers(List<AuthRoleOperation> list);
}