package ua.training.carsanddrivers.controller.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import ua.training.carsanddrivers.model.services.DeleteDriverService;

public class DeleteDriverCommand implements Command {

	@Override
	public String execute(HttpServletRequest request)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		
		int driverId = Integer.valueOf(request.getParameter("driverid"));
		new DeleteDriverService().delete(driverId);

		return "redirect:/app/showdrivers";
	}

}
