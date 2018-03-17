package ua.testing.regex.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Record {
	
	private List<Row> rows;
	private int currentIndex;
	private Date creationDate;
	private Date lastUpdate;
	
	public Record() {
		super();
		/**makes row list from all Row enum values*/
		rows = new ArrayList<>(Arrays.asList(Row.values()));
		currentIndex = 0;
		creationDate = new Date();
	}

	public List<Row> getRows() {
		return rows;
	}
	
	public boolean hasRow() {	
		return (currentIndex < rows.size()) ? true : false;		
		
	}
	
	public void writeRowAndIcrementRowIndex(String value) throws NotUniqueLoginException {		
		rows.get(currentIndex).setValue(value);
		/* 
		 * important position of index increment because of 
		 * setValue method could throw NotUniqueLoginException 
		 * which must be occurred before incrementation
		 */
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

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate() {
		this.lastUpdate = new Date();
	}
	
	@Override
	public String toString() {
		return "Account information: "
				+ "\n\t login: " + Row.LOGIN.getValue() + " " 
				+ "\n\t name: " + Row.LAST_NAME.getValue() + " " 
					+ Row.FIRST_NAME.getValue().toString().charAt(0) + "."
				+ "\n\t nick name: " + Row.NICKNAME.getValue() 
				+ "\n\t comments: " + Row.COMMENTS.getValue() 
				+ "\n\t group: " + Row.GROUP.getValue() 
				+ "\n\t home phone number: " + Row.HOME_PHONE.getValue() 
				+ "\n\t primary mobile phone number: " + Row.PRIMARY_MOBILE.getValue() 
				+ "\n\t secondary mobile phone number: " + Row.SECONARY_MOBILE.getValue() 
				+ "\n\t email: " + Row.EMAIL.getValue() 
				+ "\n\t skype name: " + Row.SKYPE.getValue() 
				+ "\n\t address: "
						+ "\n\t\t ZIPcode: " + Row.ADDRESS_ZIP.getValue()
						+ "\n\t\t locality: " + Row.ADDRESS_LOCALITY.getValue() 
						+ "\n\t\t street: " + Row.ADDRESS_STREET.getValue()
						+ "\n\t\t building number: " + Row.ADDRESS_BUILDING.getValue() 
						+ "\n\t\t apartment number: " + Row.ADDRESS_APARTMENT.getValue()
				+ "\n\t record cretion date: " + this.creationDate 
				+ "\n\t record last update: " + this.lastUpdate + ".";
	}	

}
