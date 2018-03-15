package ua.testing.labr05;

import ua.testing.labr05.controller.Controller;
import ua.testing.labr05.model.Model;
import ua.testing.labr05.view.View;

public class Main {
	
    public static void main( String[] args ) {
    	
    	Model model = new Model();
    	View view = new View();
    	Controller controller = new Controller(model, view);
    	
    	controller.processUser();
    }
}
