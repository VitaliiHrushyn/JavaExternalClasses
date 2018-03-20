package ua.testing.regex.model;

public enum DBRecordEmulation {
	
	RECORD_1("qwerty"), 
	RECORD_2("123"), 
	RECORD_3("login123");
	
	private String login;

	private DBRecordEmulation(String login) {
		this.login = login;
	}

	public String getLogin() {
		return login;
	}

}
