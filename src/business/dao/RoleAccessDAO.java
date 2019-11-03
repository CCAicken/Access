package business.dao;

import java.util.List;

import model.VRoleButton;
import model.VRoleClumn;

public interface RoleAccessDAO {
	/**
	 * 根据角色id和页面对应功能id获取按钮组
	 * 
	 * @param Roleid
	 *            角色id
	 * @param Sysid
	 *            功能id
	 * @return
	 */
	public List<VRoleButton> getRoleButtonByRoleIdAndSysId(Integer Roleid,
			Integer Sysid);

	/**
	 * 根据角色id和页面对应功能id获取可操作按钮
	 * 
	 * @param Roleid
	 *            角色id
	 * @param Sysid
	 *            功能id
	 * @return
	 */
	public List<VRoleButton> getUseRoleButtonByRoleIdAndSysId(Integer Roleid,
			Integer Sysid);

	/**
	 * 根据关系id和按钮id获取可操作按钮
	 * 
	 * @param RoleButtonId
	 *            关系id
	 * @param btnid
	 *            按钮id
	 * @param type
	 *            true 可操作反之不可操作
	 * @return
	 */
	public boolean changeUseRoleButtonByRoleIdAndSysId(Integer RoleButtonId,
			Integer btnid, boolean type);

	/**
	 * 根据角色id和页面对应功能id获取列
	 * 
	 * @param Roleid
	 *            角色id
	 * @param Sysid
	 *            功能id
	 * @return
	 */
	public List<VRoleClumn> getRoleClumnByRoleIdAndSysId(Integer Roleid,
			Integer Sysid);

	/**
	 * 根据列与角色关系id和列id更新列操作状态
	 * 
	 * @param RoleClumnId
	 *            列与角色关系id
	 * @param clumnid
	 *            列id
	 * @param type
	 *            true 可操作反之不可操作
	 * @return true 成功 false失败
	 */
	public boolean changeRoleClumnByRoleIdAndSysId(Integer RoleClumnId,
			Integer clumnid, boolean type);

	/**
	 * 根据角色id和页面对应功能id获取可操作列
	 * 
	 * @param Roleid
	 *            角色id
	 * @param Sysid
	 *            功能id
	 * @return
	 */
	public List<VRoleClumn> getUseRoleClumnByRoleIdAndSysId(Integer Roleid,
			Integer Sysid);
}
