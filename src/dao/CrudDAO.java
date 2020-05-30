package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.User;
import utility.ConnectionManager;

public class CrudDAO implements CrudDaoInterface{

	private Connection connection = ConnectionManager.getConnection();
	private Statement statement;
	private PreparedStatement preparedStatement;
	
	//DDL COMMANDS
	public void create() throws SQLException {
	  String sql = "CREATE TABLE USERSDATA(NAME VARCHAR(100) NOT NULL,EMAIL VARCHAR(100) PRIMARY KEY,PHONENUMBER INT UNIQUE NOT NULL,ROLE VARCHAR(60) NOT NULL,PASSWORD VARCHAR(40) NOT NULL)";
	   if(connection!=null) {
		   statement = connection.createStatement();
		   int status = statement.executeUpdate(sql);
		   System.out.println(status);  
	   }
	   else
		   System.out.println("not connected");
	   connection.close();
	}

	//DML COMMANDS
    public void insert(User user) throws SQLException {
	  if(connection!=null) {
		  preparedStatement = connection.prepareStatement("INSERT INTO USERSDATA VALUES(?,?,?,?,?)");
		  preparedStatement.setString(1,user.getName());
		  preparedStatement.setString(2,user.getEmail());
		  preparedStatement.setString(3,user.getPhoneNumber());
		  preparedStatement.setString(4,user.getRole());
		  preparedStatement.setString(5,user.getPassword()); 
		  preparedStatement.executeUpdate();
	  }
	  else
		  System.out.println("not connected");
    		
	}
    	
	public void update(User user) throws SQLException  {
		String sql = "UPDATE USERSDATA SET NAME = "+user.getName()+"WHERE EMAIL = "+user.getEmail();
		if(connection!=null) {
			   statement = connection.createStatement();
			   statement.executeUpdate(sql);
			   System.out.println("updated");  
		   }
		   else
			   System.out.println("not connected");
		   connection.close();
	}

	public void delete(User user) throws SQLException  {		
		String sql = "DELETE FROM USERSDATA WHERE EMAIL = "+user.getEmail();
		if(connection!=null) {
			   statement = connection.createStatement();
			   statement.executeUpdate(sql);
			   System.out.println("deleted");  
		   }
		   else
			   System.out.println("not connected");
		   connection.close();
	}

	
	//SELECT -DQL
	public void getData() throws SQLException {		
	  String sql = "SELECT * FROM USERSDATA";
	  if(connection!=null) {
		  statement = connection.createStatement();
		  ResultSet rs = statement.executeQuery(sql);
		  while(rs.next()) {
			  System.out.println(rs.getString("email")+" "+rs.getString("password"));
		  }
		  
		  
	  }else
		  System.out.println("not connected");
	}


	
	

}
