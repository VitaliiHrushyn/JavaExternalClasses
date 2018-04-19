package ua.training.carsanddrivers.controller.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import ua.training.carsanddrivers.model.services.EditCarService;

public class EditCarCommand implements Command {

	@Override
	public String execute(HttpServletRequest request)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		
		int carId = Integer.valueOf(request.getParameter("carid"));
		String name = request.getParameter("model");
		String number = request.getParameter("number");
		new EditCarService().edit(carId, name, number);

		return "redirect:/app/showcars";
	}

}
