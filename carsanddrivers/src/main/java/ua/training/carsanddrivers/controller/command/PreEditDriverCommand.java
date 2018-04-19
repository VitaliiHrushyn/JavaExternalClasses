package ua.training.carsanddrivers.controller.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import ua.training.carsanddrivers.model.entity.Driver;
import ua.training.carsanddrivers.model.services.OneDriverService;
import ua.training.carsanddrivers.model.services.ShowCarsService;

public class PreEditDriverCommand implements Command {

	@Override
	public String execute(HttpServletRequest request)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		
		int id = Integer.valueOf(request.getParameter("driverid"));
		Driver driver = new OneDriverService().getDriverById(id);
		
		request.setAttribute("driver", driver);
		request.setAttribute("allCars", new ShowCarsService().getCars());

		return "/editdriver.jsp";
	}

}
