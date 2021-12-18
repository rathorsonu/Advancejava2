package com.raystech.firstproject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Studentmgtctl")
public class Studentmgtctl extends HttpServlet {
	private Object object;
	private Object object2;
	private static final long serialVersionUID = 1L;
    
        
  	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		Studentbean bean=new Studentbean();
  		bean.setId ( Integer.parseInt(request.getParameter("Id")));
  		bean.setRollNo(request.getParameter("RollNo"));
  		bean.setFirstName(request.getParameter("FirstName"));
  		bean.setLastName(request.getParameter("LastName"));
  		bean.setSession(request.getParameter("Session"));
  		String op =request.getParameter("opration");
  		if (op.equals("Add")) {
			Studentmodel sd=new Studentmodel();
			try {
				sd.Add(bean);
				System.out.println("sonu");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(op.equals("Delete")) {
			try {
				Studentmodel.Delete(bean);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}else if(op.equals("Modify")) {
				try {
					Studentmodel.Update(bean);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
  		
		
  	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Studentbean bean=new Studentbean();
		Studentmodel model=new Studentmodel();
		try {
			bean=model.GetRoll(request.getParameter("search"));
			request.setAttribute("f", bean);
			RequestDispatcher rd= request.getRequestDispatcher("listview.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

          try {
			bean=model.Serchlist(request.getParameter("serch"));
			request.setAttribute("list", bean);
			RequestDispatcher rd= request.getRequestDispatcher("studentlist.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
