package controller.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import model.TAdminUser;
import model.VAdminUser;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.EnCriptUtil;
import util.Expression;
import util.LayuiData;
import business.dao.AdminUserDAO;
import business.factory.DAOFactory;
import business.impl.AdminUserDaoImpl;

import com.alibaba.fastjson.JSON;

/**
 * 管理员用户contoller类
 * 
 * @author jock
 *
 */
@Controller
@RequestMapping(value = "admin")
public class AdminUserController extends HttpServlet implements
		HttpSessionListener {
	/**
	 * 获取管理员用户列表
	 * 
	 * @param request
	 * @param page
	 * @param limit
	 * @param realname
	 * @param roleid
	 * @param response
	 * @param model
	 */
	@RequestMapping(value = "getuser")
	public void getAdminUserList(HttpServletRequest request, int page,
			int limit, String realname, Integer roleid,
			HttpServletResponse response, Model model) {

		AdminUserDAO audao = new AdminUserDaoImpl();
		// 查询条件
		Expression exp = new Expression();

		if (realname != null && !realname.equals("")) {

			exp.andLeftBraLike("realname", realname, String.class);
			exp.orRightBraLike("userid", realname, String.class);
		}
		if (roleid != null && roleid != 0) {
			exp.andEqu("roleid", roleid, Integer.class);
		}
		String opreation = exp.toString();
		// System.out.println(opreation);
		int allcount = audao.getAdaminUserAmount(opreation);

		List list = audao.getaAdminUserList(opreation, page, limit);

		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();
		laydata.code = LayuiData.SUCCESS;
		laydata.msg = "执行成功";
		laydata.count = allcount;
		laydata.data = list;
		Writer out;
		try {
			out = response.getWriter();
			out.write(JSON.toJSONString(laydata));
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// return "";
	}

	/**
	 * 实现一个管理员用户的添加
	 * 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/addadminuser")
	public void addAdminUser(String userid, String realname, String mobile,
			String pwd, String roleid, HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		// System.out.println(userid + "," + realname + "," + roleid);

		AdminUserDAO audao = new AdminUserDaoImpl();
		LayuiData laydata = new LayuiData();
		String md5Str = EnCriptUtil.fix(userid, pwd);
		String endPwd = EnCriptUtil.getEcriptStr(md5Str, "md5");
		TAdminUser user = new TAdminUser();
		user.setUserid(userid);
		user.setRealname(realname);
		user.setMobile(mobile);
		user.setRoleId(Integer.parseInt(roleid));
		user.setPwd(endPwd);
		user.setUserstatus(0);

		if (audao.addAdminUser(user)) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "管理员用户添加成功";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "管理员用户添加失败";
		}

		// 回传json字符串
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.write(JSON.toJSONString(laydata));
		out.flush();
		out.close();

	}

	/**
	 * 实现一个用户的退出
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping(value = "/logoutsystem")
	public void logoutsystem(HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {

		LayuiData laydata = new LayuiData();
		HttpSession session = request.getSession();
		session.removeAttribute("loginuser");
		laydata.code = LayuiData.SUCCESS;
		laydata.msg = "退出成功";
		// 回传json字符串
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.write(JSON.toJSONString(laydata));
		out.flush();
		out.close();

	}

	/**
	 * 实现一个管理员用户的删除
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping(value = "/deladminuser")
	public void delAdminUser(HttpServletRequest request,
			HttpServletResponse response, String userid, Model model)
			throws IOException {

		AdminUserDAO adao = DAOFactory.getAdminUserDAO();
		TAdminUser user = new TAdminUser();
		user.setUserid(userid);
		LayuiData laydata = new LayuiData();
		if (adao.delAdminUser(user)) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "删除成功";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "删除失败";
		}

		// 回传json字符串
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.write(JSON.toJSONString(laydata));
		out.flush();
		out.close();

	}

	/**
	 * 实现一个管理员用户的登陆
	 * 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/adminlogin")
	public void AdminUserLogin(String userid, String pwd,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException {

		AdminUserDAO audao = DAOFactory.getAdminUserDAO();
		LayuiData laydata = new LayuiData();

		VAdminUser user = new VAdminUser();
		user.setUserid((String) userid);
		user.setPwd(pwd);
		HttpSession session = request.getSession();
		VAdminUser loginuser = audao.login(user);
		if (loginuser != null) {
			// session.setAttribute("loginuser", loginuser);
			service(request);
			// session.setAttribute("loginuser", loginuser);
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "登陆成功";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "登陆失败";
		}

		// 回传json字符串
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.write(JSON.toJSONString(laydata));
		out.flush();
		out.close();

	}

	public static final Map<String, HttpSession> USER_SESSION = new HashMap<String, HttpSession>();
	public static final Map<String, String> SESSIONID_USER = new HashMap<String, String>();
	static boolean loginstate = false;

	private void service(HttpServletRequest request) throws IOException {
		// 处理用户登录(保持同一时间同一账号只能在一处登录)
		userLoginHandle(request);
		// 当前登录的用户
		String userid = request.getParameter("userid");
		// System.out.println(userid);
		HttpSession session = request.getSession();
		// 添加用户与HttpSession的绑定
		USER_SESSION.put(userid, session);
		// 添加sessionId和用户的绑定
		SESSIONID_USER.put(session.getId(), userid);
		session.setAttribute("userid", userid);
		session.removeAttribute("loginstate");
	}

	private static void userLoginHandle(HttpServletRequest request)
			throws IOException {
		// 当前登录的用户
		String userid = request.getParameter("userid");
		// 当前sessionId
		String sessionId = request.getSession().getId();
		// 删除当前sessionId绑定的用户，用户--HttpSession
		USER_SESSION.remove(SESSIONID_USER.remove(sessionId));

		// 删除当前登录用户绑定的HttpSession
		HttpSession session = USER_SESSION.remove(userid);
		if (session != null) {
			SESSIONID_USER.remove(session.getId());
			session.removeAttribute("userid");
			session.setAttribute("loginstate", "logout");
		}
	}

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		String sessionId = se.getSession().getId();
		// System.out.println(sessionId);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		String sessionId = se.getSession().getId();
		// 当前session销毁时删除当前session绑定的用户信息
		// 同时删除当前session绑定用户的HttpSession
		USER_SESSION.remove(SESSIONID_USER.remove(sessionId));
	}

}
