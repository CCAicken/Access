package business.impl;

import java.util.List;

import model.TClass;
import model.VClass;

import org.springframework.stereotype.Component;

import annotation.Log;
import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.ClassesDAO;

import common.properties.OperType;

@Component("classesdao")
public class ClassesDaoImpl implements ClassesDAO {

	private iHibBaseDAO bdao;

	public ClassesDaoImpl() {
		this.bdao = new iHibBaseDAOImpl();
	}

	@Log(isSaveLog = true, operationType = OperType.ADD, operationName = "添加班级")
	@Override
	public boolean insert(TClass classes) {
		int row = (Integer) bdao.insert(classes);
		if (row > 0) {
			return true;
		}
		return false;
	}

	@Log(isSaveLog = true, operationType = OperType.DELETE, operationName = "删除班级")
	@Override
	public boolean delete(int classid) {
		TClass cla = (TClass) bdao.findById(TClass.class, classid);
		return bdao.delete(cla);
	}

	@Log(isSaveLog = false)
	@Override
	public TClass selectByid(int classid) {
		TClass cla = (TClass) bdao.findById(TClass.class, classid);
		return cla;
	}

	@Log(isSaveLog = false)
	@Override
	public List<TClass> select() {
		String hql = "from TClass";
		List<TClass> list = (List<TClass>) bdao.select(hql);
		return list;
	}

	@Log(isSaveLog = false)
	@Override
	public List<TClass> selectByMajor(int majorid) {
		String hql = "from TClass where majorid=?";
		Object[] para = { majorid };
		List<TClass> list = (List<TClass>) bdao.select(hql, para);
		return list;
	}

	// public static void main(String[] args){
	// ClassesDAO dao = new ClassesDaoImpl();
	// List<VClass> list = dao.selectByCollegeVclass(5);
	// for(VClass cl:list){
	// System.out.println(cl.getClassname());
	// }
	// }
	@Log(isSaveLog = false)
	@Override
	public VClass selectByidVclass(int classid) {
		VClass cla = (VClass) bdao.findById(VClass.class, classid);
		return cla;
	}

	@Log(isSaveLog = false)
	@Override
	public List<VClass> selectVclass() {
		String hql = "from VClass";
		List<VClass> list = (List<VClass>) bdao.select(hql);
		return list;
	}

	@Log(isSaveLog = false)
	@Override
	public List<VClass> selectByMajorVclass(int majorid) {
		String hql = "from VClass where majorid=?";
		Object[] para = { majorid };
		List<VClass> list = (List<VClass>) bdao.select(hql, para);
		return list;
	}

	@Log(isSaveLog = false)
	@Override
	public List<VClass> selectByCollegeVclass(int collegeid) {
		String hql = "from VClass where collegeid=?";
		Object[] para = { collegeid };
		List<VClass> list = (List<VClass>) bdao.select(hql, para);
		return list;
	}

	@Log(isSaveLog = true, operationType = OperType.ADD, operationName = "批量添加班级")
	@Override
	public boolean insertList(List<Object> classeslist) {
		return bdao.insertList(classeslist);
	}

	@Log(isSaveLog = false)
	@Override
	public int getclassAmount(String wherecondition) {
		String hql = "select count(classid) from VClass";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition;
		}
		return bdao.selectValue(hql);

	}

	@Log(isSaveLog = false)
	@Override
	public List<VClass> selectByPage(String wherecondition, int page,
			int pageSize) {
		String hql = "from VClass";
		if (wherecondition != null && !wherecondition.equals("")) {
			hql += wherecondition;
		}
		hql += " order by collegeid asc";
		List<VClass> list = bdao.selectByPage(hql, page, pageSize);
		return list;
	}

	@Log(isSaveLog = true, operationType = OperType.MODIFY, operationName = "修改班级")
	@Override
	public boolean update(TClass classes) {
		TClass classessql = (TClass) bdao.findById(TClass.class,
				classes.getClassid());
		classessql.setMajorid(classes.getMajorid());
		classessql.setClassname(classes.getClassname());
		return bdao.update(classessql);
	}

	@Override
	public List<VClass> selectByCollegeid(int collegeid) {
		String hql = "from VClass where collegeid=?";
		Object[] para = { collegeid };
		List<VClass> list = bdao.select(hql, para);
		return list;
	}

	@Override
	public int getclassIdByname(String classname) {
		String hql = "select classid from TClass where classname=?";
		Object[] param = { classname };
		return bdao.selectValue(hql, param);
	}
}
