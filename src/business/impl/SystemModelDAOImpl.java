package business.impl;

import java.util.List;

import model.TSystemModel;
import model.VRoleSystemModel;

import org.springframework.stereotype.Component;

import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.SystemModelDAO;

@Component("systemmodeldao")
public class SystemModelDAOImpl implements SystemModelDAO {
	private iHibBaseDAO hdao = null;

	public SystemModelDAOImpl() {
		this.hdao = new iHibBaseDAOImpl();
	}

	@Override
	public List<TSystemModel> getTSystemModelList() {
		String hql = "from TSystemModel order by parentid,displayorder asc";
		return hdao.select(hql);
	}

	@Override
	public List<VRoleSystemModel> getSystemModelByRole(int roleid) {
		String hql = "from VRoleSystemModel where roleid=? order by parentid,displayorder asc";
		Object[] param = { roleid };
		return hdao.select(hql, param);
	}

	@Override
	public boolean changeRoleModelState(int rolemodelid) {
		TSystemModel modelsql = (TSystemModel) hdao.findById(
				TSystemModel.class, rolemodelid);
		if (modelsql.getIsdelete()) {

			modelsql.setIsdelete(false);
		} else {
			modelsql.setIsdelete(true);
		}

		return hdao.update(modelsql);
	}

	@Override
	public List<TSystemModel> getMenuByParentId(int id) {
		String hql = "from TSystemModel where isdelete=0 and parentid = ? ";
		Object[] para = { id };
		return hdao.select(hql, para);
	}

	// public static void main(String[] args) {
	// SystemModelDAOImpl sdao = new SystemModelDAOImpl();
	// sdao.changeRoleModelState(1);
	// }

}
