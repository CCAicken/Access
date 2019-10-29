package controller.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TClass;
import model.VClass;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.Expression;
import util.LayuiData;
import util.ReadExcelUtils;
import business.dao.ClassesDAO;
import business.dao.MajorDAO;
import business.factory.DAOFactory;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "classes")
public class ClassesController {
	// ��ȡ�༶�б�
	@RequestMapping(value = "getclasses")
	public void getClassesList(HttpServletRequest request, Integer page,
			Integer limit, Integer collegeid, Integer majorid,
			String wherecondition, HttpServletResponse response, Model model) {
		// ��ѯ����
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
			laydata.msg = "ִ�гɹ�";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "������";
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

	// ��ȡ���а༶�б�
	@RequestMapping(value = "getallclasses")
	public void getAllClassesList(HttpServletRequest request, HttpServletResponse response, Model model) {
		ClassesDAO cdao = DAOFactory.getClassesDAO();
		List<TClass> majorlist = cdao.select();
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		LayuiData laydata = new LayuiData();
		if (majorlist != null) {
			laydata.code = LayuiData.SUCCESS;
			laydata.data = majorlist;
			laydata.msg = "ִ�гɹ�";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "������";
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
	
	// ���Ӱ༶
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
			laydata.msg = "���ӳɹ�";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "����ʧ��";

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

	// ɾ���༶
	@RequestMapping(value = "delclasses")
	public void delClasses(HttpServletRequest request, Integer classid,
			HttpServletResponse response, Model model) {
		ClassesDAO cdao = DAOFactory.getClassesDAO();

		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();
		if (cdao.delete(classid)) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "ɾ���ɹ�";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "ɾ��ʧ��";

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

	// �༭�༶
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
			laydata.msg = "�༭�ɹ�";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "�༭ʧ��";

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

	// �������Ӱ༶
	@RequestMapping(value = "addclasseslist")
	public void addClassesByList(HttpServletRequest request, String path,
			HttpServletResponse response, Model model) {
		ClassesDAO mdao = DAOFactory.getClassesDAO();

		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		// ��Ϣ��ʾ
		LayuiData layui = new LayuiData();
		try {
			String filepath = path;// �ļ�·��
			ReadExcelUtils excelReader = new ReadExcelUtils(filepath);

			// ��ȡExcel��������
			List<Map<Integer, Object>> list = excelReader.readExcelContent();
			List<Object> classeslist = new ArrayList<Object>();

			for (Map<Integer, Object> map : list) {
				TClass classes = new TClass();
				for (Map.Entry<Integer, Object> m : map.entrySet()) {

					switch (m.getKey()) {
					case 0:
						MajorDAO cdao = DAOFactory.getMajorDAO();
						Integer majorid = cdao
								.getMajorid((String) m.getValue());
						classes.setMajorid(majorid);
						break;
					case 1:
						classes.setClassname((String) m.getValue());
						break;
					default:
						break;
					}
				}
				classeslist.add(classes);

			}
			if (mdao.insertList(classeslist)) {
				layui.code = 0;
				layui.msg = "����ɹ�";
			} else {
				layui.code = 1;
				layui.msg = "�������";
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
			System.out.println("δ�ҵ�ָ��·�����ļ�!");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}