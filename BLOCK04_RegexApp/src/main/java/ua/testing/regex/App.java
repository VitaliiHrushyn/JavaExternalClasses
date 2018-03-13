package ua.testing.regex;

import ua.testing.regex.controller.Controller;
import ua.testing.regex.model.Model;
import ua.testing.regex.view.View;

public class Main {
	
	public static void main( String[] args ) {		

		View view = new View();
		Model model = new Model();
		Controller controller = new Controller(model, view);
		
		controller.processUser();

    }
}
