package ua.testing.regex.controller;

import java.util.Scanner;

import ua.testing.regex.model.Model;
import ua.testing.regex.model.NotUniqueLoginException;
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
		
		while (record.hasRow()) {
			Row currentRow = record.getCurrentRow();
			String value = inputStringValueWithScanner(currentRow.getRequest(), currentRow.getRegex());
			try {
				record.writeRowAndIcrementRowIndex(value);
			} catch (NotUniqueLoginException e) {
				view.printWrongStringInput("Login "+ value + " isn't unique.");;
			}
			record.setLastUpdate();
		}
		
		view.print(record);
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
