package in.co.sunrays.test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.sunrays.bean.FacultyBean;
import in.co.sunrays.model.FacultyModel;

public class FacultyModelTest {
public static void main(String[] args) throws Exception {
	add();
	//update();
	//delete();
    //serch();
}

private static void serch() {
	FacultyBean fb=new FacultyBean();
	FacultyModel model=new FacultyModel();
	List list =new ArrayList();
	fb.setFirst_Name("sonu");
	try {
		list=model.serch(fb, 1, 18);
		if (list.size()<0) {
			System.out.println("List fail");
		}
		Iterator it=list.iterator();
		while (it.hasNext()) {
			fb= (FacultyBean) it.next();
			System.out.println(fb.getFirst_Name());
			System.out.println(fb.getLast_Name());
			System.out.println(fb.getCollege_id());
			
		}
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	
}

private static void delete() {
	FacultyBean fb=new FacultyBean();
	FacultyModel model=new FacultyModel();
	fb.setId(1);;
try {
	model.delete(fb);
	System.out.println("Data delet");
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}	
}

private static void update() throws ParseException {
	SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	FacultyBean fb=new FacultyBean();
	FacultyModel model=new FacultyModel();
	fb.setFirst_Name("ASDF");
	fb.setLast_Name("gDFD");
	fb.setGender("male");
	fb.setDOB(sdf.parse("12/19/1998"));
	fb.setQualification("bsc");
	fb.setEmail_id("sunny1895@gmail.com");
	fb.setMobile_No(91749296);
	fb.setCollege_id(1236);
	fb.setCollege_Name("pg");
	fb.setCourse_id(3);
	fb.setCourse_Name("CORE JAVA");
    fb.setSubject_id(6);
    fb.setSubject_Name("java");
    fb.setCreatedBy("admin");
    fb.setModifiedBy("admin");
    fb.setCreatedDatetime(new Timestamp(new Date().getTime()));
    fb.setModifiedDatetime(new Timestamp(new Date().getTime()));
    fb.setId(1);
	try {
		model.update(fb);
		System.out.println("update success");////nhi chala
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

private static void add() throws ParseException {
	try {
	SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	FacultyBean fb=new FacultyBean();
	FacultyModel model=new FacultyModel();
	//fb.setId(3);
	fb.setFirst_Name("sunny");
	fb.setLast_Name("vaerma");
	fb.setGender("male");
	fb.setDOB(sdf.parse("8/02/1998"));
	fb.setQualification("bcom");
	fb.setEmail_id("sunray65@gmail.com");
	fb.setMobile_No(917564);
	fb.setCollege_id(1);
//	fb.setCollege_Name("pgcollege");
    fb.setSubject_id(1);
  //  fb.setSubject_Name("aths");
    fb.setCourse_id(1);
    fb.setCreatedBy("admin");
    fb.setModifiedBy("admin");
    fb.setCreatedDatetime(new Timestamp(new Date().getTime()));
    fb.setModifiedDatetime(new Timestamp(new Date().getTime()));
	
       long pk  =  model.add(fb);
		System.out.println("add Success");
FacultyBean added	=	model.findByPk();
if (added==null) {
	System.out.println("add fail");
}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
