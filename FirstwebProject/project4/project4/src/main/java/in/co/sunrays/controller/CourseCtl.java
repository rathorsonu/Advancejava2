package in.co.sunrays.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import in.co.sunrays.bean.BaseBean;
import in.co.sunrays.bean.CourseBean;
import in.co.sunrays.exception.ApplicationException;
import in.co.sunrays.exception.DuplicateRecordException;
import in.co.sunrays.model.CourseModel;
import in.co.sunrays.util.DataUtility;
import in.co.sunrays.util.DataValidator;
import in.co.sunrays.util.PropertyReader;
import in.co.sunrays.util.ServletUtility;
@WebServlet(name="CourseCtl", urlPatterns={"/ctl/CourseCtl"})
public class CourseCtl extends BaseCtl {

	@Override
	protected boolean validate(HttpServletRequest request) {
		boolean pass= true;
		if (DataValidator.isNull(request.getParameter("name"))) {
			request.setAttribute("name", PropertyReader.getValue("error.require","CourseName"));
			pass=false;
		}else if (!DataValidator.isName(request.getParameter("name"))) {
			request.setAttribute("name", "Name Must Contain Only Character");
			pass=false;
		}
		
		if (DataValidator.isNull(request.getParameter("duration"))) {
			request.setAttribute("duration", PropertyReader.getValue("error.require","Duration"));
			pass=false;
		}
		/*}else if (DataValidator.isName(request.getParameter("name"))) {
			request.setAttribute("name", PropertyReader.getValue("error.require", "Name Must Contain Only Character"));
			pass=false;
		}
		*/
		
		if (DataValidator.isNull(request.getParameter("description"))) {
			request.setAttribute("description", PropertyReader.getValue("error.require","Description"));
			pass=false;
		}else if (!DataValidator.isName(request.getParameter("description"))) {
			request.setAttribute("description", "Description Must Contain Only Character");
			pass=false;
		}
	
		return pass;
	}
	@Override
	protected BaseBean populateBean(HttpServletRequest request) {
		CourseBean crb=new CourseBean();
		crb.setId(DataUtility.getLong(request.getParameter("id")));
       crb.setCourse_Name(DataUtility.getString(request.getParameter("name")));		
	crb.setDuration(DataUtility.getString(request.getParameter("duration")));
	crb.setDescription(DataUtility.getString(request.getParameter("description")));
	populateDTO(crb, request);
	return crb;
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
     String op=DataUtility.getString(request.getParameter("operation"));
		long id=DataUtility.getLong(request.getParameter("id"));
		CourseModel crm=new CourseModel();
		if (id>0) {
			try {
				
				CourseBean crb=crm.findByPK(id);
				ServletUtility.setBean(crb, request);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		ServletUtility.forward(getView(), request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	CourseModel crm=new CourseModel();
	String op=DataUtility.getString(request.getParameter("operation"));
	long id =	DataUtility.getLong(request.getParameter("id"));
	if (OP_SAVE.equalsIgnoreCase(op)||OP_UPDATE.equalsIgnoreCase(op)) {
		CourseBean crb=(CourseBean)populateBean(request);
		try {
		if (id>0) {
			crm.update(crb);
			ServletUtility.setBean(crb, request);
			ServletUtility.setSuccessMessage("Course data is successfully updated ", request);
			}else {
				long pk=crm.add(crb);
				ServletUtility.setBean(crb, request);
				ServletUtility.setSuccessMessage("Course Data is Successfully Add", request);
			}
		}catch (ApplicationException e) {
			e.printStackTrace();
			ServletUtility.handleException(e, request, response);
			return;
		}
		catch (DuplicateRecordException e) {
				ServletUtility.setBean(crb, request);
				ServletUtility.setErrorMessage("Course Email Id already exists ", request);
				return;
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if (OP_RESET.equalsIgnoreCase(op)) {
			ServletUtility.redirect(ORSView.COURSE_CTL, request, response);
			return;
		}else if (OP_CANCEL.equalsIgnoreCase(op)) {
			ServletUtility.redirect(ORSView.COURSE_LIST_CTL, request, response);
			
		}
	ServletUtility.forward(getView(), request, response);
	}


	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return ORSView.COURSE_VIEW;
	}

}
