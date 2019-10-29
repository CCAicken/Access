package controller.service;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TAdminUser;
import model.TUser;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.EnCriptUtil;
import util.Expression;
import util.LayuiData;
import business.dao.AdminUserDAO;
import business.dao.UserDAO;
import business.factory.DAOFactory;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "user")
public class UserController {
	@RequestMapping(value = "getuser")
	public void getUserList(HttpServletRequest request, int page, int limit,
			String wherecondition, Integer collegeid, Integer majorid,
			Integer classid, HttpServletResponse response, Model model) {

		UserDAO udao = DAOFactory.getUserDAO();
		// 查询条件
		Expression exp = new Expression();

		if (collegeid != null && !collegeid.equals("")) {

			exp.andEqu("collegeid", collegeid, Integer.class);
		}
		if (majorid != null && !majorid.equals("")) {

			exp.andEqu("majorid", majorid, Integer.class);
		}
		if (classid != null && !classid.equals("")) {

			exp.andEqu("classid", classid, Integer.class);
		}
		if (wherecondition != null && !wherecondition.equals("")) {
			exp.andLeftBraLike("username", wherecondition, String.class);
			exp.orLike("userid", wherecondition, String.class);
			exp.orLike("collegename", wherecondition, String.class);
			exp.orLike("majorname", wherecondition, String.class);
			exp.orRightBraLike("classname", wherecondition, String.class);
		}
		String opreation = exp.toString();
		System.out.println(opreation);
		int allcount = udao.getUserAmount(opreation);

		List list = udao.selectUserByPage(opreation, page, limit);

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
	}

	@RequestMapping(value = "adduser")
	public void addUser(HttpServletRequest request, Integer classid,
			String userid, String username, String pwd, Integer usertype,
			HttpServletResponse response, Model model) {

		UserDAO udao = DAOFactory.getUserDAO();
		String md5Str = EnCriptUtil.fix(userid, pwd);
		String endPwd = EnCriptUtil.getEcriptStr(md5Str, "md5");
		TUser user = new TUser();
		user.setUserid(userid);
		user.setUsername(username);
		user.setPwd(endPwd);
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();

		if (udao.insert(user)) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "添加成功";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "添加失败";
		}
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
	}

	@RequestMapping(value = "deluser")
	public void delUser(HttpServletRequest request, String userid,
			HttpServletResponse response, Model model) {

		UserDAO udao = DAOFactory.getUserDAO();

		LayuiData laydata = new LayuiData();

		if (udao.delete(userid)) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "删除成功";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "删除失败";
		}
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
	}

	@RequestMapping(value = "changepwd")
	public void changPwd(HttpServletRequest request,
			HttpServletResponse response, Model model, String userid,
			String oldpwd, String newpwd) {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		AdminUserDAO udao = DAOFactory.getAdminUserDAO();
		String md5Str = EnCriptUtil.fix(userid, oldpwd);
		String oldPwd = EnCriptUtil.getEcriptStr(md5Str, "md5");
		TAdminUser user = udao.getuser(userid);
		Writer out;
		if (!user.getPwd().equals(oldPwd)) {
			try {
				out = response.getWriter();
				out.write("原密码不正确");
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			String md5Str2 = EnCriptUtil.fix(userid, newpwd);
			String newPwd = EnCriptUtil.getEcriptStr(md5Str2, "md5");
			if (udao.updatePwd(userid, newPwd)) {
				try {
					out = response.getWriter();
					out.write("修改成功");
					out.flush();
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				try {
					out = response.getWriter();
					out.write("修改失败");
					out.flush();
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
