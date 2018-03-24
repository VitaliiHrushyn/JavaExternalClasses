package ua.testing.collections;

import java.util.Collection;
import java.util.TreeMap;

public class IntegerEntryCounter {
	
	static public String count(Collection<Integer> collection) {
		InnerIntegerEntryCounter counter = new InnerIntegerEntryCounter();
		for (Integer value : collection) {
			counter.put(value, 1);
		}		
		return counter.toString();
	}

	static class InnerIntegerEntryCounter extends TreeMap<Integer, Integer> {

		private static final long serialVersionUID = 1L;

		@Override
		public Integer put(Integer key, Integer value) {
			Integer entryCount = super.put(key, value);
			if (entryCount == null) entryCount = 0; 
			return super.put(key, value + entryCount);
		}		

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			for (java.util.Map.Entry<Integer, Integer> entry : this.entrySet()) {
				sb.append(entry.getKey().toString()).append(" - ").append(entry.getValue().toString()).
					append(System.lineSeparator());				
			}
			return sb.toString();
		}		
	}

}
