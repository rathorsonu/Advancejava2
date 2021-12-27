package in.co.sunrays.model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import in.co.sunrays.bean.DropdownListBean;
import in.co.sunrays.exception.ApplicationException;
import in.co.sunrays.exception.DatabaseException;
import in.co.sunrays.util.DataUtility;
import in.co.sunrays.util.JDBCDataSource;

public abstract  class BaseModel  implements Serializable, DropdownListBean,
	Comparable<BaseModel>{

	    protected long id;
		protected String createdBy;
	    protected String modifiedBy;
	    protected Timestamp createdDatetime;
	    protected Timestamp modifiedDatetime;
			public long getId() {
				return id;
		    }

		    public void setId(long id) {
		        this.id = id;
		    }

		    public Timestamp getCreatedDatetime() {
		        return createdDatetime;
		    }

		    public void setCreatedDatetime(Timestamp createdDatetime) {
		        this.createdDatetime = createdDatetime;
		    }

		    public Timestamp getModifiedDatetime() {
		        return modifiedDatetime;
		    }

		    public void setModifiedDatetime(Timestamp modifiedDatetime) {
		        this.modifiedDatetime = modifiedDatetime;
		    }

		    public String getCreatedBy() {
		        return createdBy;
		    }

		    public void setCreatedBy(String createdBy) {
		        this.createdBy = createdBy;
		    }

		    public String getModifiedBy() {
		        return modifiedBy;
		    }

		    public void setModifiedBy(String modifiedBy) {
		        this.modifiedBy = modifiedBy;
		    }

		     public int compareTo(BaseModel next) {
		        return (int) (id - next.getId());
		    }

		   
		    public long nextPK() throws Exception {
		    	Class.forName("com.mysql.jdbc.Driver");
		        Connection conn = null;
		        long pk = 0;
		        try {
		            conn = JDBCDataSource.getConnection();
		            PreparedStatement pstmt = conn
		                    .prepareStatement("SELECT MAX(ID) FROM " + getTableName());
		            ResultSet rs = pstmt.executeQuery();
		            while (rs.next()) {
		                pk = rs.getInt(1);
		            }
		            rs.close();
		        } catch (Exception e) {
		        	e.printStackTrace();
		            throw new DatabaseException("Exception : Exception in getting PK");
		        } finally {
		            JDBCDataSource.closeConnection(conn);
		        }
		        
		        return pk + 1;
		    }

		    public abstract String getTableName();
	 public void updateCreatedInfo() throws Exception {

		    	Class.forName("com.mysql.jdbc.Driver");

		        Connection conn = null;

		        String sql = "UPDATE " + getTableName()
		                + " SET CREATED_BY=?, CREATED_DATETIME=? WHERE ID=?";
		        

		        try {
		            conn = JDBCDataSource.getConnection();
		            conn.setAutoCommit(false); // Begin transaction
		            PreparedStatement pstmt = conn.prepareStatement(sql);
		            pstmt.setString(1, createdBy);
		            pstmt.setTimestamp(2, DataUtility.getCurrentTimestamp());
		            pstmt.setLong(3, id);

		            pstmt.executeUpdate();
		            conn.commit(); // End transaction
		            pstmt.close();
		        } catch (SQLException e) {
		        	e.printStackTrace();
		            JDBCDataSource.trnRollback(conn);
		            throw new ApplicationException(e.toString());
		        } catch (Exception e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        } finally {
		            JDBCDataSource.closeConnection(conn);
		        }
		        
		    }

		    /**
		     * Updates modified by info
		     *
		     * @param model
		     * @throws Exception
		     */
		    public void updateModifiedInfo() throws Exception {

		    	Class.forName("com.mysql.jdbc.Driver");
		        Connection conn = null;

		        String sql = "UPDATE " + getTableName()
		                + " SET MODIFIED_BY=?, MODIFIED_DATETIME=? WHERE ID=?";

		        try {
		            conn = JDBCDataSource.getConnection();
		            conn.setAutoCommit(false); // Begin transaction
		            PreparedStatement pstmt = conn.prepareStatement(sql);
		            pstmt.setString(1, modifiedBy);
		            pstmt.setTimestamp(2, DataUtility.getCurrentTimestamp());
		            pstmt.setLong(3, id);
		            pstmt.executeUpdate();
		            conn.commit(); // End transaction
		            pstmt.close();
		        } catch (SQLException e) {
		        	e.printStackTrace();
		            JDBCDataSource.trnRollback(conn);
		        } finally {
		            JDBCDataSource.closeConnection(conn);
		        }
		      
		    }

		    /**
		     * Populate Model from ResultSet
		     *
		     * @param model
		     * @param rs
		     * @return
		     */
		    protected <T extends BaseModel> T populateModel(T model, ResultSet rs)
		            throws SQLException {
		        model.setId(rs.getLong("ID"));
		        model.setCreatedBy(rs.getString("CREATED_BY"));
		        model.setModifiedBy(rs.getString("MODIFIED_BY"));
		        model.setCreatedDatetime(rs.getTimestamp("CREATED_DATETIME"));
		        model.setModifiedDatetime(rs.getTimestamp("MODIFIED_DATETIME"));
		        return model;
		    }
		
	}


