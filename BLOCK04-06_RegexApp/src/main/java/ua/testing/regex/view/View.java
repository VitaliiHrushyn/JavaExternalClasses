package ua.testing.regex.view;

public class View {

	public void printStringInput(String message) {
		printMessage("Type your " + message + " and press ENTER");
	}

	public void printWrongStringInput(String message) {
		printMessage("Wrong enter. " + message);		
	}
	
	public void print(Object object) {
		printMessage(object.toString());		
	}
	
	public void printMessage(String message) {
		System.out.println(message);
	}

}
