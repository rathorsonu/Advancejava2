package in.co.sunrays.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.Request;

import in.co.sunrays.bean.BaseBean;
import in.co.sunrays.bean.CollegeBean;
import in.co.sunrays.bean.CourseBean;
import in.co.sunrays.bean.FacultyBean;
import in.co.sunrays.bean.SubjectBean;
import in.co.sunrays.exception.ApplicationException;
import in.co.sunrays.exception.DuplicateRecordException;
import in.co.sunrays.model.CollegeModel;
import in.co.sunrays.model.CourseModel;
import in.co.sunrays.model.FacultyModel;
import in.co.sunrays.model.SubjectModel;
import in.co.sunrays.util.DataUtility;
import in.co.sunrays.util.DataValidator;
import in.co.sunrays.util.PropertyReader;
import in.co.sunrays.util.ServletUtility;
@WebServlet ("/ctl/FacultyCtl")
public class FacultyCtl extends BaseCtl {
	
	@Override
	protected void preload(HttpServletRequest request) {
	CourseModel crm=new CourseModel();
	CollegeModel cm=new CollegeModel();
	SubjectModel sm=new SubjectModel();
	
	List<CourseBean> crlist=null;
	List<CollegeBean> clist=null;
	List<SubjectBean> slist=null;
	
	try {
		crlist=crm.list();
		clist=cm.list();
		slist=sm.list();

		request.setAttribute("CourseList", crlist);
		request.setAttribute("CollegeList", clist);
		request.setAttribute("SubjectList", slist);

	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
System.out.println("-------------preelod method over--------------");
	}
	
	@Override
	protected boolean validate(HttpServletRequest request) {
		// TODO Auto-generated method stub
System.out.println("-----------------validation method in-----------------------------");

		boolean pass=true;
		if(DataValidator.isNull(request.getParameter("firstname"))){
			request.setAttribute("firstname", PropertyReader.getValue("error.require", "FirstName"));
			 pass = false;
		}else if (!DataValidator.isName(request.getParameter("firstname"))) {
			request.setAttribute("firstname", "First name must contain only Characters");
			 pass = false ;
		}
		if(DataValidator.isNull(request.getParameter("lastname"))){
			request.setAttribute("lastname", PropertyReader.getValue("error.require", "LastName"));
			pass = false;
		}else if (!DataValidator.isName(request.getParameter("lastname"))) {
			request.setAttribute("lastname", "Last name must contain only Characters");
			 pass = false ;
		}
		if (DataValidator.isNull(request.getParameter("gender"))) {
			request.setAttribute("gender", PropertyReader.getValue("error.require", "Gender"));
			pass = false;
		}
		if (DataValidator.isNull("doj")) {
			request.setAttribute("doj", PropertyReader.getValue("error.require", "Date of Joining"));
			pass = false;
		}else if(!DataValidator.isDate(request.getParameter("doj"))){
			request.setAttribute("doj", PropertyReader.getValue("error.date", "Date of Joining"));
			pass=false;
		}
		if(DataValidator.isNull(request.getParameter("qualification"))){
			request.setAttribute("qualification", PropertyReader.getValue("error.require", "Qualification"));
			pass = false;
		}else if (!DataValidator.isName(request.getParameter("qualification"))) {
			request.setAttribute("qualification", "Qualification name must contain only Characters");
			 pass = false ;
		}
		if(DataValidator.isNull(request.getParameter("loginid"))){
			request.setAttribute("loginid", PropertyReader.getValue("error.require", "LoginId"));
			pass = false;
		}else if (!DataValidator.isEmail(request.getParameter("loginid"))) {
			request.setAttribute("loginid", PropertyReader.getValue("error.email", "Email ID"));
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("mobileno"))) {
			request.setAttribute("mobileno", PropertyReader.getValue("error.require", "MobileNo"));
			pass = false;
		}else if (!DataValidator.isMobileNo(request.getParameter("mobileno"))) {
			request.setAttribute("mobileno", "Mobile No. must be 10 Digit and No. Series start with 6-9");
			pass = false;
		}
		
		if (DataValidator.isNull(request.getParameter("collegeid"))) {
			request.setAttribute("collegeid", PropertyReader.getValue("error.require", "CollegeName"));
			pass = false;
		}
		
		if (DataValidator.isNull(request.getParameter("courseid"))) {
			request.setAttribute("courseid", PropertyReader.getValue("error.require", "CourseName"));
			pass = false;
		}
		
		if (DataValidator.isNull(request.getParameter("subjectid"))) {
			request.setAttribute("subjectid", PropertyReader.getValue("error.require", "SubjectName"));
			pass = false;
		}
		
		
		System.out.println("validate out ");
	
		return pass;
		
	}
	
	
	@Override
	protected BaseBean populateBean(HttpServletRequest request) {
		System.out.println(" populate bean ctl  in ");
		FacultyBean fb = new FacultyBean();
	
		fb.setId(DataUtility.getLong(request.getParameter("id")));
		fb.setFirst_Name(DataUtility.getString(request.getParameter("firstname")));
		fb.setLast_Name(DataUtility.getString(request.getParameter("lastname")));
		fb.setGender(DataUtility.getString(request.getParameter("gender")));
		fb.setDOJ(DataUtility.getDate(request.getParameter("doj")));
		
		
		fb.setQualification(DataUtility.getString(request.getParameter("qualification")));
		fb.setEmail_id(DataUtility.getString(request.getParameter("loginid")));
		fb.setMobile_No(DataUtility.getLong(request.getParameter("mobileno")));
		fb.setCollege_id(DataUtility.getInt(request.getParameter("collegeid")));
		fb.setCourse_id(DataUtility.getInt(request.getParameter("courseid")));
		fb.setSubject_id(DataUtility.getInt(request.getParameter("subjectid")));
		
      populateDTO(fb, request);
		
		System.out.println(" populate fb ctl out ");
		return fb;
	}
	

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("----------doget---------start--------------");
		String op=DataUtility.getString(request.getParameter("operation"));
		
		FacultyModel model=new FacultyModel();
		long id =DataUtility.getLong(request.getParameter("id"));
		try {
		if (id>0 || op!=null ) {
			FacultyBean fb;
			
		
				fb=model.findByPk(id);
				ServletUtility.setBean(fb, request);
		}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		ServletUtility.forward(getView(), request, response);
		}
		
		
		
			
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op=DataUtility.getString(request.getParameter("operation"));
		
		long id = DataUtility.getLong(request.getParameter("id"));	
		
		// Get Model
		FacultyModel fm = new FacultyModel();
		if (OP_SAVE.equalsIgnoreCase(op) || OP_UPDATE.equalsIgnoreCase(op)) {
			FacultyBean fb = (FacultyBean) populateBean(request);
			
			try{
			if(id > 0){
				fm.update(fb);
				ServletUtility.setBean(fb, request);
				ServletUtility.setSuccessMessage("Faculty Data Successfully Updated", request);
			}else{
			long pk = fm.add(fb);
		
			ServletUtility.setBean(fb, request);
			ServletUtility.setSuccessMessage("Faculty Successfully Register", request);
			}
			
			}catch(ApplicationException e){
				//log.error(e);
				ServletUtility.handleException(e, request, response);
				return ; 
			} catch (DuplicateRecordException e) {
				ServletUtility.setBean(fb, request);
				ServletUtility.setErrorMessage("Faculty already Exist", request);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	else if (OP_RESET.equalsIgnoreCase(op)) {
				ServletUtility.redirect(ORSView.FACULTY_CTL, request, response);
				return ;
			}			
	else if (OP_CANCEL.equalsIgnoreCase(op) ) {
		ServletUtility.redirect(ORSView.FACULTY_LIST_CTL, request, response);
		return ;
	}			
		System.out.println(" do post out ");
		ServletUtility.forward(getView(), request, response);
		
	}

	
	@Override
	
	
	protected String getView() {
		// TODO Auto-generated method stub
		return ORSView.FACULTY_VIEW;
	}

}
