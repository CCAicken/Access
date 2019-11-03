package business.dao;

import java.util.List;

import model.VRoleButton;
import model.VRoleClumn;

public interface RoleAccessDAO {
	/**
	 * ���ݽ�ɫid��ҳ���Ӧ����id��ȡ��ť��
	 * 
	 * @param Roleid
	 *            ��ɫid
	 * @param Sysid
	 *            ����id
	 * @return
	 */
	public List<VRoleButton> getRoleButtonByRoleIdAndSysId(Integer Roleid,
			Integer Sysid);

	/**
	 * ���ݽ�ɫid��ҳ���Ӧ����id��ȡ�ɲ�����ť
	 * 
	 * @param Roleid
	 *            ��ɫid
	 * @param Sysid
	 *            ����id
	 * @return
	 */
	public List<VRoleButton> getUseRoleButtonByRoleIdAndSysId(Integer Roleid,
			Integer Sysid);

	/**
	 * ���ݹ�ϵid�Ͱ�ťid��ȡ�ɲ�����ť
	 * 
	 * @param RoleButtonId
	 *            ��ϵid
	 * @param btnid
	 *            ��ťid
	 * @param type
	 *            true �ɲ�����֮���ɲ���
	 * @return
	 */
	public boolean changeUseRoleButtonByRoleIdAndSysId(Integer RoleButtonId,
			Integer btnid, boolean type);

	/**
	 * ���ݽ�ɫid��ҳ���Ӧ����id��ȡ��
	 * 
	 * @param Roleid
	 *            ��ɫid
	 * @param Sysid
	 *            ����id
	 * @return
	 */
	public List<VRoleClumn> getRoleClumnByRoleIdAndSysId(Integer Roleid,
			Integer Sysid);

	/**
	 * ���������ɫ��ϵid����id�����в���״̬
	 * 
	 * @param RoleClumnId
	 *            �����ɫ��ϵid
	 * @param clumnid
	 *            ��id
	 * @param type
	 *            true �ɲ�����֮���ɲ���
	 * @return true �ɹ� falseʧ��
	 */
	public boolean changeRoleClumnByRoleIdAndSysId(Integer RoleClumnId,
			Integer clumnid, boolean type);

	/**
	 * ���ݽ�ɫid��ҳ���Ӧ����id��ȡ�ɲ�����
	 * 
	 * @param Roleid
	 *            ��ɫid
	 * @param Sysid
	 *            ����id
	 * @return
	 */
	public List<VRoleClumn> getUseRoleClumnByRoleIdAndSysId(Integer Roleid,
			Integer Sysid);
}
