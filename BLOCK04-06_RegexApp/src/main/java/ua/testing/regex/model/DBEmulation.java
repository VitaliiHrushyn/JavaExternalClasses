package ua.testing.regex.model;

public enum DBEmulation {
	
	RECORD_1("qwerty"), 
	RECORD_2("123"), 
	RECORD_3("login123");
	
	private String login;

	private DBEmulation(String login) {
		this.login = login;
	}

	public String getLogin() {
		return login;
	}

}
