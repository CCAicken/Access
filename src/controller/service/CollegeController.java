package controller.service;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TCollege;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.Expression;
import util.LayuiData;
import business.dao.CollegeDAO;
import business.factory.DAOFactory;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "college")
public class CollegeController {
	// ��ȡѧԺ�б�
	@RequestMapping(value = "getcollege")
	public void getCollegeList(HttpServletRequest request, Integer page,
			Integer limit, String wherecondition, HttpServletResponse response,
			Model model) {

		// ��ѯ����
		Expression exp = new Expression();

		if (wherecondition != null && !wherecondition.equals("")) {

			exp.andLike("collegename", wherecondition, String.class);
		}

		String opreation = exp.toString();

		CollegeDAO cdao = DAOFactory.getCollegeDAO();
		int allcount = cdao.getCollegeAmount(opreation);
		List<TCollege> collegelist = cdao.selectByPage(opreation, page, limit);

		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();
		if (collegelist != null) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "ִ�гɹ�";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "������";

		}

		laydata.count = allcount;
		laydata.data = collegelist;
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

	// ��ȡ����ѧԺ�б�
	@RequestMapping(value = "getallcollege")
	public void getAllCollegeList(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		CollegeDAO cdao = DAOFactory.getCollegeDAO();
		List<TCollege> collegelist = cdao.select();
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		LayuiData laydata = new LayuiData();
		if (collegelist != null) {
			laydata.code = LayuiData.SUCCESS;
			laydata.data = collegelist;
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

	// ���ѧԺ
	@RequestMapping(value = "addcollege")
	public void addcollege(HttpServletRequest request, String collegename,
			HttpServletResponse response, Model model) {
		CollegeDAO cdao = DAOFactory.getCollegeDAO();

		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		TCollege college = new TCollege();
		college.setCollegename(collegename);

		LayuiData laydata = new LayuiData();
		if (cdao.insert(college)) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "��ӳɹ�";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "���ʧ��";

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

	// ɾ��ѧԺ
	@RequestMapping(value = "delcollege")
	public void delcollege(HttpServletRequest request, Integer collegeid,
			HttpServletResponse response, Model model) {
		CollegeDAO cdao = DAOFactory.getCollegeDAO();

		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();
		if (cdao.delete(collegeid)) {
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

	// �༭ѧԺ
	@RequestMapping(value = "edcollege")
	public void edcollege(HttpServletRequest request, Integer collegeid,
			String collegename, HttpServletResponse response, Model model) {
		CollegeDAO cdao = DAOFactory.getCollegeDAO();

		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		TCollege college = new TCollege();
		college.setCollegename(collegename);
		college.setCollegeid(collegeid);

		LayuiData laydata = new LayuiData();
		if (cdao.update(college)) {
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
}
