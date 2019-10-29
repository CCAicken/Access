package business.dao;

import java.util.List;

import model.TMajor;
import model.VMajor;

public interface MajorDAO {
	/**
	 * 添加专业
	 * 
	 * @param major
	 *            专业对象
	 * @return 操作结果，true为成功，false为失败
	 */
	public boolean insert(TMajor major);

	/**
	 * 批量添加专业
	 * 
	 * @param majorlist
	 *            专业对象列表
	 * @return 操作结果，true为成功，false为失败
	 */
	public boolean insertList(List<Object> majorlist);

	/**
	 * 删除专业
	 * 
	 * @param majorid
	 *            专业id
	 * @return 操作结果，true为成功，false为失败
	 */
	public boolean delete(int majorid);

	/**
	 * 修改专业
	 * 
	 * @param major
	 *            专业
	 * @return 操作结果，true为成功，false为失败
	 */
	public boolean update(TMajor major);

	/**
	 * 根据专业id获取专业对象
	 * 
	 * @param majorid
	 *            专业id
	 * @return 专业对象
	 */
	public VMajor selectByid(int majorid);

	/**
	 * 获取所有专业对象列表
	 * 
	 * @return 专业对象列表
	 */
	public List<VMajor> select();

	/**
	 * 获取所有专业对象列表
	 * 
	 * @param collegeid
	 *            学院id
	 * @return 专业对象列表
	 */
	public List<VMajor> selectByColl(int collegeid);

	/**
	 * 获取总记录数
	 * 
	 * @return 总记录数
	 */
	public int getPageCount();

	/**
	 * 根据条件查询的总数量
	 * 
	 * @return
	 */
	public int getMajorAmount(String wherecondition);

	/**
	 * 分页查询数据
	 * 
	 * @return
	 */
	public List<VMajor> selectByPage(String wherecondition, int page,
			int pageSize);

	/**
	 * 根据条件专业名称获取专业id
	 * 
	 * @return
	 */
	public int getMajorid(String majorname);

}
