package ua.testing.webform.model;

public enum DBStub {
	
	RECORD1("Zhora", "qwerty"),
	RECORD2("Vova", "123"),
	RECORD3("Sania", "login");
	
	private String name;
	private String login;
	
	private DBStub(String name, String login) {
		this.name = name;
		this.login = login;
	}

	public String getName() {
		return name;
	}

	public String getLogin() {
		return login;
	}
	
}
