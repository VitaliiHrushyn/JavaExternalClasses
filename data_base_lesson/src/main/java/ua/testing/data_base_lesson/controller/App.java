package ua.testing.data_base_lesson.controller;

import ua.testing.data_base_lesson.model.dao.DAOFactory;
import ua.testing.data_base_lesson.model.dao.GenericDAO;
import ua.testing.data_base_lesson.model.entity.Car;

public class App {
	
	    public static void main( String[] args )throws Exception {
	    	
	        DAOFactory factory = DAOFactory.getInstance();
	        GenericDAO<Car> dao = factory.createCarDAO();

	        System.out.println(dao.getAll());



	        /*Connection con =
	                DriverManager.
	                        getConnection(  "jdbc:"+
	                                        "mysql:"+
	                                        "//localhost:3306/"+
	                                        //"world" ,
	                                        "mycardb",
	                                "root" ,
	                                "root");

	        Statement query = con.createStatement();
	        //ResultSet rs = query.executeQuery("SELECT * FROM city");
	        ResultSet rs = query.executeQuery("SELECT * FROM car");
	        while( rs.next()) {
	            System.out.println(rs.getString("model"));}*/
	/*

	#SELECT * FROM manufacturer JOIN shop ON
	                        manufacturer.idmanufacturer = shop.idmanufacturer
	#SELECT * FROM manufacturer LEFT join shop ON
	                        manufacturer.idmanufacturer = shop.idmanufacturer
	#SELECT * FROM shop right join manufacturer ON
	                        manufacturer.idmanufacturer = shop.idmanufacturer
	#SELECT * FROM manufacturer right join shop ON
	                        manufacturer.idmanufacturer = shop.idmanufacturer

	#SELECT * FROM mycardb.car;
	#SELECT * FROM manufacturer JOIN car using (idmanufacturer)
	#SELECT * FROM manufacturer LEFT join car using (idmanufacturer)
	#SELECT * FROM manufacturer LEFT join car using (idmanufacturer) where manufacture = "BMV"
	#SELECT * FROM car right join manufacturer using (idmanufacturer)
	#SELECT * FROM manufacturer right join car using (idmanufacturer)

	*/
	        }
	    


}
