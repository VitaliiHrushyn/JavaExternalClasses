package ua.testing.gameMVC;

import java.util.Random;

public class Model {
	
	private int secretNumber;
	private int[] diapason = new int[2];
	
	public Model() {
		super();
	}

	public int getSecretNumber() {
		return secretNumber;
	}

	public void setSecretNumber() {
		this.secretNumber = rand();
	}

	public int[] getDiapason() {
		return diapason;
	}

	private int rand() {
		Random random = new Random();
		int number = diapason[0] + random.nextInt(diapason[1] - diapason[0]);
		return number;
	}
	
	public boolean checkAndSetDiapason(int[] diapason) {
		if(diapason.length != 2) {
			throw new IllegalArgumentException();
		}
		if(diapason[1] < diapason[0]) {
			print("Invalid values: reverse diapason values");
			return false;
		}
		else if(diapason[1] - diapason[0] < 2) {
			print("Too smal diapason");
			return false;
		}
		this.diapason = diapason;
		return true;
	}
	
	private void print(String message) {
		System.out.println(message);
	}
	
	public boolean match(int number) {
		if (number == secretNumber) {
			return true;
		}
		countDiapason(number);
		return false;
	}
	
	private void countDiapason(int number) {
		if (secretNumber > number) {
			print("more!");
	//		log("wrong, finding number is biggest.");
			diapason[0] = number;
		}
		if (secretNumber < number) {
			print("less!");
	//		log("wrong, finding number is smallest.");
			diapason[1] = number;
		}
	}
}
