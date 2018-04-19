package ua.training.carsanddrivers.controller.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import ua.training.carsanddrivers.model.services.ShowDriversService;

public class ShowDriversCommand implements Command {

	@Override
	public String execute(HttpServletRequest request)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		
		request.setAttribute("drivers", new ShowDriversService().getDrivers());
	
		return "/drivers.jsp";
	}

}
