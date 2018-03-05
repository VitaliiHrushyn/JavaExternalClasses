package ua.testing.gameMVC;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Controller {
	
	Model model;
	View view;
	StringBuffer logger = new StringBuffer();
	Integer tryCount = 0;
	
	public Controller(Model model, View view) {
		super();
		this.model = model;
		this.view = view;
	}
	
	public void processUser() {
		
		setDiapason();
		setRandomNumber();
		guessing();
		
	}
	
	private void setDiapason() {
		int[] diapason = new int[2];
		do {
			print("Enter minimal value of diapason");
			diapason[0] = readNumber();
			print("Enter maximum value of diapason");
			diapason[1] = readNumber();
		}while(!model.checkAndSetDiapason(diapason));		
	}	
	
	private void setRandomNumber() {
		model.setSecretNumber();
	}	
	
	private void guessing() {
		Integer number = null;		
		do {
			do {
				try {
				number = askNumber();
				} catch (InputMismatchException e) {
					continue;
				}
			}while(!validateNumber(number, model.getDiapason()));		
		}while(!model.match(number));
		
		bingo();
	}
	
	private int askNumber() {
		int[] diapason = model.getDiapason();
		print("guess number from "+ diapason[0] + " to " + diapason[1] + ", excluding both");
		int number = readNumber();
		log(System.lineSeparator() + (++tryCount) + ". diapason " + diapason[0] + " - " + diapason[1] + ", your number: " + number + ", ");
		return number;
	}
	
	protected boolean validateNumber(int number, int... diapasone) {
		if (number > diapasone[0] && number < diapasone[1]) {
			return true;
		}
		print("You entered wrong number");
		log("this number is out of diapason.");
		return false;
	}
	
	private void bingo() {
		print("You have won! Number is " + model.getSecretNumber());
		log("Bingo! You've guessed for " + tryCount + " tries, finding number is " + model.getSecretNumber());
		print(logger.toString());
	}
	
	private void print(String message) {
		System.out.println(message);
	}
	
	private void log(String message) {
		logger.append(message);
	}
	
	protected int readNumber() {
		Integer number = null;
		@SuppressWarnings("resource") // it's impossible to close scanner because of impossibility to use scanner when next time this method will invoke.
		Scanner sc = new Scanner(System.in);
		do {	
			try {				
				number = sc.nextInt();					
			} catch (InputMismatchException e) {
				print("Invalid value, try again");
				sc.nextLine(); // scanner bug: this is maybe only way to make it stop to read nextInt in loop
			}
		} while (number == null);		
		return number;
	}
}
