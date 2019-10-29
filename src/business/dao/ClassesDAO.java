package business.dao;

import java.util.List;

import model.TClass;
import model.VClass;

public interface ClassesDAO {
	/**
	 * 添加班级
	 * 
	 * @param classes
	 *            班级对象
	 * @return 操作结果，true为成功，false为失败
	 */
	public boolean insert(TClass classes);

	/**
	 * 批量添加班级
	 * 
	 * @param classes
	 *            班级对象列表
	 * @return 操作结果，true为成功，false为失败
	 */
	public boolean insertList(List<Object> classeslist);

	/**
	 * 删除班级
	 * 
	 * @param classid
	 *            班级id
	 * @return 操作结果，true为成功，false为失败
	 */
	public boolean delete(int classid);

	/**
	 * 修改班级
	 * 
	 * @param classid
	 *            班级
	 * @return 操作结果，true为成功，false为失败
	 */
	public boolean update(TClass classes);

	/**
	 * 根据班级id获取班级对象
	 * 
	 * @param classid
	 *            班级id
	 * @return 班级对象
	 */
	public TClass selectByid(int classid);

	/**
	 * 获取所有班级对象列表
	 * 
	 * @return 班级对象列表
	 */
	public List<TClass> select();

	/**
	 * 获取所有班级对象列表
	 * 
	 * @param majorid
	 *            专业id
	 * @return 班级对象列表
	 */
	public List<TClass> selectByMajor(int majorid);

	/**
	 * 根据班级id获取班级视图对象
	 * 
	 * @param classid
	 *            班级id
	 * @return 班级对象
	 */
	public VClass selectByidVclass(int classid);

	/**
	 * 获取所有班级视图对象列表
	 * 
	 * @return 班级对象列表
	 */
	public List<VClass> selectVclass();

	/**
	 * 根据专业id获取所有班级视图对象列表
	 * 
	 * @param majorid
	 *            专业id
	 * @return 班级对象列表
	 */
	public List<VClass> selectByMajorVclass(int majorid);

	/**
	 * 根据专业id获取所有班级视图对象列表
	 * 
	 * @param collegeid
	 *            学院id
	 * @return 班级对象列表
	 */
	public List<VClass> selectByCollegeid(int collegeid);

	/**
	 * 根据学院id获取所有班级视图对象列表
	 * 
	 * @param majorid
	 *            专业id
	 * @return 班级对象列表
	 */
	public List<VClass> selectByCollegeVclass(int collegeid);

	/**
	 * 根据条件查询的总数量
	 * 
	 * @return
	 */
	public int getclassAmount(String wherecondition);

	/**
	 * 分页查询数据
	 * 
	 * @return
	 */
	public List<VClass> selectByPage(String wherecondition, int page,
			int pageSize);

	/**
	 * 根据班级名称获取班级id
	 * 
	 * @return
	 */
	public int getclassIdByname(String classname);
}
