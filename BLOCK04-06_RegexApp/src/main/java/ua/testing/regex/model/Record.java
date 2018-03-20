package ua.testing.regex.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ua.testing.regex.view.View;
import static ua.testing.regex.view.ViewConstants.*;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Record {
	
	private List<Row> rows;
	private int currentIndex;
	private LocalDateTime creationDate;
	private LocalDateTime lastUpdate;
	
	public Record() {
		super();
		/**makes row list from all Row enum values*/
		rows = new ArrayList<>(Arrays.asList(Row.values()));
		currentIndex = 0;
		creationDate = LocalDateTime.now();
	}

	public List<Row> getRows() {
		return rows;
	}
	
	public boolean hasRow() {	
		return (currentIndex < rows.size()) ? true : false;		
		
	}
	
	public void writeCurrentRow(String value) throws NotUniqueLoginException {		
		rows.get(currentIndex).setValue(value);
	}
	
	public void switchToNextRow() {
		currentIndex++;
	}
	
	public Row getCurrentRow() {
		return rows.get(currentIndex);
	}
	
	public Row getNextRow() {
		return rows.get(currentIndex + 1);
	}
	
	public Row getRow(int index) {
		return rows.get(index);
	}

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate() {
		this.lastUpdate = LocalDateTime.now();
	}
	
	@Override
	public String toString() {
		return View.bundle.getString(ACCOUNT_INFORMATION) +": "
				+ "\n\t " + View.bundle.getString(LOGIN) +": " + Row.LOGIN.getValue() + " " 
				+ "\n\t " + View.bundle.getString(NAME) +": " 
					+ Row.LAST_NAME.getValue() + " " 
					+ Row.FIRST_NAME.getValue().toString().charAt(0) + "."
				+ "\n\t " + View.bundle.getString(NICKNAME) +": " + Row.NICKNAME.getValue()
				+ "\n\t " + View.bundle.getString(COMMENTS) +": " + Row.COMMENTS.getValue() 
				+ "\n\t " + View.bundle.getString(GROUP) +": " + Row.GROUP.getValue() 
				+ "\n\t " + View.bundle.getString(HOME_PHONE) +": " + Row.HOME_PHONE.getValue() 
				+ "\n\t " + View.bundle.getString(PRIMARY_MOBILE) +": " + Row.PRIMARY_MOBILE.getValue() 
				+ "\n\t " + View.bundle.getString(SECONARY_MOBILE) +": " + Row.SECONARY_MOBILE.getValue() 
				+ "\n\t " + View.bundle.getString(EMAIL) +": " + Row.EMAIL.getValue() 
				+ "\n\t " + View.bundle.getString(SKYPE) +": " + Row.SKYPE.getValue() 
				+ "\n\t " + View.bundle.getString(ADDRESS) +": "
						+ "\n\t\t " + View.bundle.getString(ADDRESS_ZIP) +": " + Row.ADDRESS_ZIP.getValue()
						+ "\n\t\t " + View.bundle.getString(ADDRESS_LOCALITY) +": " + Row.ADDRESS_LOCALITY.getValue() 
						+ "\n\t\t " + View.bundle.getString(ADDRESS_STREET) +": " + Row.ADDRESS_STREET.getValue()
						+ "\n\t\t " + View.bundle.getString(ADDRESS_BUILDING) +": " + Row.ADDRESS_BUILDING.getValue() 
						+ "\n\t\t " + View.bundle.getString(ADDRESS_APARTMENT) +": " + Row.ADDRESS_APARTMENT.getValue()
				+ "\n\t " + View.bundle.getString(RECORD_CREATION_TIME) +": " + this.creationDate.format(DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy"))
				+ "\n\t " + View.bundle.getString(RECORD_LAST_UPDATE) +": " + this.lastUpdate.format(DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy")) + ".";
	}	

}
