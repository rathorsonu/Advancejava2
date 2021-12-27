package in.co.sunrays.bean;


/**
 * @author ShubHam
 *
 */

public class RoleBean extends BaseBean {
	public static final int ADMIN = 1;
	public static final int STUDENT = 2;
	public static final int COLLEGESCHOOL = 3;
	public static final int KIOSK = 4;
	public static final int FACULTY = 5;

/**
 * name of role
 *
 */
	private String name;

/**
 * description of role
 *
 */
	private String description;
	

/**
 * accessor
 *
 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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


