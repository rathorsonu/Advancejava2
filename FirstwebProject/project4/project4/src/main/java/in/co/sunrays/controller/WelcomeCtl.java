package in.co.sunrays.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.sunrays.util.ServletUtility;

/**
	 *  Welcome functionality Controller. Performs operation for Show Welcome page
	 *
	 * @author ShubHam
	 *
	 */

	@ WebServlet("/WelcomeCtl")
	public class WelcomeCtl extends BaseCtl{

	    private static final long serialVersionUID = 1L;

	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       ServletUtility.forward(getView(), request, response);
	    }

		@Override
		protected String getView() {
			// TODO Auto-generated method stub
			return ORSView.WELCOME_VIEW;
		}


	}

