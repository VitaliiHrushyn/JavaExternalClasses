package ua.testing.regex.controller;

import java.util.Scanner;

import ua.testing.regex.model.Model;
import ua.testing.regex.model.NotUniqueLoginException;
import ua.testing.regex.model.Record;
import ua.testing.regex.model.Row;
import ua.testing.regex.view.View;


public class ControllerImp implements Controller {
	
	private Model model;
	private View view;
	private Scanner scanner;
	
	public ControllerImp(Model model, View view) {
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
			view.printNotUniqueLogin(value);
		}
		
		record.setLastUpdate();
	}

	private void writeValue(Record record, String value) throws NotUniqueLoginException {
		record.writeCurrentRow(value);
		record.switchToNextRow();
	}
	
	public String getValidatedValue(Record record) {
		Row currentRow = record.getCurrentRow();
		return readAndValidateStringValueWithScanner(view.getBundleString(currentRow.getRequest()), view.getBundleString(currentRow.getRegex()));
	}
	
	public String readAndValidateStringValueWithScanner(String message, String regex) {
		String res;
		view.printInputMessage(message);
		while (!(scanner.hasNext() && (res = scanner.nextLine()).matches(regex) )) {
			view.printWrongStringInput(message);
		}
		return res;
	}

}
