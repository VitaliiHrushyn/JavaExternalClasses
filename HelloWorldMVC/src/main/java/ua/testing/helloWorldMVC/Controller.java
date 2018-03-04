package ua.testing.helloWorldMVC;

import java.util.Scanner;

public class Controller {
	
	Model model;
	View view;
	
	public Controller(Model model, View view) {
		super();
		this.model = model;
		this.view = view;
	}
	
	public void processUser() {		
		fillModel(model);				
		view.print(model.getMessage());
	}
	
	private String readAndValidateWord(Scanner sc, String checkWord) {
		String word = sc.nextLine();
		if (word.equals(checkWord)) {
			return word;
		}
		return null;
	}
	
	private void print(String message) {
		System.out.println(message);
	}
	
	private String checkWords() {
		Scanner sc = new Scanner(System.in);
		String firstWord = null;
		String secondWord = null;
		while (firstWord == null) {
			print("Enter first word");
			firstWord = readAndValidateWord(sc, "Hello");
			if (firstWord == null) print("Wrong word");
		}
		while (secondWord == null) {
			print("Enter second word");
			secondWord = readAndValidateWord(sc, "world!");
			if (secondWord == null) print("Wrong word");
		}
		return firstWord + " " + secondWord;
	}
	
	private void fillModel(Model model) {
		model.setMessage(checkWords());
	}
}
