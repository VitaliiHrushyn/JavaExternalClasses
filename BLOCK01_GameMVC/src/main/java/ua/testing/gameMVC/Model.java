package ua.testing.gameMVC;

import java.util.Random;

public class Model {
	
	private View view;
	private StringBuilder logger;
	private int attempts;
	private Integer secretNumber;
	private int[] diapason;
	
	public Model(View view) {
		super();
		this.view = view;
		this.logger = new StringBuilder();
		logger.append("\n Statistics: \n ---------- \n");
		this.attempts = 0;
		this.diapason = new int[2];
	}

	public int getSecretNumber() {
		return secretNumber;
	}

	public void setSecretNumber() {
		Random random = new Random();
		this.secretNumber = diapason[0] + 1 + random.nextInt(diapason[1] - diapason[0] - 1);
	}

	public int[] getDiapason() {
		return diapason;
	}

	public boolean setDiapason(int[] diapason) {
		if (validateDiapason(diapason)) {
			this.diapason = diapason;
			return true;
		}
		return false;
	}

	public boolean validateDiapason(int[] diapason) {
		if(diapason.length != 2) {
			return false;
		}
		if(diapason[1] < diapason[0]) {
			view.print("Invalid values: reverse diapason values");
			return false;
		}
		else if(diapason[1] - diapason[0] < 2) {
			view.print("Too small diapason");
			return false;
		}
		return true;
	}
	
	public boolean matchSecretNumber(int userNumber) {
		if (validateUserNumber(userNumber)) {
			return isGuessed(userNumber);
		} else {
			return false;
		}
	}
	
	public boolean validateUserNumber(int number) {
		if (number > diapason[0] && number < diapason[1]) {
			return true;
		} else {
			view.print("You entered number out of diapason");
			log("" + (++attempts) + ". your number: " + number + " is out of diapason (excluding): " + diapason[0] + " - " + diapason[1]);
			return false;
		}
	}

	public boolean isGuessed(int number) {
		if (number == secretNumber) {
			log("" + (++attempts) + ". your number: " + number +". WIN! Secret number is " + number + ". You needed "+ attempts + " attempts to guess the number.");
			return true;
		} else {
			log("" + (++attempts) + ". your number: " + number + " in diapason (excluding): " + diapason[0] + " - " + diapason[1]);
			recountDiapason(number);
			return false;
		}
	}	
	
	public void recountDiapason(int number) {
		if (secretNumber > number) {
			view.print("more!");
			diapason[0] = number;
		}
		if (secretNumber < number) {
			view.print("less!");
			diapason[1] = number;
		}
	}
	
	public void log(String message) {
		logger.append(message + "\n");
	}

	public String getLogMessage() {
		return logger.toString();
	}	
}
