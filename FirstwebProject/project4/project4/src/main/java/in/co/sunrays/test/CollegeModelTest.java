package in.co.sunrays.test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.sunrays.bean.CollegeBean;
import in.co.sunrays.exception.ApplicationException;
import in.co.sunrays.model.CollegeModel;

public class CollegeModelTest {
	public static void main(String[] args) throws Exception {
		//testAdd();
		//testupdate();
		//delete();
		//TestSerch();
		//TestList();
		//findBypk();
		//findByName();

	}

	private static void findByName() {
		//CollegeBean bean=new CollegeBean();
		try {
		CollegeModel model =new CollegeModel();
		//bean.setName("sonu");
	
			CollegeBean bean=model.findByName("sonu");
			if (bean==null) {
				System.out.println("FindByName Fail");
				
			}
			System.out.println(bean.getId());
			 System.out.println(bean.getName());
	         System.out.println(bean.getAddress());
	         System.out.println(bean.getState());
	         System.out.println(bean.getCity());
	         System.out.println(bean.getPhoneNo());
	         System.out.println(bean.getCreatedBy());
	         System.out.println(bean.getCreatedDatetime());
	         System.out.println(bean.getModifiedBy());
	         System.out.println(bean.getModifiedDatetime());
	     
			
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private static void findBypk() {
		try {
	CollegeBean bean=new CollegeBean();
	CollegeModel model=new CollegeModel();
	
		bean=model.findByPK(2);
		if (bean==null) {
			System.out.println("findBypk Fail");
		}
		System.out.println(bean.getId());
		 System.out.println(bean.getName());
         System.out.println(bean.getAddress());
         System.out.println(bean.getState());
         System.out.println(bean.getCity());
         System.out.println(bean.getPhoneNo());
         System.out.println(bean.getCreatedBy());
         System.out.println(bean.getCreatedDatetime());
         System.out.println(bean.getModifiedBy());
         System.out.println(bean.getModifiedDatetime());
     
	} catch (ApplicationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}


	
			 	
	private static void TestSerch() {
		try {
	CollegeBean bean= new CollegeBean();
	List list=new ArrayList();
	bean.setAddress("Bhanpura");
	
	CollegeModel model=new CollegeModel();
	
		list =model.search(bean, 1, 10);
		if (list.size()<0) {
			System.out.println("Testserch Fail");
		}
		Iterator it=list.iterator();
		while (it.hasNext()) {
			bean = (CollegeBean) it.next();
			System.out.println(bean.getId());
			System.out.println(bean.getName());
			System.out.println(bean.getAddress());
			System.out.println(bean.getState());
			System.out.println(bean.getCity());
			System.out.println(bean.getPhoneNo());
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
	private static void delete() throws Exception {
		CollegeBean bean=new CollegeBean();
		bean.setId(1);
		CollegeModel model=new CollegeModel();
		model.delete(bean);
		System.out.println("Data delete");
	}
	private static void testupdate() {
		try {
			CollegeModel model=new CollegeModel();
		CollegeBean bean = model.findByPK(12);
		
		bean.setName("Vikrantah");
		bean.setAddress("Bhanpura");
		bean.setState("up");
		bean.setCity("Dehradun");
		bean.setPhoneNo(917495326);
		bean.setCreatedBy("Admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		//bean.setId(1);
		
			model.update(bean);
			System.out.println("success");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void testAdd() throws Exception {
		try {
			CollegeBean bean = new CollegeBean();
			
			bean.setName("VIkranta");
			bean.setAddress("Indore");
			bean.setState("mp");
			bean.setCity("indore");
			bean.setPhoneNo(073124244);
			bean.setCreatedBy("Admin");
			bean.setModifiedBy("Admin");
			bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
			bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
			CollegeModel model = new CollegeModel();
			long pk = model.add(bean);
			CollegeBean addedBean = model.findByPK(pk);
			if (addedBean == null) {
				System.out.println("Test add fail");
			}
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}
	
}
