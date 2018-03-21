package ua.testing.regex.model;

import java.util.ArrayList;
import java.util.List;

import ua.testing.regex.view.View;

public class Notebook {
	
	private List<Record> records;

	public Notebook(View view) {
		super();
		records = new ArrayList<>();
		records.add(new Record(view));
	}

	public List<Record> getRecords() {
		return records;
	}

	public void setRecords(List<Record> records) {
		this.records = records;
	}
	
	public boolean addRecord(Record record) {
		return records.add(record);		
	}
	
	public Record getFirstRecord() {
		return records.get(0);
	}
	
}
