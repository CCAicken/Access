package controller.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.LayuiData;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "checklogin")
public class CheckLogin extends HttpServlet {
	@RequestMapping(value = "islogin")
	public void isLogin(HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		String action = request.getParameter("action");
		LayuiData laydata = new LayuiData();
		if (action.equals("check")) {
			HttpSession session = request.getSession();
			String loginstate = (String) session.getAttribute("loginstate");

			// System.out.println("loginstate:" + loginstate);
			if (loginstate == null) {
				laydata.code = LayuiData.SUCCESS;
				laydata.msg = "logined";
			} else if (loginstate.equals("logout")) {
				laydata.code = LayuiData.ERRR;
				laydata.msg = "logout";
			}
		}
		// »Ø´«json×Ö·û´®
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.write(JSON.toJSONString(laydata));
		out.flush();
		out.close();
	}
}
