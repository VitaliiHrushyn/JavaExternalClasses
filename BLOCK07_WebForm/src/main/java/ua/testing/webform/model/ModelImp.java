package ua.testing.webform.model;

public class ModelImp implements Model {
	
	private String name;
	private String login;

	public void setName(String name) {
		this.name = name;		
	}

	public void setLogin(String login) throws NotUniqueLoginException {
		if (checkLogin(login)) {
			this.login = login;
		}		
	}

	public String getName() {
		return name;
	}

	public String getLogin() {
		return login;
	}
	
	private boolean checkLogin(String login) throws NotUniqueLoginException {
		DBStub[] stubs = DBStub.values();
		for (DBStub stub : stubs) {
			if (stub.getLogin().equals(login)) {
				throw new NotUniqueLoginException("login " + login + " isn't unique");
			}
		}
		return true;
	}

}
