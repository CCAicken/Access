package controller.service;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TClass;
import model.VClass;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.Expression;
import util.LayuiData;
import business.dao.ClassesDAO;
import business.factory.DAOFactory;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "classes")
public class ClassesController {
	// 获取班级列表
	@RequestMapping(value = "getclasses")
	public void getClassesList(HttpServletRequest request, Integer page,
			Integer limit, Integer collegeid, Integer majorid,
			String wherecondition, HttpServletResponse response, Model model) {
		// 查询条件
		Expression exp = new Expression();
		if (collegeid != null) {
			exp.andEqu("collegeid", collegeid, Integer.class);
		}
		if (majorid != null) {
			exp.andEqu("majorid", majorid, Integer.class);
		}
		if (wherecondition != null && !wherecondition.equals("")) {
			exp.andLike("classname", wherecondition, String.class);
		}
		String opreation = exp.toString();
		ClassesDAO cdao = DAOFactory.getClassesDAO();
		int allcount = cdao.getclassAmount(opreation);
		List<VClass> majorlist = cdao.selectByPage(opreation, page, limit);
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		LayuiData laydata = new LayuiData();
		if (majorlist != null) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "执行成功";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "无数据";
		}
		laydata.count = allcount;
		laydata.data = majorlist;
		Writer out;
		try {
			out = response.getWriter();
			out.write(JSON.toJSONString(laydata));
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 获取所有班级列表
	@RequestMapping(value = "getallclasses")
	public void getAllClassesList(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		ClassesDAO cdao = DAOFactory.getClassesDAO();
		List<TClass> majorlist = cdao.select();
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		LayuiData laydata = new LayuiData();
		if (majorlist != null) {
			laydata.code = LayuiData.SUCCESS;
			laydata.data = majorlist;
			laydata.msg = "执行成功";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "无数据";
		}
		Writer out;
		try {
			out = response.getWriter();
			out.write(JSON.toJSONString(laydata));
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 添加班级
	@RequestMapping(value = "addclasses")
	public void addClasses(HttpServletRequest request, Integer majorid,
			String classname, HttpServletResponse response, Model model) {
		ClassesDAO cdao = DAOFactory.getClassesDAO();

		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		TClass classes = new TClass();
		classes.setMajorid(majorid);
		classes.setClassname(classname);

		LayuiData laydata = new LayuiData();
		if (cdao.insert(classes)) {
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

	// 删除班级
	@RequestMapping(value = "delclasses")
	public void delClasses(HttpServletRequest request, Integer classid,
			HttpServletResponse response, Model model) {
		ClassesDAO cdao = DAOFactory.getClassesDAO();

		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();
		if (cdao.delete(classid)) {
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

	// 编辑班级
	@RequestMapping(value = "edclasses")
	public void edClasses(HttpServletRequest request, Integer majorid,
			Integer classid, String classname, HttpServletResponse response,
			Model model) {
		ClassesDAO cdao = DAOFactory.getClassesDAO();

		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		TClass classes = new TClass();
		classes.setClassid(classid);
		classes.setMajorid(majorid);
		classes.setClassname(classname);

		LayuiData laydata = new LayuiData();
		if (cdao.update(classes)) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "编辑成功";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "编辑失败";

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
