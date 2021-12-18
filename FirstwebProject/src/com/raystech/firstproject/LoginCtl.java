package com.raystech.firstproject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginCtl")
public class LoginCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// set a cookie
		String name = request.getParameter("sonu");
		String value = request.getParameter("Rathor");
		Cookie c = new Cookie(name, value);
		c.setMaxAge(60);
		response.addCookie(c);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			response.setContentType("text/html");
			RegistrationModel model = new RegistrationModel();

			RegistrationBean bean = new RegistrationBean();
			bean.setEmail(request.getParameter("login"));
			bean.setPwd((request.getParameter("pwd")));

			RegistrationBean bean1 = new RegistrationBean();
			bean1 = model.Authenticate(bean.getEmail(), bean.getPwd());
			if (bean1 != null) {
				PrintWriter out = response.getWriter();
				HttpSession session = request.getSession();
				String login = request.getParameter("login");
				String pwd = request.getParameter("pwd");
				session.setAttribute("user", bean1.getName());
				RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
				// request.setAttribute("user", bean1.getName());
				rd.forward(request, response);
			} else {
				PrintWriter out = response.getWriter();
				out.println("Auth Fail");
				RequestDispatcher rd = request.getRequestDispatcher("loginview.jsp");
				request.setAttribute("error", "inavalid user & password");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
