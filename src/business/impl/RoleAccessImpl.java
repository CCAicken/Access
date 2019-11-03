package business.impl;

import java.util.List;

import model.VRoleButton;
import model.VRoleClumn;

import org.springframework.stereotype.Component;

import annotation.Log;
import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.RoleAccessDAO;

import common.properties.OperType;

@Component("roleaccessdao")
public class RoleAccessImpl implements RoleAccessDAO {
	private iHibBaseDAO bdao;

	public RoleAccessImpl() {
		this.bdao = new iHibBaseDAOImpl();
	}

	@Override
	public List<VRoleButton> getRoleButtonByRoleIdAndSysId(Integer Roleid,
			Integer Sysid) {
		String hql = "from VRoleButton where sysModelId=? and roleId=?";
		Object[] parm = { Sysid, Roleid };
		return bdao.select(hql, parm);
	}

	@Override
	public List<VRoleButton> getUseRoleButtonByRoleIdAndSysId(Integer Roleid,
			Integer Sysid) {
		String hql = "from VRoleButton where isedit=1 and sysModelId=? and roleId=?";
		Object[] parm = { Sysid, Roleid };
		return bdao.select(hql, parm);
	}

	@Override
	public List<VRoleClumn> getRoleClumnByRoleIdAndSysId(Integer Roleid,
			Integer Sysid) {
		String hql = "from VRoleClumn where sysModleId=? and roleId=?";
		Object[] parm = { Sysid, Roleid };
		return bdao.select(hql, parm);
	}

	@Override
	public List<VRoleClumn> getUseRoleClumnByRoleIdAndSysId(Integer Roleid,
			Integer Sysid) {
		String hql = "from VRoleClumn where isedit=1 and sysModleId=? and roleId=?";
		Object[] parm = { Sysid, Roleid };
		return bdao.select(hql, parm);
	}

	@Log(isSaveLog = true, operationType = OperType.MODIFY, operationName = "修改按钮是否可操作")
	@Override
	public boolean changeUseRoleButtonByRoleIdAndSysId(Integer RoleButtonId,
			Integer btnid, boolean type) {
		String hql;
		if (type) {
			hql = "update T_RoleButton set isedit=1 where id=? and btnId=?";
		} else {
			hql = "update T_RoleButton set isedit=0 where id=? and btnId=?";
		}

		Object[] parm = { RoleButtonId, btnid };
		return bdao.update(hql, parm);
	}

	@Log(isSaveLog = true, operationType = OperType.MODIFY, operationName = "修改列是否可见")
	@Override
	public boolean changeRoleClumnByRoleIdAndSysId(Integer RoleClumnId,
			Integer clumnid, boolean type) {
		String hql;
		if (type) {
			hql = "update T_RoleClumn set isedit=1 where id=? and clumnId=?";
		} else {
			hql = "update T_RoleClumn set isedit=0 where id=? and clumnId=?";
		}

		Object[] parm = { RoleClumnId, clumnid };
		return bdao.update(hql, parm);
	}

	// public static void main(String args[]) {
	//
	// RoleAccessImpl bdao = new RoleAccessImpl();
	// List<VRoleButton> list = bdao.getRoleButtonByRoleIdAndSysId(1, 16);
	// for (VRoleButton vRoleButton : list) {
	// System.out.println(vRoleButton.getId());
	// }
	// // System.out.println(bdao.changeRoleClumnByRoleIdAndSysId("4", "1"));
	//
	// }
}
