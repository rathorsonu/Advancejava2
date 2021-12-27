package in.co.sunrays.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.sunrays.bean.BaseBean;
import in.co.sunrays.bean.CourseBean;
import in.co.sunrays.bean.SubjectBean;
import in.co.sunrays.exception.ApplicationException;
import in.co.sunrays.exception.DuplicateRecordException;
import in.co.sunrays.model.CollegeModel;
import in.co.sunrays.model.CourseModel;
import in.co.sunrays.model.SubjectModel;
import in.co.sunrays.util.DataUtility;
import in.co.sunrays.util.DataValidator;
import in.co.sunrays.util.PropertyReader;
import in.co.sunrays.util.ServletUtility;

@WebServlet("/ctl/SubjectCtl")
public class SubjectCtl extends BaseCtl {
	protected void preload(HttpServletRequest request) { // TODO Auto-generated

		CourseModel model = new CourseModel();
		try {
			List l = model.list();
			request.setAttribute("CourseList", l);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();		}
		System.out.println("-------prelode method over---------><><><<><><><><<");
	}

	@Override
	protected boolean validate(HttpServletRequest request) {
		boolean pass = true;
		if (DataValidator.isNull(request.getParameter("name"))) {
			System.out.println("1");
			request.setAttribute("name", PropertyReader.getValue("error.require", "Subject Name"));
			pass = false;
		} else if (!DataValidator.isName(request.getParameter("name"))) {
			System.out.println("2");

			request.setAttribute("name", "Subject name must contain only Characters");
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("description"))) {
			System.out.println("3");

			request.setAttribute("description", PropertyReader.getValue("error.require", "Description"));
			pass = false;
		} else if (!DataValidator.isName(request.getParameter("description"))) {
			System.out.println("4");

			request.setAttribute("description", "Description name must contain only Characters");
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("coursename"))) {
			System.out.println("5");

			request.setAttribute("coursename", PropertyReader.getValue("error.require", "coursename"));
			pass = false;

		}
		System.out.println("-------validation method over---------><><><<><><><><<");
		return pass;
	}

	@Override
	protected SubjectBean populateBean(HttpServletRequest request) {
		// TODO Auto-generated method stub
		SubjectBean sb = new SubjectBean();
		sb.setId(DataUtility.getLong(request.getParameter("id")));
		sb.setSubject_Name(DataUtility.getString(request.getParameter("name")));
		sb.setDescription(DataUtility.getString(request.getParameter("description")));
		sb.setCourse_Id(DataUtility.getInt(request.getParameter("coursename")));
		populateDTO(sb, request);
		System.out.println("-------populatebean method over---------><><><<><><><><<");
		return sb;

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		SubjectModel sm = new SubjectModel();
		SubjectBean sb = null;
		long id = DataUtility.getLong(request.getParameter("id"));
		if (id > 0) {
			try {
				sb = sm.findByPK(id);
				ServletUtility.setBean(sb, request);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		ServletUtility.forward(getView(), request, response);
		System.out.println("-------Do get method over---------><><><<><><><><<");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("insert1");
		String op = DataUtility.getString(request.getParameter("operation"));
		long id = DataUtility.getLong(request.getParameter("id"));
		SubjectModel model = new SubjectModel();
		if (OP_SAVE.equalsIgnoreCase(op) || OP_UPDATE.equalsIgnoreCase(op)) {
			SubjectBean sb = (SubjectBean) populateBean(request);
			try {
				if (id > 0) {

					model.update(sb);
					ServletUtility.setBean(sb, request);
					ServletUtility.setSuccessMessage("Subject Data Successfully Update", request);
				} else {
					long pk = model.add(sb);

					ServletUtility.setBean(sb, request);
					ServletUtility.setSuccessMessage("Subject Data Successfully Add", request);
				}
			} catch (DuplicateRecordException e) {
				// TODO Auto-generated catch block
				ServletUtility.setBean(sb, request);
				ServletUtility.setErrorMessage("Subject Name Already exsist", request);
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (OP_RESET.equalsIgnoreCase(op)) {
			ServletUtility.forward(ORSView.SUBJECT_CTL, request, response);
			return;
		} else if (OP_CANCEL.equalsIgnoreCase(op)) {
			ServletUtility.forward(ORSView.SUBJECT_LIST_CTL, request, response);
			return;
		}
		ServletUtility.forward(getView(), request, response);
		System.out.println("-------Do post method over---------><><><<><><><><<");
	}

	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return ORSView.SUBJECT_VIEW;
	}

}
