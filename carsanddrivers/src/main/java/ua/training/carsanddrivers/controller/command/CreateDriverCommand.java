package ua.training.carsanddrivers.controller.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import ua.training.carsanddrivers.model.services.CreateDriverService;

public class CreateDriverCommand implements Command {

	@Override
	public String execute(HttpServletRequest request)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		new CreateDriverService().create(name, phone);

		return "redirect:/app/showdrivers";
	}

}
