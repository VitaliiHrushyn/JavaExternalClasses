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
	private View view;
	
	public Record(View view) {
		super();
		this.view = view;
		/*makes row list from all Row enum values*/
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
		return view.getBundleString(ACCOUNT_INFORMATION) +": "
				+ "\n\t " + view.getBundleString(LOGIN) +": " + Row.LOGIN.getValue() + " " 
				+ "\n\t " + view.getBundleString(NAME) +": " 
					+ Row.LAST_NAME.getValue() + " " 
					+ Row.FIRST_NAME.getValue().toString().charAt(0) + "."
				+ "\n\t " + view.getBundleString(NICKNAME) +": " + Row.NICKNAME.getValue()
				+ "\n\t " + view.getBundleString(COMMENTS) +": " + Row.COMMENTS.getValue() 
				+ "\n\t " + view.getBundleString(GROUP) +": " + Row.GROUP.getValue() 
				+ "\n\t " + view.getBundleString(HOME_PHONE) +": " + Row.HOME_PHONE.getValue() 
				+ "\n\t " + view.getBundleString(PRIMARY_MOBILE) +": " + Row.PRIMARY_MOBILE.getValue() 
				+ "\n\t " + view.getBundleString(SECONARY_MOBILE) +": " + Row.SECONARY_MOBILE.getValue() 
				+ "\n\t " + view.getBundleString(EMAIL) +": " + Row.EMAIL.getValue() 
				+ "\n\t " + view.getBundleString(SKYPE) +": " + Row.SKYPE.getValue() 
				+ "\n\t " + view.getBundleString(ADDRESS) +": "
						+ "\n\t\t " + view.getBundleString(ADDRESS_ZIP) +": " + Row.ADDRESS_ZIP.getValue()
						+ "\n\t\t " + view.getBundleString(ADDRESS_LOCALITY) +": " + Row.ADDRESS_LOCALITY.getValue() 
						+ "\n\t\t " + view.getBundleString(ADDRESS_STREET) +": " + Row.ADDRESS_STREET.getValue()
						+ "\n\t\t " + view.getBundleString(ADDRESS_BUILDING) +": " + Row.ADDRESS_BUILDING.getValue() 
						+ "\n\t\t " + view.getBundleString(ADDRESS_APARTMENT) +": " + Row.ADDRESS_APARTMENT.getValue()
				+ "\n\t " + view.getBundleString(RECORD_CREATION_TIME) +": " + this.creationDate.format(DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy"))
				+ "\n\t " + view.getBundleString(RECORD_LAST_UPDATE) +": " + this.lastUpdate.format(DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy")) + ".";
	}	

}
