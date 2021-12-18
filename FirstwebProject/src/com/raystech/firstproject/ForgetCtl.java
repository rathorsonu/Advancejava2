package com.raystech.firstproject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ForgetCtl")
public class ForgetCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;{
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String em=(String)request.getParameter("email");
		RegistrationModel model=new RegistrationModel();
		RegistrationBean bean=new RegistrationBean();
		PrintWriter out = response.getWriter();
		bean.setEmail(request.getParameter("email"));
		RegistrationBean bean1;
		try {
			bean1=new RegistrationBean();
			bean1=model.forgetpwd(bean.getEmail());
			System.out.println(bean1.getPwd());
			if(bean1!=null) {
				System.out.println(bean1.getPwd());
				out.println("Auth succsess"+ bean1.getPwd());
				}else {
					out.println("Auth Fail");
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}

}
