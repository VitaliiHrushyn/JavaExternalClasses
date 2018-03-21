package ua.testing.regex.view;

import java.util.Locale;
import java.util.ResourceBundle;

import static ua.testing.regex.view.ViewConstants.*;

public class ViewImp implements View{
	
	private static String MESSAGE_BUNDLE_NAME = "messages";
	
	private Locale locale;	
	private final ResourceBundle bundle;
	
	public ViewImp(String languageValue, String countryValue) {
		super();
		this.locale = new Locale(languageValue, countryValue);
		this.bundle = ResourceBundle.getBundle(MESSAGE_BUNDLE_NAME, locale);
	}

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
	
	public String getBundleString(String key) {
		return this.bundle.getString(key);
	}

}
