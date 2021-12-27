package in.co.sunrays.test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.sunrays.bean.CollegeBean;
import in.co.sunrays.bean.MarksheetBean;
import in.co.sunrays.exception.ApplicationException;
import in.co.sunrays.exception.DuplicateRecordException;
import in.co.sunrays.model.CollegeModel;
import in.co.sunrays.model.MarksheetModel;

public class MarksheetModelTest {
public static void main(String[] args) {
	//add();
	//update();
	//delete();
	//findByPk();
	//findByRollNo();
	//testMeritList();
	//testList();
	testGetSerch();
}

    private static void testGetSerch() {
	MarksheetBean bean =new MarksheetBean();
	MarksheetModel model=new MarksheetModel();
	List list=new ArrayList();
	
	bean.setName("ranu");
	try {
		list=model.search(bean);
		if (list.size()<0) {
			System.out.println("List fail");
		}
		Iterator it =list.iterator();
		while (it.hasNext()) {
		bean = (MarksheetBean) it.next();
		System.out.println(bean.getId());
		System.out.println(bean.getRollNo());
		System.out.println(bean.getName());
		System.out.println(bean.getPhysics());
		System.out.println(bean.getChemistry());
		System.out.println(bean.getMaths());
		System.out.println(bean.getCreatedBy());
		System.out.println(bean.getCreatedDatetime());
		System.out.println(bean.getModifiedBy());
		System.out.println(bean.getModifiedDatetime());
		
			
		}
	} catch (ApplicationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

	private static void testList() {
MarksheetBean bean=new MarksheetBean();
MarksheetModel model=new MarksheetModel();
List list =new ArrayList();
try {
	list=model.list();
	if (list.size()<0) {
		System.out.println("list fail");
	}
	Iterator it =list.iterator();
	while (it.hasNext()) {
		bean= (MarksheetBean) it.next();
		System.out.println(bean.getId());
		System.out.println(bean.getRollNo());
		System.out.println(bean.getName());
		System.out.println(bean.getPhysics());
		System.out.println(bean.getChemistry());
		System.out.println(bean.getMaths());
		System.out.println(bean.getCreatedBy());
		System.out.println(bean.getCreatedDatetime());
		System.out.println(bean.getModifiedBy());
		System.out.println(bean.getModifiedDatetime());
		
		
	}
} catch (ApplicationException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	
}

	private static void testMeritList() {
	MarksheetBean bean=new MarksheetBean();
	MarksheetModel model =new MarksheetModel();
	List list =new ArrayList();
	System.out.println("------------");
	try {
		list=model.getMeritList(1, 6);
		System.out.println("qasdfvb");
		if (list.size() < 0) {
			System.out.println("Test list Fail");
		}
			Iterator it=list.iterator();
			
			while (it.hasNext()) {
				bean = (MarksheetBean) it.next();
				System.out.println(bean.getId());
				System.out.println(bean.getRollNo());
				System.out.println(bean.getName());
				System.out.println(bean.getPhysics());
				System.out.println(bean.getChemistry());
				System.out.println(bean.getMaths());
					/*
					 * System.out.println(bean.getCreatedBy());
					 * System.out.println(bean.getCreatedDatetime());
					 * System.out.println(bean.getModifiedBy());
					 * System.out.println(bean.getModifiedDatetime());
					 */
			}
			
		
	} catch (ApplicationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}




private static void findByRollNo() {
MarksheetBean bean=new MarksheetBean();
MarksheetModel model =new MarksheetModel();

	try {
		bean=model.findByRollNo("Asd123");
		System.out.println("RollFail");
		if (bean==null) {
			System.out.println(bean.getId());
			System.out.println(bean.getRollNo());
			System.out.println(bean.getName());
			System.out.println(bean.getPhysics());
			System.out.println(bean.getChemistry());
			System.out.println(bean.getMaths());
			System.out.println(bean.getCreatedBy());
			System.out.println(bean.getCreatedDatetime());
			System.out.println(bean.getModifiedBy());
			System.out.println(bean.getModifiedDatetime());
			
		}
	} catch (ApplicationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

private static void findByPk() {
	MarksheetBean bean= new MarksheetBean();
	MarksheetModel model=new MarksheetModel();

	try {
		bean=model.findByPK(1);
		System.out.println("findBy pk fail");
		if (bean==null) {
			System.out.println(bean.getId());
			System.out.println(bean.getRollNo());
			System.out.println(bean.getName());
			System.out.println(bean.getPhysics());
			System.out.println(bean.getChemistry());
			System.out.println(bean.getMaths());
			System.out.println(bean.getCreatedBy());
			System.out.println(bean.getCreatedDatetime());
			System.out.println(bean.getModifiedBy());
			System.out.println(bean.getModifiedDatetime());
			
		}
	} catch (ApplicationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

private static void delete() {
	MarksheetBean bean= new MarksheetBean();
	bean.setId(1);

	MarksheetModel model=new MarksheetModel();
	try {
		model.delete(bean);
	} catch (ApplicationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

private static void update() {
MarksheetBean bean=new MarksheetBean();

MarksheetModel model=new MarksheetModel();
bean.setId(1);
bean.setRollNo("Asd9856");
bean.setName("Ranu");
bean.setPhysics(85);
bean.setChemistry(63);
bean.setMaths(96);
bean.setCreatedBy("admin");
bean.setModifiedBy("admin");
bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
try {
	model.update(bean);
	System.out.println("update successfuly");
} catch (Exception  e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

}
private static void add() {
	MarksheetBean bean=new MarksheetBean();
	bean.setId(1);
	bean.setRollNo("Asd123");
	bean.setName("sunny Rathor");
	bean.setPhysics(45);
	bean.setChemistry(95);
	bean.setMaths(96);
	bean.setCreatedBy("admin");
	bean.setModifiedBy("admin");
	bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
	bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
	MarksheetModel model=new MarksheetModel();
	try {
		long pk=model.add(bean);
		System.out.println("assd");
		MarksheetBean addedbean=model.findByPK(pk);
		if (addedbean==null) {
			System.out.println("Testadd Fail");
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}
}
