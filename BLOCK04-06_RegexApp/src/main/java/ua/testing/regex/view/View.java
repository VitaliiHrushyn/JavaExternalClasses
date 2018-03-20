package ua.testing.regex.view;

import java.util.Locale;
import java.util.ResourceBundle;

import static ua.testing.regex.view.ViewConstants.*;

public class View {
	
	static String MESSAGE_BUNDLE_NAME = "messages";	
	static Locale locale = new Locale("uk", "UA");	
	public static final ResourceBundle bundle = ResourceBundle.getBundle(MESSAGE_BUNDLE_NAME, locale);

	public void printInputMessage(String message) {
		printMessage(bundle.getString(INPUT_DATA_REQUEST) + " " + message);
	}

	public void printWrongStringInput(String message) {
		printMessage(bundle.getString(WRONG_DATA_MESSAGE) + " " + message);		
	}
	
	public void print(Object object) {
		printMessage(object.toString());		
	}
	
	private void printMessage(String message) {
		System.out.println(message);
	}

	public void printNotUniqueLogin(String message) {
		printMessage(bundle.getString(NOT_UNIQUE_LOGIN) + " " + message);		
	}

}
