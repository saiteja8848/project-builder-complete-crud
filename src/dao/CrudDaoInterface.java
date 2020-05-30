package dao;

import java.sql.SQLException;

import model.User;

public interface CrudDaoInterface {
   
	//DDL COMMANDS CREATING, DROPING,ALTERING TABLE COMMANDS, RELATED TO TABLE CREATING
	public void create() throws SQLException;
	
	//DML COMMANDS , LIKE INSERTING, UPDATING,DELETING ROWS RELATED TO DATA
	public void insert(User user) throws SQLException;
	public void update(User user) throws SQLException;
	public void delete(User user) throws SQLException;
	
	
	//DQL COMMANDS SELECT
	public void getData() throws SQLException;
}
