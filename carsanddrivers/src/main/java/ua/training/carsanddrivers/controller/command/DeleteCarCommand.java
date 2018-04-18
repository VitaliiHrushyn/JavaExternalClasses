package ua.training.carsanddrivers.controller.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import ua.training.carsanddrivers.model.services.DeleteCarService;

public class DeleteCarCommand implements Command {

	@Override
	public String execute(HttpServletRequest request)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		
		int carId = Integer.valueOf(request.getParameter("carid"));
		System.out.println("delete car id: " + carId);
		new DeleteCarService().deleteCar(carId);

		return "/app/showcars";
	}

}
