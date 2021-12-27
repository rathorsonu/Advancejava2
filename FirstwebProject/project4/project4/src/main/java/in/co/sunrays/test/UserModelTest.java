package in.co.sunrays.test;



import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.sunrays.bean.UserBean;
import in.co.sunrays.model.UserModel;

public class UserModelTest {
public static void main(String[] args) throws Exception {
	add();
	//update();
	//delete();
	//testFindByPk();
     // testFindByLogin();	
	//testGetRoles();
	//testSerch();
	//testAuthenticate();
	//testRegisterUser();
	//testChangePassword();

}


	


private static void testChangePassword() throws Exception {
	UserModel um = new UserModel();
	UserBean ub = um.findByLogin("son562@gmail.com");
	String oldPassword = ub.getPassword();
	ub.setId(5l);
	ub.setPassword("123");
	 ub.setConfirmPassword("123");
	String newPassword = ub.getPassword();
try{
	um.changePassword(5l, oldPassword, newPassword);
}catch(Exception e) {
	e.printStackTrace();
}
	System.out.println("password has been change successfully");

	
}

private static void testRegisterUser() throws ParseException {
	try {
	SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
	UserBean bean =new UserBean();
	UserModel model= new UserModel();
	//bean.setId(2);
	bean.setFirstName("harsh");
	bean.setLastName("patidar");
	bean.setLogin("son562@gmail.com");
	bean.setPassword("15656qwwq");
	bean.setConfirmPassword("11231321");
	bean.setDob(sdf.parse("08/12/1997"));
	bean.setMobileNo(9145555);
	bean.setRoleId(345l);
	bean.setUnSuccessfulLogin(12364);
	bean.setGender("male");
	bean.setLastLogin(new Timestamp(new Date().getTime()));
	bean.setLock("asdfg");
	bean.setRegisteredIP("sad");
	bean.setLastLoginIP("sdsfds");
	bean.setCreatedBy("admin");
	bean.setModifiedBy("admin");
	bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
	bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

	
		long pk=model.registerUser(bean);
		System.out.println("successfully register");
		UserBean added=model.findByPK(pk);
		if (added==null) {
			System.out.println("register fail");
		}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

private static void testAuthenticate() {
	UserBean bean =new UserBean();
	UserModel model= new UserModel();
	bean.setLogin("sonu1@gmail.com");
	bean.setPassword("15656qwwq");
	try {
		bean=model.authenticate(bean.getLogin(), bean.getPassword());
		if (bean!=null) {
			System.out.println("Successfully login");
		} else {
      System.out.println("inavalid user id& password");
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

private static void testSerch() {
	UserBean bean =new UserBean();
	UserModel model= new UserModel();
	
	bean.setRoleId(345);
	List list=new ArrayList();
      try {
		list=model.getRoles(bean);
		if (list.size()<0) {
			System.out.println("List fail");
		}
		Iterator it =list.iterator();
		while (it.hasNext()) {
		bean= (UserBean) it.next();
		System.out.println(bean.getFirstName());
		System.out.println(bean.getLastName());
		System.out.println(bean.getDob());
	
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}

private static void testGetRoles() {
	UserBean bean =new UserBean();
	UserModel model= new UserModel();
	bean.setRoleId(345);
	List list=new ArrayList();
      try {
		list=model.getRoles(bean);
		if (list.size()<0) {
			System.out.println("List fail");
		}
		Iterator it =list.iterator();
		while (it.hasNext()) {
		bean= (UserBean) it.next();
		System.out.println(bean.getFirstName());
		System.out.println(bean.getLastName());
		System.out.println(bean.getDob());
	
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

private static void testFindByLogin() {
	UserBean bean =new UserBean();
	UserModel model= new UserModel();
	try {
		bean=model.findByLogin("sonu1@gmail.com");
		if (bean==null) {
			System.out.println("findByLogin Fail");
		}
		System.out.println(bean.getFirstName());
		System.out.println(bean.getLastName());
		System.out.println(bean.getDob());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

private static void testFindByPk() {
	UserBean bean =new UserBean();
	UserModel model= new UserModel();
 try {
	bean=model.findByPK(2);
	if (bean==null) {
		System.out.println("Findbypk fail");
	}
	System.out.println(bean.getFirstName());
	System.out.println(bean.getLastName());
	System.out.println(bean.getDob());
	
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	
}

private static void delete() {
UserBean bean =new UserBean();
UserModel model= new UserModel();
bean.setId(1);
try {
	model.delete(bean);
	System.out.println("deleted");
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}	
}

private static void update() throws Exception  {
	SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	UserModel model=new UserModel();
	UserBean bean=model.findByPK(2L);
	bean.setFirstName("akansha");
	bean.setLastName("rawal");
	bean.setLogin("sonu124@gmail.com");
	bean.setPassword("15656qwwq");
	bean.setConfirmPassword("11231321");
	bean.setDob(sdf.parse("08/12/1997"));
	bean.setMobileNo(9145555);
	bean.setRoleId(345);
	bean.setUnSuccessfulLogin(12364);
	bean.setGender("male");
	bean.setLastLogin(new Timestamp(new Date().getTime()));
	bean.setLock("asdfg");
	bean.setRegisteredIP("sad");
	bean.setLastLoginIP("sdsfds");
	bean.setCreatedBy("admin");
	bean.setModifiedBy("admin");
	bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
	bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
	
	
	
	
	model.update(bean);
}

private static void add() throws Exception {
	SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	UserBean bean=new UserBean();
	UserModel model=new UserModel();
	bean.setId(2);
	bean.setFirstName("Suyesh");
	bean.setLastName("dabi");
	bean.setLogin("suyesh@gmail.com");
	bean.setPassword("126hgfd");
	bean.setConfirmPassword("12554");
	bean.setDob(sdf.parse("08/12/1997"));
	bean.setMobileNo(91455555);
	bean.setRoleId(5);
	bean.setUnSuccessfulLogin(12364);
	bean.setGender("male");
	bean.setLastLogin(new Timestamp(new Date().getTime()));
	bean.setLock("asdfg");
	bean.setRegisteredIP("sad");
	bean.setLastLoginIP("sdsfds");
	bean.setCreatedBy("admin");
	bean.setModifiedBy("admin");
	bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
	bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
	model.add(bean);
	System.out.println("Add successfuly");
}
}
