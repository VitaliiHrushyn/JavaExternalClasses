package ua.training.carsanddrivers.controller;

import ua.training.carsanddrivers.model.dao.DAOFactory;
import ua.training.carsanddrivers.model.dao.impl.AbstractDAO;
import ua.training.carsanddrivers.model.entity.Car;
import ua.training.carsanddrivers.model.entity.Driver;

public class App {
	
	    public static void main( String[] args )throws Exception {
	    	
	        DAOFactory factory = DAOFactory.getInstance();
	        AbstractDAO<Car> carDAO = factory.createCarDAO();
	        AbstractDAO<Driver> driverDAO = factory.createDriverDAO();

	        System.out.println(carDAO.getAll(true));
	        System.out.println(driverDAO.getAll(true));



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
