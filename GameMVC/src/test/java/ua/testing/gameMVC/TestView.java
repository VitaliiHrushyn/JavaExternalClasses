package ua.testing.gameMVC;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class TestView {
	
	private static Model model;
	private static View view;
	private static Controller controller;
	
	@BeforeClass
	public static void createElements() {
//		model = new Model();
		view = new View();
		controller = new Controller(model, view);
	}
	
	@Ignore	
	@Test
	public void testPrint() {
		
		view.print("message");
		
		
	}

}
