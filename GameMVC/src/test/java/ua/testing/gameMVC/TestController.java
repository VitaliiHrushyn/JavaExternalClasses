package ua.testing.gameMVC;

import java.util.InputMismatchException;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Assert;


public class TestController {
	
	private static Model model;
	private static View view;
	private static Controller controller;
	
//	@BeforeClass
//	public static void createElements() {
//		model = new Model();
//		view = new View();
//		controller = new Controller(model, view);
//	}
	
//	@AfterClass
//	public static void destroyElements() {
//		model = null;
//		view = null;
//		controller = null;
//	}
	
	@Rule
	public final ExpectedException expExc = ExpectedException.none();
	
//	@Ignore
//	@Test
//	public void testReadNumber() {
//		expExc.expect(InputMismatchException.class);
//		controller.readNumber();
//		
//	}
//	
//	@Test
//	public void testValidateNumber() {
//		int[] diapasone = {1, 3};
//		boolean resTrue = controller.validateNumber(2, diapasone);
//		boolean resFalseMin = controller.validateNumber(1, diapasone);
//		boolean resFalseMax = controller.validateNumber(3, diapasone);
//		Assert.assertTrue(resTrue);
//		Assert.assertFalse(resFalseMin);
//		Assert.assertFalse(resFalseMax);
//		
//	}

}
