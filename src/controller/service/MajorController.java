package controller.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TMajor;
import model.VMajor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.Expression;
import util.LayuiData;
import util.ReadExcelUtils;
import business.dao.CollegeDAO;
import business.dao.MajorDAO;
import business.factory.DAOFactory;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "major")
public class MajorController {
	// 获取专业列表
	@RequestMapping(value = "getmajor")
	public void getMajorList(HttpServletRequest request, Integer page,
			Integer limit, Integer collegeid, String wherecondition,
			HttpServletResponse response, Model model) {
		// 查询条件
		Expression exp = new Expression();
		if (collegeid != null) {
			exp.andEqu("collegeid", collegeid, Integer.class);
		}
		if (wherecondition != null && !wherecondition.equals("")) {
			exp.andLike("majorname", wherecondition, String.class);
		}
		String opreation = exp.toString();
		MajorDAO mdao = DAOFactory.getMajorDAO();
		int allcount = mdao.getMajorAmount(opreation);
		List<VMajor> majorlist = mdao.selectByPage(opreation, page, limit);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 获取所有专业列表
	@RequestMapping(value = "getallmajor")
	public void getAllMajor(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		MajorDAO mdao = DAOFactory.getMajorDAO();
		List<VMajor> majorlist = mdao.select();
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		LayuiData laydata = new LayuiData();
		if (majorlist != null) {
			laydata.data = majorlist;
			laydata.code = LayuiData.SUCCESS;
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
		
	// 添加专业
	@RequestMapping(value = "addmajor")
	public void addcollege(HttpServletRequest request, Integer collegeid,
			String majorname, HttpServletResponse response, Model model) {
		MajorDAO mdao = DAOFactory.getMajorDAO();

		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		TMajor major = new TMajor();
		major.setCollegeid(collegeid);
		major.setMajorname(majorname);

		LayuiData laydata = new LayuiData();
		if (mdao.insert(major)) {
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

	// 删除专业
	@RequestMapping(value = "delmajor")
	public void delMajor(HttpServletRequest request, Integer majorid,
			HttpServletResponse response, Model model) {
		MajorDAO mdao = DAOFactory.getMajorDAO();

		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();
		if (mdao.delete(majorid)) {
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

	// 编辑专业
	@RequestMapping(value = "edmajor")
	public void edMajor(HttpServletRequest request, Integer collegeid,
			Integer majorid, String majorname, HttpServletResponse response,
			Model model) {
		MajorDAO mdao = DAOFactory.getMajorDAO();

		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		TMajor major = new TMajor();
		major.setMajorid(majorid);
		major.setCollegeid(collegeid);
		major.setMajorname(majorname);

		LayuiData laydata = new LayuiData();
		if (mdao.update(major)) {
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

	// 批量添加专业
	@RequestMapping(value = "addmajorlist")
	public void addMajorByList(HttpServletRequest request, String path,
			HttpServletResponse response, Model model) {
		MajorDAO mdao = DAOFactory.getMajorDAO();

		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		// 消息提示
		LayuiData layui = new LayuiData();
		try {
			String filepath = path;// 文件路径
			ReadExcelUtils excelReader = new ReadExcelUtils(filepath);

			// 读取Excel表格内容
			List<Map<Integer, Object>> list = excelReader.readExcelContent();
			List<Object> majorlist = new ArrayList<Object>();

			for (Map<Integer, Object> map : list) {
				TMajor major = new TMajor();
				for (Map.Entry<Integer, Object> m : map.entrySet()) {

					switch (m.getKey()) {
					case 0:
						CollegeDAO cdao = DAOFactory.getCollegeDAO();
						Integer collegeid = cdao.getCollegeid((String) m
								.getValue());
						major.setCollegeid(collegeid);
						break;
					case 1:
						major.setMajorname((String) m.getValue());
						break;
					default:
						break;
					}
				}
				majorlist.add(major);

			}
			if (mdao.insertList(majorlist)) {
				layui.code = 0;
				layui.msg = "导入成功";
			} else {
				layui.code = 1;
				layui.msg = "导入错误";
			}
			Writer out;
			try {
				out = response.getWriter();
				out.write(JSON.toJSONString(layui));
				out.flush();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			System.out.println("未找到指定路径的文件!");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
