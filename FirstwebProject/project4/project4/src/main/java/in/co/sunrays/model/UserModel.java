package in.co.sunrays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import in.co.sunrays.bean.UserBean;
import in.co.sunrays.util.EmailBuilder;
import in.co.sunrays.util.EmailMessage;
import in.co.sunrays.util.EmailUtility;
import in.co.sunrays.util.JDBCDataSource;

public class UserModel {
	

	
		private long roleId;

	    public long getRoleId() {
	        return roleId;
	    }
	    public void setRoleId(long roleId) {
	        this.roleId = roleId;
	    }

	    public Integer nextPK() throws Exception {
	         Connection conn = null;
	        int pk = 0;

	        try {
	            conn = JDBCDataSource.getConnection();
	            PreparedStatement pstmt = conn
	                    .prepareStatement("SELECT MAX(ID) FROM ST_USER");
	            ResultSet rs = pstmt.executeQuery();
	            while (rs.next()) {
	                pk = rs.getInt(1);
	            }
	            rs.close();

	        } catch (Exception e) {
	            throw new Exception("Exception : Exception in getting PK");
	        } finally {
	            JDBCDataSource.closeConnection(conn);
	        }
	        return pk + 1;
	    }

	    /**
	     * Add a User
	     *
	     * @param bean
	     * @throws DatabaseException
	     *
	     */
	    public long add(UserBean bean) throws Exception {
	        Connection conn = null;
	        int pk = 0;

	        UserBean existbean = findByLogin(bean.getLogin());

	        if (existbean != null) {
	            throw new Exception("Login Id already exists");
	        }

	        try {
	            conn = JDBCDataSource.getConnection();
	            pk = nextPK();
	            // Get auto-generated next primary key
	            System.out.println(pk + " in ModelJDBC");
	            conn.setAutoCommit(false); // Begin transaction
	            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO ST_USER VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
	            pstmt.setInt(1, pk);
	            pstmt.setString(2, bean.getFirstName());
	            pstmt.setString(3, bean.getLastName());
	            pstmt.setString(4, bean.getLogin());
	            pstmt.setString(5, bean.getPassword());
	            pstmt.setDate(6, new java.sql.Date(bean.getDob().getTime()));
	            pstmt.setLong(7, bean.getMobileNo());
	            pstmt.setLong(8, bean.getRoleId());
	            pstmt.setInt(9, bean.getUnSuccessfulLogin());
	            pstmt.setString(10, bean.getGender());
	            pstmt.setTimestamp(11, bean.getLastLogin());
	            pstmt.setString(12, bean.getLock());
	            pstmt.setString(13, bean.getRegisteredIP());
	            pstmt.setString(14, bean.getLastLoginIP());
	            pstmt.setString(15, bean.getCreatedBy());
	            pstmt.setString(16, bean.getModifiedBy());
	            pstmt.setTimestamp(17, bean.getCreatedDatetime());
	            pstmt.setTimestamp(18, bean.getModifiedDatetime());
	            pstmt.executeUpdate();
	            conn.commit(); // End transaction
	            pstmt.close();
	        } catch (Exception e) {
	            try {
	                conn.rollback();
	            } catch (Exception ex) {
	                ex.printStackTrace();
	                throw new Exception(
	                        "Exception : add rollback exception " + ex.getMessage());
	            }
	            throw new Exception("Exception : Exception in add User");
	        } finally {
	            JDBCDataSource.closeConnection(conn);
	        }
	        return pk;
	    }

	    /**
	     * Delete a User
	     *
	     * @param bean
	     * @throws DatabaseException
	     */
	    public void delete(UserBean bean) throws Exception {
	       Connection conn = null;
	        try {
	            conn = JDBCDataSource.getConnection();
	            conn.setAutoCommit(false); // Begin transaction
	            PreparedStatement pstmt = conn
	                    .prepareStatement("DELETE FROM ST_USER WHERE ID=?");
	            pstmt.setLong(1, bean.getId());
	            pstmt.executeUpdate();
	            conn.commit(); // End transaction
	            pstmt.close();

	        } catch (Exception e) {
	            try {
	                conn.rollback();
	            } catch (Exception ex) {
	                throw new Exception(
	                        "Exception : Delete rollback exception "
	                                + ex.getMessage());
	            }
	            throw new Exception(
	                    "Exception : Exception in delete User");
	        } finally {
	            JDBCDataSource.closeConnection(conn);
	        }
	       
	    }

	    /**
	     * Find User by Login
	     *
	     * @param login
	     *            : get parameter
	     * @return bean
	     * @throws DatabaseException
	     */

	    public UserBean findByLogin(String login) throws Exception {
	         StringBuffer sql = new StringBuffer(
	                "SELECT * FROM ST_USER WHERE LOGIN=?");
	        UserBean bean = null;
	        Connection conn = null;
	        System.out.println("sql" + sql);

	        try {
	            conn = JDBCDataSource.getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	            pstmt.setString(1, login);
	            ResultSet rs = pstmt.executeQuery();
	            while (rs.next()) {
	                bean = new UserBean();
	                bean.setId(rs.getLong(1));
	                bean.setFirstName(rs.getString(2));
	                bean.setLastName(rs.getString(3));
	                bean.setLogin(rs.getString(4));
	                bean.setPassword(rs.getString(5));
	                bean.setDob(rs.getDate(6));
	                bean.setMobileNo(rs.getLong(7));
	                bean.setRoleId(rs.getLong(8));
	                bean.setUnSuccessfulLogin(rs.getInt(9));
	                bean.setGender(rs.getString(10));
	                bean.setLastLogin(rs.getTimestamp(11));
	                bean.setLock(rs.getString(12));
	                bean.setRegisteredIP(rs.getString(13));
	                bean.setLastLoginIP(rs.getString(14));
	                bean.setCreatedBy(rs.getString(15));
	                bean.setModifiedBy(rs.getString(16));
	                bean.setCreatedDatetime(rs.getTimestamp(17));
	                bean.setModifiedDatetime(rs.getTimestamp(18));

	            }
	            rs.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	            throw new Exception(
	                    "Exception : Exception in getting User by login");
	        } finally {
	            JDBCDataSource.closeConnection(conn);
	        }
	        return bean;
	    }

	    /**
	     * Find User by PK
	     *
	     * @param pk
	     *            : get parameter
	     * @return bean
	     * @throws DatabaseException
	     */

	    public UserBean findByPK(long pk) throws Exception {
	        StringBuffer sql = new StringBuffer("SELECT * FROM ST_USER WHERE ID=?");
	        UserBean bean = null;
	        Connection conn = null;

	        try {
	            conn = JDBCDataSource.getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	            pstmt.setLong(1, pk);
	            ResultSet rs = pstmt.executeQuery();
	            while (rs.next()) {
	                bean = new UserBean();
	                bean.setId(rs.getLong(1));
	                bean.setFirstName(rs.getString(2));
	                bean.setLastName(rs.getString(3));
	                bean.setLogin(rs.getString(4));
	                bean.setPassword(rs.getString(5));
	                bean.setDob(rs.getDate(6));
	                bean.setMobileNo(rs.getLong(7));
	                bean.setRoleId(rs.getLong(8));
	                bean.setUnSuccessfulLogin(rs.getInt(9));
	                bean.setGender(rs.getString(10));
	                bean.setLastLogin(rs.getTimestamp(11));
	                bean.setLock(rs.getString(12));
	                bean.setRegisteredIP(rs.getString(13));
	                bean.setLastLoginIP(rs.getString(14));
	                bean.setCreatedBy(rs.getString(15));
	                bean.setModifiedBy(rs.getString(16));
	                bean.setCreatedDatetime(rs.getTimestamp(17));
	                bean.setModifiedDatetime(rs.getTimestamp(18));

	            }
	            rs.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	            throw new Exception(
	                    "Exception : Exception in getting User by pk");
	        } finally {
	            JDBCDataSource.closeConnection(conn);
	        }
	        return bean;
	    }

	    /**
	     * Update a user
	     *
	     * @param bean
	     * @throws DatabaseException
	     */

	    public void update(UserBean bean) throws Exception
	             {
	        Connection conn = null;

	        UserBean beanExist = findByLogin(bean.getLogin());
	        // Check if updated LoginId already exist
	        if (beanExist != null && !(beanExist.getId() == bean.getId())) {
	            throw new Exception("LoginId is already exist");
	        }

	        try {
	            conn = JDBCDataSource.getConnection();
	            conn.setAutoCommit(false); // Begin transaction
	            PreparedStatement pstmt = conn
	                    .prepareStatement("UPDATE ST_USER SET FIRST_NAME=?,LAST_NAME=?,LOGIN=?,PASSWORD=?,DOB=?,MOBILE_NO=?,ROLE_ID=?,UNSUCCESSFUL_LOGIN=?,GENDER=?,LAST_LOGIN=?,USER_LOCK=?,REGISTERED_IP=?,LAST_LOGIN_IP=?,CREATED_BY=?,MODIFIED_BY=?,CREATED_DATETIME=?,MODIFIED_DATETIME=? WHERE ID=?");
	            pstmt.setString(1, bean.getFirstName());
	            pstmt.setString(2, bean.getLastName());
	            pstmt.setString(3, bean.getLogin());
	            pstmt.setString(4, bean.getPassword());
	            pstmt.setDate(5, new java.sql.Date(bean.getDob().getTime()));
	            pstmt.setLong(6, bean.getMobileNo());
	            pstmt.setLong(7, bean.getRoleId());
	            pstmt.setInt(8, bean.getUnSuccessfulLogin());
	            pstmt.setString(9, bean.getGender());
	            pstmt.setTimestamp(10, bean.getLastLogin());
	            pstmt.setString(11, bean.getLock());
	            pstmt.setString(12, bean.getRegisteredIP());
	            pstmt.setString(13, bean.getLastLoginIP());
	            pstmt.setString(14, bean.getCreatedBy());
	            pstmt.setString(15, bean.getModifiedBy());
	            pstmt.setTimestamp(16, bean.getCreatedDatetime());
	            pstmt.setTimestamp(17, bean.getModifiedDatetime());
	            pstmt.setLong(18, bean.getId());
	            pstmt.executeUpdate();
	            conn.commit(); // End transaction
	            pstmt.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	            try {
	                conn.rollback();
	            } catch (Exception ex) {
	                throw new Exception(
	                        "Exception : Delete rollback exception "
	                                + ex.getMessage());
	            }
	            throw new Exception("Exception in updating User ");
	        } finally {
	            JDBCDataSource.closeConnection(conn);
	        }
	        
	    }

	    /**
	     * Search User
	     *
	     * @param bean
	     *            : Search Parameters
	     * @throws DatabaseException
	     */

	    public List search(UserBean bean) throws Exception {
	        return search(bean, 0, 0);
	    }

	    /**
	     * Search User with pagination
	     *
	     * @return list : List of Users
	     * @param bean
	     *            : Search Parameters
	     * @param pageNo
	     *            : Current Page No.
	     * @param pageSize
	     *            : Size of Page
	     *
	     * @throws DatabaseException
	     */

	    public List search(UserBean bean, int pageNo, int pageSize)
	            throws Exception {
	         StringBuffer sql = new StringBuffer("SELECT * FROM ST_USER WHERE 1=1");

	        if (bean != null) {
	            if (bean.getId() > 0) {
	                sql.append(" AND id = " + bean.getId());
	            }
	            if (bean.getFirstName() != null && bean.getFirstName().length() > 0) {
	                sql.append(" AND FIRST_NAME like '" + bean.getFirstName() + "%'");
	            }
	            if (bean.getLastName() != null && bean.getLastName().length() > 0) {
	                sql.append(" AND LAST_NAME like '" + bean.getLastName() + "%'");
	            }
	            if (bean.getLogin() != null && bean.getLogin().length() > 0) {
	                sql.append(" AND LOGIN like '" + bean.getLogin() + "%'");
	            }
	            if (bean.getPassword() != null && bean.getPassword().length() > 0) {
	                sql.append(" AND PASSWORD like '" + bean.getPassword() + "%'");
	            }
	            if (bean.getDob() != null && bean.getDob().getDate() > 0) {
	                sql.append(" AND DOB = " + bean.getGender());
	            }
	            if (bean.getMobileNo() != 0 && bean.getMobileNo() > 0) {
	                sql.append(" AND MOBILE_NO = " + bean.getMobileNo());
	            }
	            if (bean.getRoleId() > 0) {
	                sql.append(" AND ROLE_ID = " + bean.getRoleId());
	            }
	            if (bean.getUnSuccessfulLogin() > 0) {
	                sql.append(" AND UNSUCCESSFUL_LOGIN = "
	                        + bean.getUnSuccessfulLogin());
	            }
	            if (bean.getGender() != null && bean.getGender().length() > 0) {
	                sql.append(" AND GENDER like '" + bean.getGender() + "%'");
	            }
	            if (bean.getLastLogin() != null
	                    && bean.getLastLogin().getTime() > 0) {
	                sql.append(" AND LAST_LOGIN = " + bean.getLastLogin());
	            }
	            if (bean.getRegisteredIP() != null
	                    && bean.getRegisteredIP().length() > 0) {
	                sql.append(" AND REGISTERED_IP like '" + bean.getRegisteredIP()
	                        + "%'");
	            }
	            if (bean.getLastLoginIP() != null
	                    && bean.getLastLoginIP().length() > 0) {
	                sql.append(" AND LAST_LOGIN_IP like '" + bean.getLastLoginIP()
	                        + "%'");
	            }

	        }

	        // if page size is greater than zero then apply pagination
	        if (pageSize > 0) {
	            // Calculate start record index
	            pageNo = (pageNo - 1) * pageSize;

	            sql.append(" Limit " + pageNo + ", " + pageSize);
	            // sql.append(" limit " + pageNo + "," + pageSize);
	        }

	        System.out.println(sql);
	        ArrayList list = new ArrayList();
	        Connection conn = null;
	        try {
	            conn = JDBCDataSource.getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	            ResultSet rs = pstmt.executeQuery();
	            while (rs.next()) {
	                bean = new UserBean();
	                bean.setId(rs.getLong(1));
	                bean.setFirstName(rs.getString(2));
	                bean.setLastName(rs.getString(3));
	                bean.setLogin(rs.getString(4));
	                bean.setPassword(rs.getString(5));
	                bean.setDob(rs.getDate(6));
	                bean.setMobileNo(rs.getLong(7));
	                bean.setRoleId(rs.getLong(8));
	                bean.setUnSuccessfulLogin(rs.getInt(9));
	                bean.setGender(rs.getString(10));
	                bean.setLastLogin(rs.getTimestamp(11));
	                bean.setLock(rs.getString(12));
	                bean.setRegisteredIP(rs.getString(13));
	                bean.setLastLoginIP(rs.getString(14));
	                bean.setCreatedBy(rs.getString(15));
	                bean.setModifiedBy(rs.getString(16));
	                bean.setCreatedDatetime(rs.getTimestamp(17));
	                bean.setModifiedDatetime(rs.getTimestamp(18));

	                list.add(bean);
	            }
	            rs.close();
	        } catch (Exception e) {
	            throw new Exception(
	                    "Exception : Exception in search user");
	        } finally {
	            JDBCDataSource.closeConnection(conn);
	        }

	        return list;
	    }

	    /**
	     * Get List of User
	     *
	     * @return list : List of User
	     * @throws DatabaseException
	     */

	    public List list() throws Exception {
	        return list(0, 0);
	    }

	    /**
	     * Get List of User with pagination
	     *
	     * @return list : List of users
	     * @param pageNo
	     *            : Current Page No.
	     * @param pageSize
	     *            : Size of Page
	     * @throws DatabaseException
	     */

	    public List list(int pageNo, int pageSize) throws Exception {
	         ArrayList list = new ArrayList();
	        StringBuffer sql = new StringBuffer("select * from ST_USER");
	        // if page size is greater than zero then apply pagination
	        if (pageSize > 0) {
	            // Calculate start record index
	            pageNo = (pageNo - 1) * pageSize;
	            sql.append(" limit " + pageNo + "," + pageSize);
	        }

	        Connection conn = null;

	        try {
	            conn = JDBCDataSource.getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	            ResultSet rs = pstmt.executeQuery();
	            while (rs.next()) {
	                UserBean bean = new UserBean();
	                bean.setId(rs.getLong(1));
	                bean.setFirstName(rs.getString(2));
	                bean.setLastName(rs.getString(3));
	                bean.setLogin(rs.getString(4));
	                bean.setPassword(rs.getString(5));
	                bean.setDob(rs.getDate(6));
	                bean.setMobileNo(rs.getLong(7));
	                bean.setRoleId(rs.getLong(8));
	                bean.setUnSuccessfulLogin(rs.getInt(9));
	                bean.setGender(rs.getString(10));
	                bean.setLastLogin(rs.getTimestamp(11));
	                bean.setLock(rs.getString(12));
	                bean.setRegisteredIP(rs.getString(13));
	                bean.setLastLoginIP(rs.getString(14));
	                bean.setCreatedBy(rs.getString(15));
	                bean.setModifiedBy(rs.getString(16));
	                bean.setCreatedDatetime(rs.getTimestamp(17));
	                bean.setModifiedDatetime(rs.getTimestamp(18));

	                list.add(bean);
	            }
	            rs.close();
	        } catch (Exception e) {
	            throw new Exception(
	                    "Exception : Exception in getting list of users");
	        } finally {
	            JDBCDataSource.closeConnection(conn);
	        }

	         return list;

	    }

	    /**
	     * @param id
	     *            : long id
	     * @param old
	     *            password : String oldPassword
	     * @param new password : String newPassword
	     * @throws DatabaseException
	     */

	    public UserBean authenticate(String login, String password)
	            throws Exception {
	        
	        StringBuffer sql = new StringBuffer(
	                "SELECT * FROM ST_USER WHERE LOGIN = ? AND PASSWORD = ?");
	        UserBean bean = null;
	        Connection conn = null;

	        try {
	            conn = JDBCDataSource.getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	            pstmt.setString(1, login);
	            pstmt.setString(2, password);
	            ResultSet rs = pstmt.executeQuery();
	            while (rs.next()) {
	                bean = new UserBean();
	                bean.setId(rs.getLong(1));
	                bean.setFirstName(rs.getString(2));
	                bean.setLastName(rs.getString(3));
	                bean.setLogin(rs.getString(4));
	                bean.setPassword(rs.getString(5));
	                bean.setDob(rs.getDate(6));
	                bean.setMobileNo(rs.getLong(7));
	                bean.setRoleId(rs.getLong(8));
	                bean.setUnSuccessfulLogin(rs.getInt(9));
	                bean.setGender(rs.getString(10));
	                bean.setLastLogin(rs.getTimestamp(11));
	                bean.setLock(rs.getString(12));
	                bean.setRegisteredIP(rs.getString(13));
	                bean.setLastLoginIP(rs.getString(14));
	                bean.setCreatedBy(rs.getString(15));
	                bean.setModifiedBy(rs.getString(16));
	                bean.setCreatedDatetime(rs.getTimestamp(17));
	                bean.setModifiedDatetime(rs.getTimestamp(18));

	            }
	        } catch (Exception e) {
	            throw new Exception("Exception : Exception in get roles");

	        } finally {
	            JDBCDataSource.closeConnection(conn);
	        }

	        return bean;
	    }

	    /**
	     * Lock User for certain time duration
	     *
	     * @return boolean : true if success otherwise false
	     * @param login
	     *            : User Login
	     * @throws ApplicationException
	     * @throws RecordNotFoundException
	     *             : if user not found
	     */

	    public boolean lock(String login) throws Exception {
	        boolean flag = false;
	        UserBean beanExist = null;
	        try {
	            beanExist = findByLogin(login);
	            if (beanExist != null) {
	                beanExist.setLock(UserBean.ACTIVE);
	                update(beanExist);
	                flag = true;
	            } else {
	                throw new Exception("LoginId not exist");
	            }
	        } catch (Exception e) {
	            throw new Exception("Database Exception");
	        }
	         return flag;
	    }

	    /**
	     * Get User Roles
	     *
	     * @return List : User Role List
	     * @param bean
	     * @throws ApplicationException
	     */

	    public List getRoles(UserBean bean) throws Exception {
	        StringBuffer sql = new StringBuffer(
	                "SELECT * FROM ST_USER WHERE role_Id=?");
	        Connection conn = null;
	        List list = new ArrayList();
	        try {

	            conn = JDBCDataSource.getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	            pstmt.setLong(1, bean.getRoleId());
	            ResultSet rs = pstmt.executeQuery();
	            while (rs.next()) {
	                bean = new UserBean();
	                bean.setId(rs.getLong(1));
	                bean.setFirstName(rs.getString(2));
	                bean.setLastName(rs.getString(3));
	                bean.setLogin(rs.getString(4));
	                bean.setPassword(rs.getString(5));
	                bean.setDob(rs.getDate(6));
	                bean.setMobileNo(rs.getLong(7));
	                bean.setRoleId(rs.getLong(8));
	                bean.setUnSuccessfulLogin(rs.getInt(9));
	                bean.setGender(rs.getString(10));
	                bean.setLastLogin(rs.getTimestamp(11));
	                bean.setLock(rs.getString(12));
	                bean.setRegisteredIP(rs.getString(13));
	                bean.setLastLoginIP(rs.getString(14));
	                bean.setCreatedBy(rs.getString(15));
	                bean.setModifiedBy(rs.getString(16));
	                bean.setCreatedDatetime(rs.getTimestamp(17));
	                bean.setModifiedDatetime(rs.getTimestamp(18));

	                list.add(bean);
	            }
	            rs.close();
	        } catch (Exception e) {
	            throw new Exception("Exception : Exception in get roles");

	        } finally {
	            JDBCDataSource.closeConnection(conn);
	        }
	        return list;
	    }

	    /**
	     * @param i
	     *            : long id
	     * @param old
	     *            password : String oldPassword
	     * @param newpassword
	     *            : String newPassword
	     * @throws DatabaseException
	     */

	    public boolean changePassword(long i, String oldPassword,
	            String newPassword) throws Exception {

	        boolean flag = false;
	        UserBean beanExist = null;

	        beanExist = findByPK(i);
	        if (beanExist != null && beanExist.getPassword().equals(oldPassword)) {
	            beanExist.setPassword(newPassword);
	            try {
	                update(beanExist);
	            } catch (Exception e) {
	                e.printStackTrace();
	                throw new Exception("LoginId is already exist");
	            }
	            flag = true;
	        } else {
	            throw new Exception("Login not exist");
	        }

	        HashMap<String, String> map = new HashMap<String, String>();

	        map.put("login", beanExist.getLogin());
	        map.put("password", beanExist.getPassword());
	        map.put("First Name", beanExist.getFirstName());
	        map.put("lastName",beanExist. getLastName());

	        String message = EmailBuilder.getChangePasswordMessage(map);

	        EmailMessage msg = new EmailMessage();

	        msg.setTo(beanExist.getLogin());
	        msg.setMessage("SUNARYS ORS Password has been changed Successfully.");
	        msg.setMessage(message);
	        msg.setMessageType(EmailMessage.HTML_MSG);

	        EmailUtility.sendMail(msg);

	        return flag;

	    }

	    public UserBean updateAccess(UserBean bean) throws Exception {
	        return null;
	    }

	    public long registerUser(UserBean bean) throws Exception {

	        
	        long pk = add(bean);

	        HashMap<String, String> map = new HashMap<String, String>();
	        map.put("login", bean.getLogin());
	        map.put("password",  bean.getPassword());
	        String message = EmailBuilder.getUserRegistrationMessage(map);
	        EmailMessage msg = new EmailMessage();
	        msg.setTo(bean.getLogin());
	        msg.setSubject("Registration is successful for ORS Project SunilOS");
	        msg.setMessage(message);
	        msg.setMessageType(EmailMessage.HTML_MSG);

	       
	        return pk;
	    }

	    /**
	     * Reset Password of User with auto generated Password
	     *
	     * @return boolean : true if success otherwise false
	     * @param login
	     *            : User Login
	     * @throws ApplicationException
	     * @throws RecordNotFoundException
	     *             : if user not found
	     */

}
