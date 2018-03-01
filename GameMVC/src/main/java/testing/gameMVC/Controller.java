package testing.gameMVC;

import java.util.Random;
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
	
	public void processUser(int... minmax) {
		if (minmax.length != 2) {
			throw new IllegalArgumentException();
		}
		setRandomNumber(model, minmax);
		guessing(minmax);
		
	}
	
	private void setRandomNumber(Model model, int... minmax) {
		model.setNumber(rand(minmax));
	}
	
	private int rand(int... minmax) {
		Random random = new Random();
		int number = minmax[0] + random.nextInt(minmax[1] - minmax[0]);
		return number;
	}
	
	private void guessing(int... minmax) {
		int guessedNumber;		
		do {
			do {
				guessedNumber = guessNumber(minmax);
			}while(!validateNumber(guessedNumber, minmax));
			
			countDiapason(guessedNumber, minmax);				
		}while(!match(guessedNumber));
		
		bingo();
	}
	
	private int guessNumber(int... minmax) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		print("guess number from "+ minmax[0] + " to " + minmax[1]);
		int citedNumber = sc.nextInt();
		log(System.lineSeparator() + (++tryCount) + ". diapason " + minmax[0] + " - " + minmax[1] + ", your number: " + citedNumber + ", ");
		return citedNumber;
	}
	
	private boolean validateNumber(int number, int... minmax) {
		if (number > minmax[0] && number < minmax[1]) {
			return true;
		}
		print("You entered wrong number");
		log("this number out of diapason.");
		return false;
	}
	
	private boolean match(int number) {
		if (number == model.getNumber()) {
			return true;
		}
		return false;
	}
	
	private void countDiapason(int number, int... minmax) {
		int findingNumber = model.getNumber();
		if (findingNumber > number) {
			print("more!");
			log("wrong, finding number is biggest.");
			minmax[0] = number;
		}
		if (findingNumber < number) {
			print("less!");
			log("wrong, finding number is smallest.");
			minmax[1] = number;
		}
	}
	
	private void bingo() {
		print("You have won! Number is " + model.getNumber());
		log("Bingo! You've guessed for " + tryCount + " tries, finding number is " + model.getNumber());
		print(logger.toString());
	}
	
	private void print(String message) {
		System.out.println(message);
	}
	
	private void log(String message) {
		logger.append(message);
	}
}
