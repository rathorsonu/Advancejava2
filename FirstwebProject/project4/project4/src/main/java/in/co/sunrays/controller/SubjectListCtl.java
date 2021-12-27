package in.co.sunrays.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.PopupMenuUI;

import org.omg.CORBA.Request;

import in.co.sunrays.bean.BaseBean;
import in.co.sunrays.bean.CourseBean;
import in.co.sunrays.bean.SubjectBean;
import in.co.sunrays.exception.ApplicationException;
import in.co.sunrays.model.CourseModel;
import in.co.sunrays.model.StudentModel;
import in.co.sunrays.model.SubjectModel;
import in.co.sunrays.util.DataUtility;
import in.co.sunrays.util.PropertyReader;
import in.co.sunrays.util.ServletUtility;

@WebServlet("/ctl/SubjectListCtl")
public class SubjectListCtl extends BaseCtl {
	
protected void preload (HttpServletRequest request) {
	SubjectModel sm=new SubjectModel();
	CourseModel cm=new CourseModel();
	List<SubjectBean> slist=null;
	List<CourseBean> clist=null;
	try {
		slist=sm.list();
		
		clist=cm.list();
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("preload k bahra");
	}request.setAttribute("courseList", clist);
	request.setAttribute("subjectList", slist);
	
}
@Override
	protected BaseBean populateBean(HttpServletRequest request) {
		SubjectBean sb=new SubjectBean();
		sb.setId(DataUtility.getLong(request.getParameter("subjectname")));
		sb.setCourse_Id(DataUtility.getInt(request.getParameter("coursename")));
		populateDTO(sb, request);
		System.out.println("------------------populate method over---------------------------");
		return sb;
		
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List list=null;
		int pageNo=1;
			int pageSize=DataUtility.getInt(PropertyReader.getValue("page.size"));
			String op=DataUtility.getString(request.getParameter("operation"));
			
			 SubjectBean sb=(SubjectBean)populateBean(request);
			 SubjectModel sm=new SubjectModel();
			 try {
				list=sm.search(sb, pageNo, pageSize);
				if (list==null && list.size()==0) {
					ServletUtility.getErrorMessage("No Record Found",request);
				}
				ServletUtility.setBean(sb, request);
				ServletUtility.setList(list, request);
				ServletUtility.setPageNo(pageNo, request);
				ServletUtility.setPageSize(pageSize, request);
				
			} catch (ApplicationException e) {
				ServletUtility.handleException(e, request, response);
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ServletUtility.forward(getView(), request, response); 
		}
	
	@Override
	 protected void doPost(HttpServletRequest request,
	            HttpServletResponse response) throws ServletException, IOException {
	   List list =null;
	   String op =DataUtility.getString(request.getParameter("operation"));
	   int pageNo=DataUtility.getInt(request.getParameter("pageno"));
	   int pageSize=DataUtility.getInt(request.getParameter("pagesize"));
	 
	   pageNo = (pageNo == 0) ? 1 : pageNo;
       pageSize = (pageSize == 0) ? DataUtility.getInt(PropertyReader.getValue("page.size")) : pageSize;
	             String []ids= request.getParameterValues("id");
	             SubjectBean sb=(SubjectBean)populateBean(request); 
	          
	           SubjectModel model=new SubjectModel();
	           if (OP_SEARCH.equalsIgnoreCase(op)) {
	   			pageNo = 1;
	   		} else if (OP_NEXT.equalsIgnoreCase(op)) {
	   			pageNo++;
	   		} else if (OP_PREVIOUS.equalsIgnoreCase(op)) {
	   			if (pageNo > 1) {
	   				pageNo--;
	   			} else {
	   				pageNo = 1;
	   			}
	   		} else if (OP_NEW.equalsIgnoreCase(op)) {
	   			ServletUtility.redirect(ORSView.SUBJECT_CTL, request, response);
	   			return;
	   		} else if (OP_RESET.equalsIgnoreCase(op)) {
	   			ServletUtility.redirect(ORSView.SUBJECT_LIST_CTL, request, response);
	   			return;
	   		} else if (OP_DELETE.equalsIgnoreCase(op)) {
	   			pageNo = 1;
	   			if (ids != null && ids.length > 0) {
	   				SubjectBean deletebean = new SubjectBean();

	   				for (String id : ids) {
	   					deletebean.setId(DataUtility.getLong(id));
	   					try {
	   						model.delete(deletebean);
	   					} catch (ApplicationException e) {
	   				
	   						ServletUtility.handleException(e, request, response);
	   						return;
	   					}
	   					ServletUtility.setSuccessMessage("Subject Data Deleted Successfully ", request);
	   				}
	   			} else {
	   				ServletUtility.setErrorMessage("Select at least one record", request);
	   			}
	   		}
	   		try {
	   			list = model.search(sb);
	   			ServletUtility.setBean(sb, request);

	   		} catch (ApplicationException e) {
	   			e.printStackTrace();
	   		
	   			ServletUtility.handleException(e, request, response);
	   			return;
	   		}
	   		System.out.println("=============>>>>>>" + list + list.size());
	   		if (list == null || list.size() == 0 && !OP_DELETE.equalsIgnoreCase(op)) {
	   			ServletUtility.setErrorMessage("No Record Found", request);
	   		}
	   		ServletUtility.setBean(sb, request);
	   		ServletUtility.setList(list, request);
	   		ServletUtility.setPageNo(pageNo, request);
	   		ServletUtility.setPageSize(pageSize, request);
	   		ServletUtility.forward(getView(), request, response);
	   	}
	          
			
	
	@Override
	
	protected String getView() {
		// TODO Auto-generated method stub
		return ORSView.SUBJECT_LIST_VIEW;
	}

}
