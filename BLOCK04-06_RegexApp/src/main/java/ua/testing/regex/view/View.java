package ua.testing.regex.view;

public interface View {

	void print(Object object);

	void printNotUniqueLogin(String login);

	void printInputMessage(String message);

	void printWrongStringInput(String message);

	String getBundleString(String key);
	
}
