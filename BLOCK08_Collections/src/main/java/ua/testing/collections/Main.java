package ua.testing.collections;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		Iterable<Integer> listOfIntegers = new UndeletableElementsList<>(Arrays.asList(4,5,6,4,5,3,4,2,4,5,7));
				
		System.out.println("Count elements entries:\n" + IntegerEntryCounter.count(listOfIntegers));

	}

}
