package ua.training.carsanddrivers.model.dao;

public interface ConnectionConstants {
	
	String MYSQL_CONNECTION_URL = "jdbc:mysql://localhost/cars_and_drivers"
			+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";	
	String MYSQL_CONNECTION_USERNAME = "root";
	String MYSQL_CONNECTION_PASSWORD = "root";
	String MYSQL_DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

}
