package controller.service;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.TAdminUser;
import model.VRoleButton;
import model.VRoleClumn;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.LayuiData;
import util.layuitree;
import business.basic.iHibBaseDAOImpl;
import business.impl.RoleAccessImpl;

import com.alibaba.fastjson.JSON;

/**
 * 管理页面按钮和列
 * 
 * @author Aicken
 *
 */
@Controller
@RequestMapping(value = "roleaccess")
public class RoleAccessContoller {
	/**
	 * 
	 * 
	 * @param request
	 * @param response
	 * @param model
	 */
	@RequestMapping(value = "gettree")
	public void getAdminUserList(HttpServletRequest request,
			Integer sysModelId, HttpServletResponse response, Model model) {
		HttpSession session = request.getSession();
		TAdminUser loginuser = (TAdminUser) session.getAttribute("loginuser");
		RoleAccessImpl bdao = new RoleAccessImpl();
		iHibBaseDAOImpl ibdao = new iHibBaseDAOImpl();
		// System.out.println(loginuser.getRoleId() + "++++" + sysModelId);
		List<layuitree> maplist = ibdao.getlist(loginuser.getRoleId());
		List buttonlist = bdao.getRoleButtonByRoleIdAndSysId(
				loginuser.getRoleId(), sysModelId);

		// 回传json字符串
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();

		if (maplist != null) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "查询成功，共查出" + maplist.size() + "条记录";
			laydata.data = maplist;
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "查询失败";
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

	/**
	 * 
	 * 
	 * @param request
	 * @param response
	 * @param model
	 */
	@RequestMapping(value = "updateaccess")
	public void updateAccessList(HttpServletRequest request, String btns,
			String clumns, String unbtns, String unclumns, Integer sysModelId,
			HttpServletResponse response, Model model) {
		List<layuitree> treebtns = JSON.parseArray(btns, layuitree.class);
		List<layuitree> treeclumns = JSON.parseArray(clumns, layuitree.class);

		List<layuitree> untreebtns = JSON.parseArray(unbtns, layuitree.class);
		List<layuitree> untreeclumns = JSON.parseArray(unclumns,
				layuitree.class);

		RoleAccessImpl bdao = new RoleAccessImpl();

		for (layuitree layuitree : treeclumns) {
			bdao.changeRoleClumnByRoleIdAndSysId(layuitree.getRelationshipid(),
					layuitree.getId(), true);
		}
		for (layuitree layuitree : treebtns) {
			bdao.changeUseRoleButtonByRoleIdAndSysId(
					layuitree.getRelationshipid(), layuitree.getId(), true);
		}

		for (layuitree layuitree : untreeclumns) {
			bdao.changeRoleClumnByRoleIdAndSysId(layuitree.getRelationshipid(),
					layuitree.getId(), false);
		}
		for (layuitree layuitree : untreebtns) {
			bdao.changeUseRoleButtonByRoleIdAndSysId(
					layuitree.getRelationshipid(), layuitree.getId(), false);
		}
		HttpSession session = request.getSession();
		TAdminUser loginuser = (TAdminUser) session.getAttribute("loginuser");
		iHibBaseDAOImpl ibdao = new iHibBaseDAOImpl();
		List<layuitree> maplist = ibdao.getlist(loginuser.getRoleId());
		List buttonlist = bdao.getRoleButtonByRoleIdAndSysId(
				loginuser.getRoleId(), sysModelId);

		// 回传json字符串
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();

		if (maplist != null) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "查询成功，共查出" + maplist.size() + "条记录";
			laydata.data = maplist;
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "查询失败";
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

	/**
	 * 根据角色id 获取角色权限
	 * 
	 * @param request
	 * @param roleid
	 *            角色id
	 * @param response
	 * @param model
	 */
	@RequestMapping(value = "getalltree")
	public void getAccessList(HttpServletRequest request, Integer roleid,
			HttpServletResponse response, Model model) {
		HttpSession session = request.getSession();
		TAdminUser loginuser = (TAdminUser) session.getAttribute("loginuser");
		RoleAccessImpl bdao = new RoleAccessImpl();
		iHibBaseDAOImpl ibdao = new iHibBaseDAOImpl();
		// System.out.println(loginuser.getRoleId() + "++++" + sysModelId);
		List<layuitree> maplist = ibdao.getlist(roleid);

		// 回传json字符串
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();

		if (maplist != null) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "查询成功，共查出" + maplist.size() + "条记录";
			laydata.data = maplist;
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "查询失败";
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

	@RequestMapping(value = "geteditclosandbtn")
	public void getCloumnsList(HttpServletRequest request, Integer sysid,
			HttpServletResponse response, Model model) {
		HttpSession session = request.getSession();
		TAdminUser loginuser = (TAdminUser) session.getAttribute("loginuser");
		RoleAccessImpl bdao = new RoleAccessImpl();
		iHibBaseDAOImpl ibdao = new iHibBaseDAOImpl();
		// System.out.println(loginuser.getRoleId() + "++++" + sysModelId);
		List<VRoleButton> btnlist = bdao.getUseRoleButtonByRoleIdAndSysId(
				loginuser.getRoleId(), sysid);
		List<VRoleClumn> clulist = bdao.getUseRoleClumnByRoleIdAndSysId(
				loginuser.getRoleId(), sysid);

		List<String> strbtn = new ArrayList<String>();
		List<String> strclu = new ArrayList<String>();

		if (btnlist.size() != 0) {
			for (VRoleButton btn : btnlist) {
				strbtn.add(btn.getBtnname());
			}

		}
		if (clulist.size() != 0) {
			for (VRoleClumn clu : clulist) {
				strclu.add(clu.getClumnKey());
			}
		}

		// 回传json字符串
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();

		if (strbtn.size() != 0 && strclu.size() != 0) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "查询成功";
			laydata.data = strclu;
			laydata.data1 = strbtn;
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "查询失败";
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
}
