package in.co.sunrays.test;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.sql.Timestamp;

import in.co.sunrays.bean.StudentBean;
import in.co.sunrays.exception.ApplicationException;
import in.co.sunrays.exception.DuplicateRecordException;
import in.co.sunrays.model.StudentModel;

public class StudentModelTest {
	public static void main(String[] args) throws Exception {
		Add();
		//update();
		//deldet();
		//testFindByPk();
		//testSerch();
		//Testlist();
		//findByEmail();
	}

	private static void findByEmail() {
		StudentBean bean=new StudentBean();
		StudentModel model =new StudentModel();
		
		
		try {
			bean=model.findByEmailId("sunny@gmail.com");
			System.out.println(bean.getId());
			System.out.println(bean.getCollegeId());
			System.out.println(bean.getCollegeName());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getDob());
			System.out.println(bean.getMobileNo());
			//System.out.println(bean.getEmail());
			System.out.println(bean.getCreatedBy());
			System.out.println(bean.getModifiedBy());
			System.out.println(bean.getCreatedDatetime());
			System.out.println(bean.getModifiedDatetime());
		
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void Testlist() {
		StudentBean bean=new StudentBean();
		StudentModel model =new StudentModel();
		List list=new ArrayList();
		bean.setLastName("rathor");
		try {
			list=model.list();
			if (list.size()<0) {
				System.out.println("List fail");
			}
			Iterator it =list.iterator();
			while (it.hasNext()) {
			bean = (StudentBean) it.next();
			System.out.println(bean.getId());
			System.out.println(bean.getCollegeId());
			System.out.println(bean.getCollegeName());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getDob());
			System.out.println(bean.getMobileNo());
			System.out.println(bean.getEmail());
			System.out.println(bean.getCreatedBy());
			System.out.println(bean.getModifiedBy());
			System.out.println(bean.getCreatedDatetime());
			System.out.println(bean.getModifiedDatetime());
		
			}
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void testSerch() {
	
		StudentBean bean=new StudentBean();
		StudentModel model =new StudentModel();
		List list=new ArrayList();
		bean.setFirstName("sonu");
		try {
			list=model.search(bean);
			if (list.size()<0) {
				System.out.println("List Fail");
				
				
			}
			Iterator it=list.iterator();
			while (it.hasNext()) {
			bean = (StudentBean) it.next();
			System.out.println(bean.getId());
			System.out.println(bean.getCollegeId());
			System.out.println(bean.getCollegeName());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getDob());
			System.out.println(bean.getMobileNo());
			System.out.println(bean.getEmail());
			System.out.println(bean.getCreatedBy());
			System.out.println(bean.getModifiedBy());
			System.out.println(bean.getCreatedDatetime());
			System.out.println(bean.getModifiedDatetime());
		
			}
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void testFindByPk() {
		StudentBean bean=new StudentBean();
		StudentModel model =new StudentModel();
		
		
		try {
			bean=model.findByPK(2);
			System.out.println(bean.getId());
			System.out.println(bean.getCollegeId());
			System.out.println(bean.getCollegeName());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getDob());
			System.out.println(bean.getMobileNo());
			System.out.println(bean.getEmail());
			System.out.println(bean.getCreatedBy());
			System.out.println(bean.getModifiedBy());
			System.out.println(bean.getCreatedDatetime());
			System.out.println(bean.getModifiedDatetime());
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void deldet() {
		StudentBean bean=new StudentBean();
		StudentModel model =new StudentModel();
		bean.setId(1);
		try {
			model.delete(bean);
			System.out.println("delete");
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void update() throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		try {
		StudentBean bean =new StudentBean();
		StudentModel model=new StudentModel();
		bean.setId(1);
		bean.setCollegeId(223);
		bean.setCollegeName("RJPV");
		bean.setFirstName("Harsh");
		bean.setLastName("Upadhyay");
		bean.setDob(sdf.parse("01/03/2010"));
		bean.setMobileNo(36594532);
		bean.setEmail("shny@gmail.com");
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		 bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		 bean.setModifiedDatetime(new Timestamp(new Date().getTime()));		
			model.update(bean);
			System.out.println("update success");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void Add() throws ApplicationException, DuplicateRecordException {

		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

		StudentBean bean = null;
		StudentModel model = new StudentModel();
		try {
			bean = new StudentBean();
			bean.setId(1);
			bean.setCollegeId(2);
			bean.setCollegeName("pg");
			bean.setFirstName("sonu");
			bean.setLastName("rathor");

			bean.setDob(sdf.parse("01/01/2010"));

			bean.setMobileNo(637767941);
			bean.setEmail("sunny@gmail.com");
			bean.setCreatedBy("admin");
			bean.setModifiedBy("admin");
			 bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
			 bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		} catch (Exception e) {
			e.printStackTrace();

		}

		model.add(bean);
	}
}
