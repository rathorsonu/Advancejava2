package in.co.sunrays.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import in.co.sunrays.bean.TimetableBean;
import in.co.sunrays.exception.ApplicationException;
import in.co.sunrays.model.TimeTablemodel;

public class TimeTablemodelTest {
	public static void main(String[] args) throws Exception {
		//add();
		//update();
		//delete();
		//findByPk();
		//serch();
		list();
		
	}

	private static void list() {
		TimetableBean tb=new TimetableBean();
		TimeTablemodel model= new TimeTablemodel();
		List list=new ArrayList();
		try {
			list=model.search(tb);
			if (list.size()<0) {
				System.out.println("List fail");
			}
			Iterator it=list.iterator();
			while (it.hasNext()) {
				tb = (TimetableBean) it.next();
				System.out.println(tb.getCourse_Id());
				System.out.println(tb.getCourse_Name());
				System.out.println(tb.getSubject_Id());
			}
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


		
	

	private static void serch() {
		
		TimetableBean tb=new TimetableBean();
		TimeTablemodel model= new TimeTablemodel();
		List list=new ArrayList();
		tb.setCourse_Name("corprte java");
		try {
			list=model.search(tb);
			if (list.size()<0) {
				System.out.println("List fail");
			}
			Iterator it=list.iterator();
			while (it.hasNext()) {
				tb = (TimetableBean) it.next();
				System.out.println(tb.getCourse_Id());
				System.out.println(tb.getCourse_Name());
				System.out.println(tb.getSubject_Id());
			}
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void findByPk() {
		TimetableBean tb=new TimetableBean();
		TimeTablemodel model= new TimeTablemodel();
		
		try {
			tb=model.findByPK(1);
			System.out.println(tb.getCourse_Id());
			System.out.println(tb.getCourse_Name());
			System.out.println(tb.getSubject_Id());
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	private static void delete() {
		TimetableBean tb=new TimetableBean();
		TimeTablemodel model= new TimeTablemodel();
		tb.setId(1);
		try {
			model.delete(tb);
			System.out.println("delete");
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void update() throws ParseException {
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		TimetableBean tb=new TimetableBean();
		TimeTablemodel model= new TimeTablemodel();
		tb.setId(1);
		tb.setCourse_Id(12);
		tb.setCourse_Name("corprte");
		tb.setSubject_Id(7458);
		tb.setSubject_Name("maths");
		tb.setExam_Date(sdf.parse("08/12/1997"));
		tb.setExam_Time("7pm");
		tb.setSemester("1st");
		try {
			model.update(tb);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void add() throws ParseException {
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	TimetableBean tb=new TimetableBean();
	TimeTablemodel model= new TimeTablemodel();
	tb.setId(1);
	tb.setCourse_Id(1236);
	tb.setCourse_Name("corprte java");
	tb.setSubject_Id(745896);
	tb.setSubject_Name("chemistry");
	tb.setExam_Date(sdf.parse("08/12/1997"));
	tb.setExam_Time("7pm");
	tb.setSemester("1st");
	try {
		model.add(tb);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
