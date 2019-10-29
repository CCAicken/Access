package business.impl;

import java.util.List;

import model.TCollege;

import org.springframework.stereotype.Component;

import annotation.Log;
import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.CollegeDAO;

import common.properties.OperType;

@Component("collegedao")
public class CollegeDAOImpl implements CollegeDAO {
	private iHibBaseDAO bdao;

	public CollegeDAOImpl() {
		this.bdao = new iHibBaseDAOImpl();
	}

	@Log(isSaveLog = true, operationType = OperType.ADD, operationName = "添加学院")
	@Override
	public boolean insert(TCollege college) {
		int row = (Integer) bdao.insert(college);
		if (row > 0) {
			return true;
		}
		return false;
	}

	@Log(isSaveLog = true, operationType = OperType.DELETE, operationName = "删除一个学院")
	@Override
	public boolean delete(int collegeid) {
		String proname = "up_deleteCollege(?)";
		Object[] para = { collegeid };
		int row = (Integer) bdao.executeProduce(proname, para);
		if (row > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Log(isSaveLog = false)
	@Override
	public TCollege selectByid(int collegeid) {
		TCollege college = (TCollege) bdao.findById(TCollege.class, collegeid);
		return college;
	}

	@Log(isSaveLog = false)
	@Override
	public List<TCollege> select() {
		String hql = "from TCollege";
		List<TCollege> list = (List<TCollege>) bdao.select(hql);
		return list;
	}

	@Log(isSaveLog = false)
	@Override
	public List<TCollege> selectByPage(String wherecondition, int page,
			int pageSize) {
		String hql = "from TCollege";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition;
		}
		hql += " order by collegeid asc";
		List<TCollege> list = bdao.selectByPage(hql, page, pageSize);
		return list;
	}

	@Log(isSaveLog = false)
	@Override
	public int getCollegeAmount(String wherecondition) {
		String hql = "select count(collegeid) from TCollege";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition;
		}
		return bdao.selectValue(hql);

	}

	@Log(isSaveLog = true, operationType = OperType.ADD, operationName = "批量添加学院")
	@Override
	public boolean addcollegeByList(List<Object> collegelist) {

		return bdao.insertList(collegelist);
	}

	@Log(isSaveLog = true, operationType = OperType.MODIFY, operationName = "修改一个学院")
	@Override
	public boolean update(TCollege college) {
		TCollege collegesql = (TCollege) bdao.findById(TCollege.class,
				college.getCollegeid());
		collegesql.setCollegename(college.getCollegename());
		return bdao.update(collegesql);
	}

	@Log(isSaveLog = false)
	@Override
	public int getCollegeid(String collegename) {
		String hql = "select collegeid from TCollege where collegename=?";
		Object[] para = { collegename };
		return bdao.selectValue(hql, para);
	}
}
