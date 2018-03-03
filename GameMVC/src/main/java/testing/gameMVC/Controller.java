package testing.gameMVC;

import java.util.Scanner;

public class Controller {
	
	Model model;
	View view;
	Scanner sc = new Scanner(System.in);
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
			diapason[0] = sc.nextInt();
			print("Enter maximum value of diapason");
			diapason[1] = sc.nextInt();
		}while(!model.checkAndSetDiapason(diapason));		
	}	
	
	private void setRandomNumber() {
		model.setSecretNumber();
	}	
	
	private void guessing() {
		int number;		
		do {
			do {
				number = askNumber();
			}while(!validateNumber(number, model.getDiapason()));		
		}while(!model.match(number));
		
		bingo();
	}
	
	private int askNumber() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int[] diapason = model.getDiapason();
		print("guess number from "+ diapason[0] + " to " + diapason[1]);
		int number = sc.nextInt();
		log(System.lineSeparator() + (++tryCount) + ". diapason " + diapason[0] + " - " + diapason[1] + ", your number: " + number + ", ");
		return number;
	}
	
	private boolean validateNumber(int number, int... minmax) {
		if (number > minmax[0] && number < minmax[1]) {
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
}
