package ua.training.carsanddrivers.controller.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import ua.training.carsanddrivers.model.services.CreateCarService;

public class CreateCarCommand implements Command {

	@Override
	public String execute(HttpServletRequest request)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		
		String name = request.getParameter("model");
		String number = request.getParameter("number");
		new CreateCarService().create(name, number);

		return "redirect:/app/showcars";
	}

}
