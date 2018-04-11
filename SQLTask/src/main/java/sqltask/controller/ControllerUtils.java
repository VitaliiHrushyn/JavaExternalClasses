package sqltask.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ControllerUtils {
	
	private static final String DATA_BASE_URL = "jdbc:mysql://localhost/"
			+ "carsanddrivers" /*Data Base name*/
				+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	
	private static final String SCHEMA_NAME = "`carsanddrivers1`";
	
	private static final String CREATE_SCHEMA = "CREATE SCHEMA "+SCHEMA_NAME+" DEFAULT CHARACTER SET utf8;";
	
	private static final String CREATE_TABLE_CARS = "CREATE TABLE "+SCHEMA_NAME+".`cars` ("
													+ "  `carid` INT NOT NULL,"
													+ "  `model` VARCHAR(45) NULL,"
													+ "  `manufacturer` VARCHAR(45) NULL,"
													+ "  PRIMARY KEY (`carid`))";
												//	+ "  UNIQUE INDEX `carid_UNIQUE` (`carid` ASC));";
	private static final String CREATE_TABLE_DRIVERS = "CREATE TABLE "+SCHEMA_NAME+".`drivers` ("
														+ " `driverid` INT NOT NULL,"
														+ " `name` VARCHAR(45) NULL,"
														+ "  `phonenumber` VARCHAR(45) NULL,"
														+ " PRIMARY KEY (`driverid`))";
												//		+ " UNIQUE INDEX `driverid_UNIQUE` (`driverid` ASC));";
	private static final String CREATE_TABLE_CARSDRIVERS = "CREATE TABLE "+SCHEMA_NAME+".`cardriver` ("
															+ " `carid` INT NOT NULL,"
															+ " `driverid` INT NOT NULL,"
															+ " PRIMARY KEY (`carid`, `driverid`));";
	private static final String DROP_SCHEMA = "DROP DATABASE "+SCHEMA_NAME+";";
//	private static final String FILL_CARS_TABLE = "INSERT INTO cars (carid, model, manufacturer) values (?, ?, ?);";
//	private static final String FILL_DRIVERS_TABLE = "INSERT INTO drivers (driverid, name, phonenumber) values (1, 'Mike', '35622167');"
//												+ "INSERT INTO drivers (driverid, name, phonenumber) values (2, 'John', '55600203');"
//												+ "INSERT INTO drivers (driverid, name, phonenumber) values (3, 'Feel', '28713066');"
//												+ "INSERT INTO drivers (driverid, name, phonenumber) values (4, 'Hugh', '56024581');"
//												+ "INSERT INTO drivers (driverid, name, phonenumber) values (5, 'Tony', '56211748');";
//	private static final String FILL_CARDRIVER_TABLE = "INSERT INTO cardriver (carid, driverid) values (1, 1);"
//													+ "INSERT INTO cardriver (carid, driverid) values (1, 3);"
//													+ "INSERT INTO cardriver (carid, driverid) values (1, 5);"
//													+ "INSERT INTO cardriver (carid, driverid) values (2, 1);"
//													+ "INSERT INTO cardriver (carid, driverid) values (2, 2);"
//													+ "INSERT INTO cardriver (carid, driverid) values (2, 3);"
//													+ "INSERT INTO cardriver (carid, driverid) values (3, 5);"
//													+ "INSERT INTO cardriver (carid, driverid) values (3, 4);"
//													+ "INSERT INTO cardriver (carid, driverid) values (3, 3);"
//													+ "INSERT INTO cardriver (carid, driverid) values (4, 1);"
//													+ "INSERT INTO cardriver (carid, driverid) values (4, 3);"
//													+ "INSERT INTO cardriver (carid, driverid) values (4, 5);"
//													+ "INSERT INTO cardriver (carid, driverid) values (4, 2);"
//													+ "INSERT INTO cardriver (carid, driverid) values (5, 1);"
//													+ "INSERT INTO cardriver (carid, driverid) values (5, 2);"
//													+ "INSERT INTO cardriver (carid, driverid) values (5, 4);";
	private static final String GET_ALL_DRIVERS_BY_CAR_QUERY = "";
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DATA_BASE_URL, USER, PASSWORD);
	}
	
	private static void createSchema(Connection connection) {
		try(Statement statement = connection.createStatement()) {
			statement.addBatch(CREATE_SCHEMA);
			statement.executeBatch();	
			statement.clearBatch();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void fillSchemaWithTables(Connection connection) throws SQLException {
		try(Statement statement = connection.createStatement()) {
			statement.execute(CREATE_TABLE_CARS);
			statement.execute(CREATE_TABLE_DRIVERS);
			statement.execute(CREATE_TABLE_CARSDRIVERS);
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void fillTables(Connection connection) throws SQLException {
		try(Statement statement = connection.createStatement()) {
			statement.execute("INSERT INTO cars (carid, model, manufacturer) values (11, 'GTR', 'Nissan');");
			statement.execute("INSERT INTO cars (carid, model, manufacturer) values (12, 'CLK', 'Mercedes');");
			statement.execute("INSERT INTO cars (carid, model, manufacturer) values (13, 'Elise', 'Lotus');");
			statement.execute("INSERT INTO cars (carid, model, manufacturer) values (14, 'Veyron', 'Bugatti');");
			statement.execute("INSERT INTO cars (carid, model, manufacturer) values (15, '911 turbo', 'Porsche');");
			statement.execute("INSERT INTO drivers (driverid, name, phonenumber) values (21, 'Mike', '35622167');");
			statement.execute("INSERT INTO drivers (driverid, name, phonenumber) values (22, 'John', '55600203');");
			statement.execute("INSERT INTO drivers (driverid, name, phonenumber) values (23, 'Feel', '28713066');");
			statement.execute("INSERT INTO drivers (driverid, name, phonenumber) values (24, 'Hugh', '56024581');");
			statement.execute("INSERT INTO drivers (driverid, name, phonenumber) values (25, 'Tony', '56211748');");
			statement.execute("INSERT INTO cardriver (carid, driverid) values (11, 21);");
			statement.execute("INSERT INTO cardriver (carid, driverid) values (11, 23);");
			statement.execute("INSERT INTO cardriver (carid, driverid) values (11, 25);");
			statement.execute("INSERT INTO cardriver (carid, driverid) values (12, 21);");
			statement.execute("INSERT INTO cardriver (carid, driverid) values (12, 22);");
			statement.execute("INSERT INTO cardriver (carid, driverid) values (12, 23);");
			statement.execute("INSERT INTO cardriver (carid, driverid) values (13, 25);");
			statement.execute("INSERT INTO cardriver (carid, driverid) values (13, 24);");
			statement.execute("INSERT INTO cardriver (carid, driverid) values (13, 23);");
			statement.execute("INSERT INTO cardriver (carid, driverid) values (14, 21);");
			statement.execute("INSERT INTO cardriver (carid, driverid) values (14, 23);");
			statement.execute("INSERT INTO cardriver (carid, driverid) values (14, 25);");
			statement.execute("INSERT INTO cardriver (carid, driverid) values (14, 22);");
			statement.execute("INSERT INTO cardriver (carid, driverid) values (15, 21);");
			statement.execute("INSERT INTO cardriver (carid, driverid) values (15, 22);");
			statement.execute("INSERT INTO cardriver (carid, driverid) values (15, 24);");
			
//			statement.executeBatch();
//			statement.clearBatch();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void prepareSchema(Connection connection) throws SQLException {
		createSchema(connection);
		fillSchemaWithTables(connection);
		fillTables(connection);
	}
	
	public static void dropSchema(Connection connection) throws SQLException {
		try(Statement statement = connection.createStatement()) {
			statement.execute(DROP_SCHEMA);
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
//	
//     Statement query = connection.createStatement();
//     ResultSet rs = query.executeQuery("SELECT * FROM city");
//     while( rs.next()){
//         System.out.println(rs.getString("Name"));
//     }

}
