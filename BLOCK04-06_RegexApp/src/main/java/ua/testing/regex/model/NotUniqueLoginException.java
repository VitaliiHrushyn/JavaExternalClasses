package ua.testing.regex.model;

public class NotUniqueLoginException extends Exception {

	private static final long serialVersionUID = -6717202174728547174L;

	public NotUniqueLoginException() {
		super();
	}

	public NotUniqueLoginException(String message) {
		super(message);
	}

}
