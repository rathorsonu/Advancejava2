package com.raystech.firstproject;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegistrationCtl")
public class RegistrationCtl extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out =response.getWriter();
	//print out coockies
	Cookie cookies[]=request.getCookies();
	for (Cookie c : cookies) {
		String name=c.getName();
		String value=c.getValue();
		out.println(name+""+value);
	}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		String dat = request.getParameter("dob");
		Date a = null;
		try {
			a = sd.parse(dat);
		} catch (ParseException e) {

			e.printStackTrace();
		}
		RegistrationBean rb = new RegistrationBean();
		rb.setName(request.getParameter("name"));
		rb.setSurname(request.getParameter("surname"));
		rb.setGender(request.getParameter("gender"));
		rb.setDate_of_birth(a);
		rb.setMobile_no(Long.parseLong(request.getParameter("moblie")));
		rb.setEmail(request.getParameter("email"));
		rb.setPwd(request.getParameter("pwd"));
		boolean pass= true;
		//name
		    if (DataValidator.isNull(request.getParameter("name"))) {
	        request.setAttribute("error1", "name is requerd");
	         pass = false;
	        }else if (!DataValidator.isName(request.getParameter("name"))) {
				request.setAttribute("error2", "Name must contain only Characters ");
				pass = false;
				}
		    //surname 
		    if (DataValidator.isNull(request.getParameter("surname"))) {
		        request.setAttribute("error3", "surname is requerd");
		         pass = false;
		        }else if (!DataValidator.isName(request.getParameter("surname"))) {
					request.setAttribute("error4", "Surname must contain only Characters ");
					pass = false;
					}
		
	  //gender
		  if (DataValidator.isNull(request.getParameter("gender"))) {
		  request.setAttribute("error5", "Gender is requerd"); 
		  pass = false; 
		  }
		  //Date of birth
		  if (DataValidator.isNull(request.getParameter("dob"))) {
		  request.setAttribute("error6", "Date is requerd");
		  pass = false; 
		  }
		  //Mobile
		  if (DataValidator.isNull(request.getParameter("moblie"))) {
		        request.setAttribute("error7", "Mobile is requerd");
		         pass = false;
		        }else if (!DataValidator.isMobileNo(request.getParameter("moblie"))) {
					request.setAttribute("error8", "Mobile must contain only 10 Characters ");
					pass = false;
					}
		    //Email
		    if (DataValidator.isNull(request.getParameter("email"))) {
		        request.setAttribute("error9", "Email is requerd");
		         pass = false;
		        }else if (!DataValidator.isEmail(request.getParameter("email"))) {
					request.setAttribute("error10", "Email must contain Uppercase lowercase and nomber ");
					pass = false;
					}
		    //Password
		    if (DataValidator.isNull(request.getParameter("pwd"))) {
		        request.setAttribute("error11", "Password is requerd");
		         pass = false;
		        }else if (!DataValidator.isPassword(request.getParameter("pwd"))) {
					request.setAttribute("error12", "password must contain Uppercase lowercase and nomber  ");
					pass = false;
					}
		    
           RequestDispatcher rd=request.getRequestDispatcher("Registration.jsp");
        
           rd.forward(request, response);
          if(pass==true) {
				try {
			RegistrationModel.Add(rb);
			   RequestDispatcher gh=request.getRequestDispatcher("Registration.jsp");
		        request.setAttribute("Success", "Registration Succefully");
		           gh.forward(request, response);
		        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          }
		PrintWriter out = response.getWriter();
		out.println("Data inserted");

	}
		  
}