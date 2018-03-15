package ua.testing.labr05.view;

public class View {

	public void printStringInput(String message) {
		print("Input " + message);		
	}

	public void printWrongStringInput(String message) {
		print("Wrong input! Input " + message);		
	}
	
	public void print(Object message) {
		System.out.println(message.toString());
	}

}
