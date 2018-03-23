package ua.testing.webform.model;

public interface Model {
	
	void setName(String name);
	void setLogin(String login) throws NotUniqueLoginException;
	String getName();
	String getLogin();

}
