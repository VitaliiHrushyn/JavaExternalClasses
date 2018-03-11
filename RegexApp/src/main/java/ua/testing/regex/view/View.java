package ua.testing.regex.view;

import ua.testing.regex.model.Record;

public class View {

	public void printStringInput(String message) {
		print("Type your " + message + " and press ENTER");
	}

	public void printWrongStringInput(String message) {
		print("Wrong enter. Type your " + message + " again and press ENTER");		
	}
	
	public void printFilledRecord(Record record) {
		print(record.toString());		
	}
	
	public void print(String message) {
		System.out.println(message);
	}

}
