package business.dao;

import java.util.List;

import model.TUser;
import model.VUser;

/**
 * 用户业务接口类
 * 
 * @author Administrator
 *
 */
public interface UserDAO {
	// 学生方法
	/**
	 * 学生用户登录
	 * 
	 * @param userid
	 *            用户id
	 * @param pwd
	 *            用户密码
	 * @return user用户对象
	 */
	public TUser loginStu(String userid, String pwd);

	// public boolean insert(String userid,String username,String pwd,String
	// agend,String mobile,Classes classes,College college,Role role);
	/**
	 * 添加学生用户对象
	 * 
	 * @param user
	 *            用户对象
	 * @return 添加结果，true为成功，false为失败
	 */
	public boolean insert(TUser user);

	/**
	 * 修改学生密码
	 * 
	 * @param userid
	 *            用户id
	 * @param pwd
	 *            新密码
	 * @return 更新结果，true为成功，false为失败
	 */
	public boolean updatePwd(String userid, String pwd);

	/**
	 * 删除用户对象
	 * 
	 * @param userid
	 *            用户id
	 * @return 删除结果，true为成功，false为失败
	 */
	public boolean delete(String userid);

	/**
	 * 获取用户对象
	 * 
	 * @param userid
	 *            用户id
	 * @return 用户对象
	 */
	public TUser getTUserByUserId(String userid);

	/**
	 * 根据学院id获取用户对象列表
	 * 
	 * @param collegeid
	 *            学院id
	 * @return 用户对象列表
	 */
	public List<VUser> selectUserByColl(String collegeid);

	/**
	 * 根据专业id获取用户对象列表
	 * 
	 * @param majorid
	 *            专业id
	 * @return 用户对象列表
	 */
	public List<VUser> selectUserByMajor(String majorid);

	/**
	 * 根据班级id获取用户对象列表
	 * 
	 * @param classid
	 *            班级id
	 * @return 用户对象列表
	 */
	public List<VUser> selectUserByClass(String classid);

	/**
	 * 根据班级分页获取学生信息
	 * 
	 * @param classid
	 *            班级id
	 * @param page
	 *            当前页
	 * @param limit
	 *            每页数量
	 * @return
	 */
	public List<VUser> selectUserByClassPage(int classid, int page, int limit);

	/**
	 * 根据查询分页获取用户信息
	 * 
	 * @param classid
	 *            班级id
	 * @param page
	 *            当前页
	 * @param limit
	 *            每页数量
	 * @return
	 */
	public List<VUser> selectUserByPage(String opretion, int page, int limit);

	/**
	 * 班级学生数量
	 * 
	 * @param classid
	 * @return
	 */
	public int getUserAmount(String opretion);

	/**
	 * 批量添加用户
	 * 
	 * @param classeslist
	 *            用户列表
	 * @return
	 */
	public boolean insertList(List<Object> classeslist);

}
