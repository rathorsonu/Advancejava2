package in.co.sunrays.bean;

public class MarksheetBean extends BaseBean{
	    
	   private String rollNo;
	  
	   private long studentId;
	 
	   private String name;

	   private Integer physics;

	   private Integer chemistry;
	 
	   private Integer maths;
	   
	   public MarksheetBean(){}
	   
	   public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPhysics() {
		return physics;
	}

	public void setPhysics(Integer physics) {
		this.physics = physics;
	}

	public Integer getChemistry() {
		return chemistry;
	}

	public void setChemistry(Integer chemistry) {
		this.chemistry = chemistry;
	}

	public Integer getMaths() {
		return maths;
	}

	public void setMaths(Integer maths) {
		this.maths = maths;
	}

	public String getKey() {
		// TODO Auto-generated method stub
		return id+"";
	}

	public String getValue() {
		// TODO Auto-generated method stub
		return name;
	}

	public int compareTo(BaseBean o) {
		// TODO Auto-generated method stub
		return 0;
	}


	}


