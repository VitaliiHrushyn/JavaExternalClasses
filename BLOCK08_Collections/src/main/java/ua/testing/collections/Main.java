package ua.testing.collections;

import java.util.Arrays;
import java.util.List;


public class Main {

	public static void main(String[] args) {

		List<Integer> listOfIntegers = new UndeletableElementsArrayList<>(Arrays.asList(4,5,6,4,5,3,4,2,4,5,7));
		
		try {
			listOfIntegers.remove(0);
		}catch (UnsupportedOperationException e) {
			System.out.println("You've try to execute unsupported operation of remove element");
		}
		
		System.out.println(System.lineSeparator());
		
		System.out.println("Count elements entries:\n" + IntegerEntryCounter.count(listOfIntegers));

	}

}
