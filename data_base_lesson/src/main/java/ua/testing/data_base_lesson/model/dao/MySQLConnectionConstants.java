package ua.testing.data_base_lesson.model.dao;

public interface MySQLConnectionConstants {
	
	String MYSQL_CONNECTION_URL = "jdbc:mysql://localhost/daodb"
			+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";	
	String MYSQL_CONNECTION_USERNAME = "root";
	String MYSQL_CONNECTION_PASSWORD = "root";
	String MYSQL_DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

}
