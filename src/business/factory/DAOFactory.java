package business.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import business.dao.AdminRoleDAO;
import business.dao.AdminUserDAO;
import business.dao.ClassesDAO;
import business.dao.CollegeDAO;
import business.dao.MajorDAO;
import business.dao.RoleSysModelDAO;
import business.dao.SystemLogDAO;
import business.dao.SystemModelDAO;
import business.dao.UserDAO;

public class DAOFactory {
	private static ApplicationContext ctx = null;

	static {
		ctx = new ClassPathXmlApplicationContext("springmvc-servlet.xml");
	}

	/**
	 * 得到一个用于管理员业务操作的AdminUserDAO实现类对象
	 * 
	 * @return AdminUserDAO
	 */
	public static AdminUserDAO getAdminUserDAO() {
		return (AdminUserDAO) ctx.getBean("adminuserdao");
	}

	/**
	 * 得到一个用于管理员角色业务操作的AdminRoleDAO实现类对象
	 * 
	 * @return AdminRoleDAO
	 */
	public static AdminRoleDAO getAdminRoleDAO() {
		return (AdminRoleDAO) ctx.getBean("adminroledao");
	}

	/**
	 * 得到一个用于比赛业务操作的ClassesDAO实现类对象
	 * 
	 * @return ClassesDAO
	 */
	public static ClassesDAO getClassesDAO() {
		return (ClassesDAO) ctx.getBean("classesdao");
	}

	/**
	 * 得到一个学院业务操作的CollegeDAO实现类对象
	 * 
	 * @return CollegeDAO
	 */
	public static CollegeDAO getCollegeDAO() {
		return (CollegeDAO) ctx.getBean("collegedao");
	}

	/**
	 * 得到一个用于专业业务操作的MajorDAO实现类对象
	 * 
	 * @return MajorDAO
	 */
	public static MajorDAO getMajorDAO() {
		return (MajorDAO) ctx.getBean("majordao");
	}

	/**
	 * 得到一个用于系统菜单管理业务操作的SystemLogDAO实现类对象
	 * 
	 * @return SystemLogDAO
	 */
	public static SystemLogDAO getSystemLogDAO() {
		return (SystemLogDAO) ctx.getBean("systemlogdao");
	}

	/**
	 * 得到一个用于系统菜单管理业务操作的SystemModelDAO实现类对象
	 * 
	 * @return SystemModelDAO
	 */
	public static SystemModelDAO getSystemModelDAO() {
		return (SystemModelDAO) ctx.getBean("systemmodeldao");
	}

	/**
	 * 返回一个用于对用户信息操作的UserDAO对象
	 * 
	 * @return UserDAO
	 */
	public static UserDAO getUserDAO() {
		return (UserDAO) ctx.getBean("userdao");
	}

	/**
	 * 返回一个用于对用户信息操作的UserDAO对象
	 * 
	 * @return UserDAO
	 */
	public static RoleSysModelDAO getRoleSysModelDAO() {
		return (RoleSysModelDAO) ctx.getBean("rolesysmodeldao");
	}

}
