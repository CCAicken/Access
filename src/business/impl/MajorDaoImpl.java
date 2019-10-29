package business.impl;

import java.util.List;

import model.TMajor;
import model.VMajor;

import org.springframework.stereotype.Component;

import annotation.Log;
import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.MajorDAO;

import common.properties.OperType;

@Component("majordao")
public class MajorDaoImpl implements MajorDAO {

	private iHibBaseDAO bdao;

	public MajorDaoImpl() {
		this.bdao = new iHibBaseDAOImpl();
	}

	@Log(isSaveLog = true, operationType = OperType.ADD, operationName = "添加一个专业")
	@Override
	public boolean insert(TMajor major) {
		int row = (Integer) bdao.insert(major);
		if (row > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Log(isSaveLog = true, operationType = OperType.DELETE, operationName = "删除一个专业")
	@Override
	public boolean delete(int majorid) {
		String procname = "up_deleteMajor(?)";
		Object[] para = { majorid };
		int row = (Integer) bdao.executeProduce(procname, para);
		if (row > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Log(isSaveLog = false)
	@Override
	public VMajor selectByid(int majorid) {
		return (VMajor) bdao.findById(VMajor.class, majorid);
	}

	@Log(isSaveLog = false)
	@Override
	public List<VMajor> select() {
		String hql = "from TMajor";
		List<VMajor> list = (List<VMajor>) bdao.select(hql);
		return list;
	}

	@Log(isSaveLog = false)
	@Override
	public List<VMajor> selectByColl(int collegeid) {
		String hql = "from VMajor where collegeid=?";
		Object[] para = { collegeid };
		List<VMajor> list = (List<VMajor>) bdao.select(hql, para);
		return list;
	}

	@Log(isSaveLog = false)
	@Override
	public int getPageCount() {
		String hql = "select count(*) from TMajor";
		int count = bdao.selectValue(hql);
		return count;
	}

	@Log(isSaveLog = true, operationType = OperType.ADD, operationName = "批量添加专业")
	@Override
	public boolean insertList(List<Object> majorlist) {
		return bdao.insertList(majorlist);
	}

	@Log(isSaveLog = false)
	@Override
	public int getMajorAmount(String wherecondition) {
		String hql = "select count(collegeid) from TMajor";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition;
		}
		return bdao.selectValue(hql);

	}

	@Log(isSaveLog = false)
	@Override
	public List<VMajor> selectByPage(String wherecondition, int page,
			int pageSize) {
		String hql = "from VMajor";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition;
		}
		hql += " order by majorid asc";
		List<VMajor> list = bdao.selectByPage(hql, page, pageSize);
		return list;
	}

	@Log(isSaveLog = true, operationType = OperType.MODIFY, operationName = "修改专业")
	@Override
	public boolean update(TMajor major) {
		TMajor majorsql = (TMajor) bdao.findById(TMajor.class,
				major.getMajorid());
		majorsql.setCollegeid(major.getCollegeid());
		majorsql.setMajorname(major.getMajorname());
		return bdao.update(majorsql);
	}

	@Override
	public int getMajorid(String majorname) {
		String hql = "select majorid from TMajor where majorname=?";
		Object[] para = { majorname };
		return bdao.selectValue(hql, para);
	}

}
