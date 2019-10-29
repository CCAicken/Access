package business.dao;

import java.util.List;

import model.TCollege;

public interface CollegeDAO {
	/**
	 * 添加学院
	 * 
	 * @param college
	 *            学院对象
	 * @return 操作结果，true为成功，false为失败
	 */
	public boolean insert(TCollege college);

	/**
	 * 删除学院
	 * 
	 * @param collegeid
	 *            学院id
	 * @return 操作结果，true为成功，false为失败
	 */
	public boolean delete(int collegeid);

	/**
	 * 更新学院
	 * 
	 * @param college
	 *            学院
	 * @return 操作结果，true为成功，false为失败
	 */
	public boolean update(TCollege college);

	/**
	 * 根据学院id获取学院对象
	 * 
	 * @param collegeid
	 *            学院id
	 * @return 学院对象
	 */
	public TCollege selectByid(int collegeid);

	/**
	 * 获取所有学院对象列表
	 * 
	 * @return 学院对象列表
	 */
	public List<TCollege> select();

	/**
	 * 分页查询数据
	 * 
	 * @return
	 */
	public List<TCollege> selectByPage(String wherecondition, int page,
			int pageSize);

	/**
	 * 根据条件查询的总数量
	 * 
	 * @return
	 */
	public int getCollegeAmount(String wherecondition);

	/**
	 * 根据条件学院名称获取学院id
	 * 
	 * @return
	 */
	public int getCollegeid(String collegename);

	/**
	 * 批量添加
	 * 
	 * @param collegelist
	 *            学院列表
	 * @return
	 */
	public boolean addcollegeByList(List<Object> collegelist);
}
