package ua.training.carsanddrivers.controller.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import ua.training.carsanddrivers.model.services.EditDriverService;
import ua.training.carsanddrivers.model.services.OneDriverService;
import ua.training.carsanddrivers.model.services.ShowCarsService;

public class EditDriverCommand implements Command {

	@Override
	public String execute(HttpServletRequest request)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		
		int driverId = Integer.valueOf(request.getParameter("driverid"));
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		new EditDriverService().edit(driverId, name, phone);
		
		request.setAttribute("driver", new OneDriverService().getDriverById(driverId));
		request.setAttribute("allCars", new ShowCarsService().getCars());

		return "/editdriver.jsp";
	}

}
