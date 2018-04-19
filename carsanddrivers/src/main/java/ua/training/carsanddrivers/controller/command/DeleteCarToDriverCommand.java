package ua.training.carsanddrivers.controller.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import ua.training.carsanddrivers.model.services.CarToDriverService;
import ua.training.carsanddrivers.model.services.OneDriverService;
import ua.training.carsanddrivers.model.services.ShowCarsService;

public class DeleteCarToDriverCommand implements Command {

	@Override
	public String execute(HttpServletRequest request)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		
		int driverId = Integer.valueOf(request.getParameter("driverid"));
		int carId = Integer.valueOf(request.getParameter("carid"));
		new CarToDriverService().deleteCarToDriver(carId, driverId);
		
		request.setAttribute("driver", new OneDriverService().getDriverById(driverId));
		request.setAttribute("allCars", new ShowCarsService().getCars());

		return "/editdriver.jsp";
	}

}
