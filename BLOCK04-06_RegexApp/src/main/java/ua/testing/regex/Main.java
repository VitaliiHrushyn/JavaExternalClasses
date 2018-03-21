package ua.testing.regex;

import ua.testing.regex.controller.Controller;
import ua.testing.regex.controller.ControllerImp;
import ua.testing.regex.model.Model;
import ua.testing.regex.model.ModelImp;
import ua.testing.regex.view.View;
import ua.testing.regex.view.ViewImp;

public class Main {
	
	public static void main( String[] args ) {		

		View view = new ViewImp("uk", "UA");
		Model model = new ModelImp(view);
		Controller controller = new ControllerImp(model, view);
		
		controller.processUser();

    }
}
