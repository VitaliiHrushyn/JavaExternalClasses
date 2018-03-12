package ua.testing.regex.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Record {
	
	private List<Row> rows;
	private int rowIndex;
	
	public Record() {
		super();
		/*makes full row list from all Row enum values*/
		rows = new ArrayList<>(Arrays.asList(Row.values()));
		rowIndex = -1;
	}

	public List<Row> getRows() {
		return rows;
	}
	
	public boolean hasNextEmptyRow() {	
//		System.err.println("rowIndex " + rowIndex);
//		System.err.println("rows.size " + rows.size());
		return (rows.size() - 1 > rowIndex) ? true : false;
		
	}
	
	public void writeNextRow(String value) {
		rows.get(++rowIndex).setValue(value);
	}
	
	public Row getCurrentRow() {
		/* rowIndex  < 0 means no one row is filled */
		if (rowIndex < 0) {
			return null;
		}
		return rows.get(rowIndex);
	}
	
	public Row getNextRow() {
		return rows.get(rowIndex + 1);
	}
	
	public Row getRow(int index) {
		return rows.get(index);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Account information: ");
		for (Row row : rows) {
			sb.append("\n\t "+row.getName() + ": " + row.getValue());
		}
		sb.append(".");		 
		return sb.toString();
	}	

//	@Override
//	public String toString() {
//		return "Account information: "
//				+ "/n/t last name :" + Row.LAST_NAME.getValue() 
//				+ "/n/t first name :" + Row.FIRST_NAME.getValue() 
//				+ "/n/t patronymic :" + Row.PATRONYMIC.getValue() 
//				+ "/n/t nick name :" + Row.NICKNAME.getValue() 
//				+ "/n/t comments :" + Row.COMMENTS.getValue() 
//				+ "/n/t group :" + Row.GROUP.getValue() 
//				+ "/n/t home phone number :" + Row.HOME_PHONE.getValue() 
//				+ "/n/t primary mobile phone number :" + Row.PRIMARY_MOBILE.getValue() 
//				+ "/n/t secondary mobile phone number :" + Row.SECONARY_MOBILE.getValue() 
//				+ "/n/t email : " + Row.EMAIL.getValue() 
//				+ "/n/t skype name :" + Row.SKYPE.getValue() 
//				+ "/n/t address : " + Row.ADDRESS.getValue()
//				+ "/n/t enter date : " + Row.ENTER_DATE.getValue() 
//				+ "/n/t last update : " + Row.LAST_UPDATE.getValue() + ".";
//	}	

}
