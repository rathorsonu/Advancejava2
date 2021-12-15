package com.raystech.jdbc;



public class TestMarksheet {
	public static void main(String[] args) throws Exception {
		Testadd();
		 //Testupdate();
		// Testdelet();
		//marksheet();
	//	Testrollno();
		//serch();
		//Testmerit();

	}
			



	private static void Testmerit() {
	
		
	}




	private static void marksheet() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		bean.setRollno(126);
		Marksheetmodel sd = new Marksheetmodel();
       sd.marksheet(bean);
		
		
	}

	private static void serch() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		bean.setRollno(126);;
		Marksheetmodel m1 = new Marksheetmodel();
		m1.Serch(bean);
	
	}

	private static void Testrollno() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		bean.setRollno(123);
		Marksheetmodel sd = new Marksheetmodel();
		sd.rollno(bean);
		 System.out.println("rollno");
	}

	private static void Testdelet() throws Exception {
		MarksheetBean sd = new MarksheetBean();
		sd.setId(16);
		Marksheetmodel s1 = new Marksheetmodel();
		s1.Delete(sd);
		System.out.println("delete");
	}

	private static void Testupdate() throws Exception {
		MarksheetBean bean = new MarksheetBean();

		bean.setRollno(126);
		bean.setFname("somya");
		bean.setLname("rathor");
		bean.setPhy(90);
		bean.setChe(50);
		bean.setMath(70);
		bean.setId(6);
		Marksheetmodel s = new Marksheetmodel();
		s.update(bean);
		System.out.println("update");

	}

	private static void Testadd() throws Exception {
		MarksheetBean m1 = new MarksheetBean();
		//m1.setId(19);
		m1.setRollno(129);
		m1.setFname("mohit");
		m1.setLname("rathor");
		m1.setPhy(90);
		m1.setChe(80);
		m1.setMath(70);
		Marksheetmodel s1 = new Marksheetmodel();
		s1.add(m1);
		System.out.println("data add");
	}
}
