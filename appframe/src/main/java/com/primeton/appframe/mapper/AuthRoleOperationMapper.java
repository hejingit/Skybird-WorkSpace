package com.primeton.appframe.mapper;

import java.util.List;

import com.primeton.appframe.common.dao.MyMapper;
import com.primeton.appframe.model.AuthRoleOperation;

public interface AuthRoleOperationMapper extends MyMapper<AuthRoleOperation> {

	void batchInsert(List<AuthRoleOperation> list);

	void delRoleOpers(List<AuthRoleOperation> list);
}