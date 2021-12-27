package in.co.sunrays.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.Request;

import in.co.sunrays.bean.MarksheetBean;
import in.co.sunrays.exception.ApplicationException;
import in.co.sunrays.model.MarksheetModel;
import in.co.sunrays.util.DataUtility;
import in.co.sunrays.util.DataValidator;
import in.co.sunrays.util.PropertyReader;
import in.co.sunrays.util.ServletUtility;

public class MarksheetCtl extends BaseCtl {
	private void preelod(HttpServletRequest request) {
		MarksheetModel mm = new MarksheetModel();
		List<MarksheetBean> mlist = null;
		try {
			mlist = mm.list();
			request.setAttribute("marksheet", mlist);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void validation(HttpServletRequest request) {
		boolean pass = true;
		if (DataValidator.isNull(request.getParameter("rollNo"))) {
			request.setAttribute("rollNo", PropertyReader.getValue("error.require", "Roll Number"));
			pass = false;
		} else if (!DataValidator.isRollNo(request.getParameter("rollNo"))) {
			request.setAttribute("rollNo", "Roll Number must be alphanumeric");
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("name"))) {
			request.setAttribute("name", PropertyReader.getValue("error.require", "Name"));
			pass = false;
		} else if (!DataValidator.isName(request.getParameter("name"))) {
			request.setAttribute("name", "Name Must Contain Only Characters");
			pass=false;
		}if (DataValidator.isNull(request.getParameter("physics"))) {
			request.setAttribute("physics", PropertyReader.getValue("error.require","Physics Number" ));
			pass=false;
		}
		if (DataValidator.isNull(request.getParameter("chemistry"))) {
			request.setAttribute("chemistry", PropertyReader.getValue("error.require","Chemistry Number" ));
			pass=false;
		}

		if (DataValidator.isNull(request.getParameter("maths"))) {
			request.setAttribute("maths", PropertyReader.getValue("error.require","Maths Number" ));
			pass=false;
		}

        if (DataValidator.isNotNull(request.getParameter("physics"))
               && !DataValidator.isInteger(request.getParameter("physics"))) {
           request.setAttribute("physics",
                   PropertyReader.getValue("error.integer", "Marks"));
           pass = false;
       }

       if (DataUtility.getInt(request.getParameter("physics")) > 100) {
           request.setAttribute("physics", "Marks can not be greater than 100");
           pass = false;
       }

       if (DataUtility.getInt(request.getParameter("physics")) < 0) {
           request.setAttribute("physics", "Marks can not be less than 0");
           pass = false;

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(request, response);
	}

	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return null;
	}

}
