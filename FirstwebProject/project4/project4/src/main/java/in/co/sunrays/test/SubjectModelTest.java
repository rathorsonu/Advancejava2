package in.co.sunrays.test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.sunrays.bean.SubjectBean;
import in.co.sunrays.exception.DuplicateRecordException;
import in.co.sunrays.model.SubjectModel;

public class SubjectModelTest {
	public static void main(String[] args) throws Exception {
		Add();
		//delete();
		//update();
		//findByPk();
		//TestSerch();
		//TestList();

	}
	private static void TestList() {
		SubjectModel model = new SubjectModel();
		SubjectBean bean = new SubjectBean();
        List list= new ArrayList();
		try {
			list=model.list(1, 9);
			if (list.size()<0) {
				System.out.println("List Fail");
			}
			Iterator it =list.iterator();
			while (it.hasNext()) {
				bean = (SubjectBean) it.next();
				System.out.println(bean.getId());
				System.out.println(bean.getSubject_Name());
				System.out.println(bean.getCourse_Id());
				System.out.println(bean.getCourse_Name());
				System.out.println(bean.getDescription());
				System.out.println(bean.getCreatedBy());
				System.out.println(bean.getCreatedDatetime());
				System.out.println(bean.getModifiedBy());
				System.out.println(bean.getModifiedDatetime());
		
			}
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void TestSerch() {
		SubjectModel model = new SubjectModel();
		SubjectBean bean = new SubjectBean();
         List list=new ArrayList();
          bean.setCourse_Name("java");
         try {
			list= model.search(bean);
			if (list.size()<0) {
				System.out.println("List Fail");
			}
			Iterator it =list.iterator();
			while (it.hasNext()) {
				bean = (SubjectBean) it.next();
				System.out.println(bean.getId());
				System.out.println(bean.getSubject_Name());
				System.out.println(bean.getCourse_Id());
				System.out.println(bean.getCourse_Name());
				System.out.println(bean.getDescription());
				System.out.println(bean.getCreatedBy());
				System.out.println(bean.getCreatedDatetime());
				System.out.println(bean.getModifiedBy());
				System.out.println(bean.getModifiedDatetime());
		
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private static void findByPk() {
		SubjectModel model = new SubjectModel();
		SubjectBean bean =  new SubjectBean();

		try {
			bean=model.findByPK(2);
			if (bean==null) {
				System.out.println("Find BY pk");
			}
			System.out.println(bean.getId());
			System.out.println(bean.getSubject_Name());
			System.out.println(bean.getCourse_Id());
			System.out.println(bean.getCourse_Name());
			System.out.println(bean.getDescription());
			System.out.println(bean.getCreatedBy());
			System.out.println(bean.getCreatedDatetime());
			System.out.println(bean.getModifiedBy());
			System.out.println(bean.getModifiedDatetime());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		
	
	private static void update() throws Exception {
		try {
		SubjectModel model = new SubjectModel();
		SubjectBean bean = model.findByPK(2);
		
		bean.setSubject_Name("javacore");
		bean.setCourse_Name("corprate");
		bean.setCourse_Id(3);
		bean.setDescription("asdffg");
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));	
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		bean.setId(3);
		model.update(bean);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		/*
		 * try {
		 * 
		 * } catch (Exception e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		
	}
	private static void delete() {
		SubjectBean bean = new SubjectBean();
		SubjectModel model = new SubjectModel();
		bean.setId(1);
		try {
			model.delete(bean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private static void Add() throws Exception {
		SubjectBean bean = new SubjectBean();
		SubjectModel model = new SubjectModel();
		bean.setId(9);
		bean.setCourse_Id(2);
		bean.setSubject_Name("trfghfhgdfdfhg");
		bean.setCourse_Name("ghfhgfgh");
		bean.setDescription("bscfhgfghfghfBiotech");
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));	
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		model.add(bean);
	}
		
	}


