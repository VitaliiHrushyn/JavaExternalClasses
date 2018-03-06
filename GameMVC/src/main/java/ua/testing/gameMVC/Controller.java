package ua.testing.gameMVC;

import java.util.Scanner;

public class Controller {
	
	private Model model;
	private View view;
	private Scanner sc;
	
	public Controller(Model model, View view) {
		super();
		this.model = model;
		this.view = view;
	}
	
	public void processUser() {
		
		sc = new Scanner(System.in);
		
		view.printGreatings();		
		setDiapason();
		model.setSecretNumber();
		guessSecretNumber();
		view.printWinMessage(model);
		
		sc.close();		
	}
	
	public void setDiapason() {
		int[] diapason;
		do {
			diapason = requestDiapasonValues();
		}while(!model.setDiapason(diapason));
	}
	
	public int[] requestDiapasonValues() {
		int[] diapason = new int[2];		
		diapason[0] = requestNumberFromUser("Enter minimal value of diapason");
		diapason[1] = requestNumberFromUser("Enter maximum value of diapason");
		return diapason;		
	}
	
	public int requestNumberFromUser(String message) {
		Integer number = null;
		while (number == null) {
			view.print(message);
			number = readInteger();
		}	
		return number;
	}

	public Integer readInteger() {		
		String source = sc.nextLine();
		try {
			return Integer.valueOf(source);					
		} catch (NumberFormatException e) {
			view.printInvalidValueMessage();
			return null;
		}
	}		
	
	public void guessSecretNumber() {
		int number;		
		do {
			number = requestNumberFromUser("guess number from "+ model.getDiapason()[0] + " to " + model.getDiapason()[1] + ", excluding both");	
		}while(!model.matchSecretNumber(number));
	}

}
