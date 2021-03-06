package com.primeton.appframe.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primeton.appframe.common.annotation.ServiceLog;
import com.primeton.appframe.common.pojo.AjaxResult;
import com.primeton.appframe.common.utils.AppUtil;
import com.primeton.appframe.mapper.AuthRoleMapper;
import com.primeton.appframe.mapper.AuthRoleOperationMapper;
import com.primeton.appframe.model.AuthRole;
import com.primeton.appframe.model.AuthRoleOperation;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * 权限管理
 * ClassName: RoleService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2017年10月17日 下午1:39:20 <br/>
 *
 * @author Jin.He (mailto:hejin@primeton.com)
 * @version
 */
@Service
public class RoleService extends AbstratService<AuthRole> {

	@Autowired
	private AuthRoleMapper roleMapper;
	@Autowired
	private AuthRoleOperationMapper roleOperMapper;
	
	public AuthRole queryRoleById(int roleid){
		return roleMapper.queryRoleById(roleid);
	}

	@ServiceLog("新增角色")
	public AjaxResult saveRole(AuthRole role) {
		String result = null;
		AuthRole $role = roleMapper.queryByRolename(role.getRolename());
		if (null == $role) {
			save(role);
		} else {
			result = "角色名已存在";
		}
		return AppUtil.returnObj(result);
	}

	@ServiceLog("更新角色")
	public AjaxResult updateRole(AuthRole role) {
		String result = null;
		AuthRole $role = roleMapper.queryByRolename(role.getRolename());
		if (null != $role && $role.getRoleid() != role.getRoleid()) {
			result = "角色名已存在";
		} else {
			updateByID(role);
		}
		return AppUtil.returnObj(result);
	}

	public List<AuthRole> queryNotAdmin() {
		Example example = new Example(AuthRole.class);
		Criteria criteria = example.createCriteria();
		criteria.andNotEqualTo("rolename", "admin");
		return roleMapper.selectByExample(example);
	}

	@ServiceLog("绑定角色权限")
	public AjaxResult bindOpers(int roleid, int[] opids) {
		List<AuthRoleOperation> list = new ArrayList<AuthRoleOperation>();
		AuthRoleOperation roleOperation = null;
		for(int opid: opids){
			roleOperation = new AuthRoleOperation();
			roleOperation.setRoleid(roleid);
			roleOperation.setOpid(opid);
			list.add(roleOperation);
		}
		//通用mapper的批量插入竟然不行
//		roleOperMapper.insertList(list);
		roleOperMapper.batchInsert(list);
		return AppUtil.returnObj(null);
	}

	@ServiceLog("解除角色权限")
	public AjaxResult unbindOpers(int roleid, int[] opids){
		List<AuthRoleOperation> list = new ArrayList<AuthRoleOperation>();
		AuthRoleOperation roleOperation = null;
		for(int opid: opids){
			roleOperation = new AuthRoleOperation();
			roleOperation.setRoleid(roleid);
			roleOperation.setOpid(opid);
			list.add(roleOperation);
		}
		roleOperMapper.delRoleOpers(list);
		return AppUtil.returnObj(null);
	}

}
