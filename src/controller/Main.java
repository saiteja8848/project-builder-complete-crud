package controller;

import java.sql.SQLException;

import dao.CrudDAO;
import dao.CrudDaoInterface;
import model.User;

public class Main {

	public static void main(String args[]) throws SQLException {

		User user = new User();
		user.setName("saiteja");
		user.setEmail("saiteja8848@gmail.com");
        user.setPhoneNumber("7989027489");
        user.setRole("admin");
        user.setPassword("Saite548@");
		
		CrudDaoInterface crudOperations = new CrudDAO();
		//crudOperations.create();
		crudOperations.insert(user);
		crudOperations.getData();
		
		
	}
}
