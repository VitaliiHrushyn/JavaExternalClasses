package sqltask.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainController {
	
	
	
	

	public static void main(String[] args) throws SQLException {
		
		try(Connection connection = ControllerUtils.getConnection()) {
	//		ControllerUtils.dropSchema(connection);
			
			ControllerUtils.prepareSchema(connection);
			
		}
		

		

	}

}
