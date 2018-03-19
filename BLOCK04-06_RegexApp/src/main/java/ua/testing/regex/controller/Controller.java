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
			writeRow(record);
		}
		
		view.print(record);
	}

	private void writeRow(Record record) {
		
		String value = getValidatedValue(record);
		try {
			writeValue(record, value);
		} catch (NotUniqueLoginException e) {
			view.printWrongStringInput("Login "+ value + " isn't unique.");
		}
		
		record.setLastUpdate();
	}

	private void writeValue(Record record, String value) throws NotUniqueLoginException {
		record.writeCurrentRow(value);
		record.switchToNextRow();
	}
	
	public String getValidatedValue(Record record) {
		Row currentRow = record.getCurrentRow();
		return readAndValidateStringValueWithScanner(currentRow.getRequest(), currentRow.getRegex());
	}
	
	public String readAndValidateStringValueWithScanner(String message, String regex) {
		String res;
		view.printStringInput(message);
		while (!(scanner.hasNext() && (res = scanner.nextLine()).matches(regex) )) {
			view.printWrongStringInput(message);
		}
		return res;
	}

}
