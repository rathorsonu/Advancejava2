package in.co.sunrays.test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.sunrays.bean.CourseBean;
import in.co.sunrays.model.CourseModel;

public class CourseModelTest {
public static void main(String[] args) {
	//add();
	//update();
	//delete();
	//findByPk();
	testSerch();
	//testList();
}

private static void testList() {
	CourseBean bean= new CourseBean();
	CourseModel model =new CourseModel();
	List list= new ArrayList();
	try {
		list=model.list(1, 8);
		
		if (list.size()<0) {
			System.out.println("List Fail");
			
		}
		Iterator it =list.iterator();
		while (it.hasNext()) {
			bean= (CourseBean) it.next();
			System.out.println(bean.getCourse_Name());
			System.out.println(bean.getDescription());
			System.out.println(bean.getDuration());
			System.out.println(bean.getCreatedBy());
			System.out.println(bean.getModifiedBy());
			System.out.println(bean.getCreatedDatetime());
			System.out.println(bean.getModifiedDatetime());
			
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

private static void testSerch() {

	CourseBean bean= new CourseBean();
	CourseModel model =new CourseModel();
	List list= new ArrayList();
 bean.setCourse_Name("java");
 try {
	list=model.search(bean, 1, 10);
	if (list.size()<0) {
		System.out.println("List Fail");
	}
	Iterator it =list.iterator();
	while (it.hasNext()) {
		bean= (CourseBean) it.next();
		System.out.println(bean.getCourse_Name());
		System.out.println(bean.getDescription());
		System.out.println(bean.getDuration());
		System.out.println(bean.getCreatedBy());
		System.out.println(bean.getModifiedBy());
		System.out.println(bean.getCreatedDatetime());
		System.out.println(bean.getModifiedDatetime());
		
	}
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}

private static void findByPk() {
	CourseBean bean= new CourseBean();
	CourseModel model =new CourseModel();
 try {
	bean=model.findByPK(2);
	if (bean==null) {
		System.out.println("Find By pk");
	}
	System.out.println(bean.getCourse_Name());
	System.out.println(bean.getDescription());
	System.out.println(bean.getDuration());
	System.out.println(bean.getCreatedBy());
	System.out.println(bean.getModifiedBy());
	System.out.println(bean.getCreatedDatetime());
	System.out.println(bean.getModifiedDatetime());
	
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	
}

private static void delete() {
	CourseBean bean= new CourseBean();
	CourseModel model =new CourseModel();
	bean.setId(1);
	try {
		model.delete(bean);
		System.out.println("Delete");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

private static void update() {

	CourseBean bean= new CourseBean();
	CourseModel model =new CourseModel();
	bean.setId(2);
	bean.setCourse_Name("java");
	bean.setDescription("corejava");
	bean.setDuration("6");
	bean.setCreatedBy("admin");
	bean.setModifiedBy("admin");
	bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
	bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
try {
	model.update(bean);
	System.out.println("update success");
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}

private static void add() {
	try {
	CourseBean bean= new CourseBean();
	CourseModel model =new CourseModel();
	bean.setId(1);
	bean.setCourse_Name("fcghfgfg");
	bean.setDescription("corejava&advancejava");
	bean.setDuration("6month");
	bean.setCreatedBy("admin");
	bean.setModifiedBy("jsdfhdkjs");
	bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
	bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		long pk = model.add(bean);
		model.findByPK(pk);
		System.out.println(" addsnourjdf");
			/*
			 * CourseBean addedbean=model.findByPK(pk); if (addedbean==null) {
			 * System.out.println("add data"); }
			 */
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
