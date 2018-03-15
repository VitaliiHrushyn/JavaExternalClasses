package ua.testing.labr05.controller;

import java.util.Scanner;

import ua.testing.labr05.model.Model;
import ua.testing.labr05.view.View;

public class Controller implements RegexConstants {
	
	private Model model;
	private View view;
	private Scanner scanner;
	
	{
		scanner = new Scanner(System.in);
	}	
	
	public Controller(Model model, View view) {
		super();
		this.model = model;
		this.view = view;
	}

	public void processUser() {
		
		askForCreateParabola();
		view.print("y = " + calculateParabolaY());
		printParabolaValues();
		
		
	}
	
	public String inputStringValueWithScanner(String message, String regex) {
		String res;
		view.printStringInput(message);
		while (!(scanner.hasNext() && (res = scanner.next()).matches(regex) )) {
			view.printWrongStringInput(message);
		}
		return res;
	}
	
	public void askForCreateParabola() {
		int a = Integer.valueOf(inputStringValueWithScanner("a (integer) (a != 0)", REGEX_A));
		int b = Integer.valueOf(inputStringValueWithScanner("b (integer)", REGEX_ABC));
		int c = Integer.valueOf(inputStringValueWithScanner("c (integer)", REGEX_ABC));
		
		model.createParabola(a, b, c);
	}
	
	public double calculateParabolaY() {
		double x = Double.valueOf(inputStringValueWithScanner("x (double) to get y", REGEX_XY));
		return model.getParabola().getYwhenXis(x);
	}
	
	public void printParabolaValues() {
		view.print(model.getParabola().toString());
	}

}
