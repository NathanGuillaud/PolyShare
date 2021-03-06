package persistent.mySQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.classesApp.Student;
import database.BdConnection;
import persistent.DAO.StudentDAO;

/**
 * <b>Student</b> is a user who is register
 */
public class StudentDAOMySQL extends StudentDAO {

    /**
     * Default constructor
     */
    public StudentDAOMySQL(Connection conn) {
    	super(conn);
    }
    
    public Student login(String id, String password) {
		Student student = new Student(0, null, null, null, null, null);
		
		try {
		   ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM Student WHERE emailStudent = '" + id + "' AND password = '" + password + "'");
		   if(result.next()) {
			   student = new Student(
			    	result.getInt("idStudent"),
			        result.getString("nameStudent"),
			        result.getString("firstNameStudent"),
			        result.getString("emailStudent"),
			        result.getString("password"),
			        result.getString("loginID"));
			   return student;
		   } else { 
			   return null;
		   }
		 } catch (SQLException e) {
			 e.printStackTrace();
		 }
		 return null;
	}
    
    public Student findById(int id) {
  	  Student student = new Student(0, null, null, null, null, null);      
  	    
  	  try {
  	    ResultSet result = this.connect.createStatement(
  	    ResultSet.TYPE_SCROLL_INSENSITIVE,
  	    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Student WHERE idStudent = " + id);
  	    if(result.first())
  	      student = new Student(
  	    		id,
  	        result.getString("nameStudent"),
  	        result.getString("firstNameStudent"),
  	        result.getString("emailStudent"),
  	        result.getString("password"),
  	        result.getString("loginID"));         
  	  } catch (SQLException e) {
  	    e.printStackTrace();
  	  }
  	  return student;
  	}
    
    public boolean update(Student obj) {
		try {
			this.connect.createStatement(
			ResultSet.TYPE_SCROLL_INSENSITIVE,
			ResultSet.CONCUR_READ_ONLY).executeUpdate("UPDATE Student SET nameStudent = '" + obj.getNameStudent() + "', firstNameStudent = '" + obj.getFirstNameStudent() + "', emailStudent = '" + obj.getEmailStudent() + "', password = '" + obj.getPasswordStudent() + "', loginID = '" + obj.getLoginID() + "' WHERE idStudent = '" + obj.getId() + "'");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
    
    public Student findByName(String name) {
		Student student = new Student(0, null, null, null, null, null);
		
	    try {
		    ResultSet result = this.connect.createStatement(
		    ResultSet.TYPE_SCROLL_INSENSITIVE,
		    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Student WHERE nameStudent = " + name);
		    if(result.first())
		      student = new Student(
		    		result.getInt("id"),
		        name,
		        result.getString("firstNameStudent"),
		        result.getString("emailStudent"),
		        result.getString("password"),
		        result.getString("loginID"));         
		  } catch (SQLException e) {
		    e.printStackTrace();
		  }
		  return student;
	}
	
	public void createStudent(Student obj) {
		try {
			this.connect.createStatement(
			ResultSet.TYPE_SCROLL_INSENSITIVE,
			ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO Student VALUES (NULL,'" + obj.getNameStudent() + "','" + obj.getFirstNameStudent() + "','" + obj.getEmailStudent() + "','" + obj.getPasswordStudent() + "','" + obj.getLoginID() + "')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean delete(Student obj) {
		try {
			this.connect.createStatement(
			ResultSet.TYPE_SCROLL_INSENSITIVE,
			ResultSet.CONCUR_READ_ONLY).executeUpdate("DELETE FROM Student WHERE idStudent = '" + obj.getId() + "'");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean verifyCredentials(String login, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateStudent(Student sCo) {
		BdConnection.request("UPDATE Student SET "
				+ "nameStudent= \'" + sCo.nameStudent 
				+ "\', firstNameStudent=\'" + sCo.getFirstNameStudent()
				+ "\',emailStudent= \'" + sCo.getEmailStudent()
				+ "\',password=\'" + sCo.getPasswordStudent()
				+ "\',loginID=\'" + sCo.getLoginID() 
				+ "\' WHERE idStudent = " + sCo.getId());
	}

	@Override
	public void recommandStudent(Student s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void signalizeStudent(Student s) {
		// TODO Auto-generated method stub
		
	}

}