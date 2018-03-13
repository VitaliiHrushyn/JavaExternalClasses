package ua.testing.regex.controller;

import java.util.Scanner;

import ua.testing.regex.model.Model;
import ua.testing.regex.model.Record;
import ua.testing.regex.model.Row;
import ua.testing.regex.view.View;


public class Controller {
	
	private Model model;
	private View view;
	private Scanner scanner;
	
	public Controller(Model model, View view) {
		super();
		this.model = model;
		this.view = view;
		this.scanner = new Scanner(System.in);
	}
	
	public void processUser() {
		
		Record record = model.getNotebook().getFirstRecord();
		
		while (record.hasNextEmptyRow()) {
			Row nextRow = record.getNextRow();
			String value = inputStringValueWithScanner(nextRow.getRequest(), nextRow.getRegex());
			record.writeNextRow(value);
		}
		
		view.printFilledRecord(record);
	}
	
	public String inputStringValueWithScanner(String message, String regex) {
		String res;
		view.printStringInput(message);
		while (!(scanner.hasNext() && (res = scanner.nextLine()).matches(regex) )) {
			view.printWrongStringInput(message);
		}
		return res;
	}

}
