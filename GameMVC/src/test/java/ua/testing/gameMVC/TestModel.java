package ua.testing.gameMVC;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TestModel {
	
	private static final int[] RIGHT_DIAPASON = {1, 3};
	private static final int[] SMALL_DIAPASON = {1, 2};
	private static final int[] REVERSED_DIAPASON = {3, 1};
	private static final int EXPECTED_SECRET_NUMBER = 2;
	private static final int RIGHT_USER_NUMBER = 2;
	private static final int TOO_BIG_USER_NUMBER = 3;
	private static final int TOO_SMALL_USER_NUMBER = 1;
	
	Model model = new Model(new View());
	
	 @Before
	 public void initializeModelForTests() {
		 model.setDiapason(RIGHT_DIAPASON);
		 model.setSecretNumber();
	 }	 
	 
	 @Test
	 public void testSetDiapason() {
		 Assert.assertTrue(model.setDiapason(RIGHT_DIAPASON));
		 Assert.assertFalse(model.setDiapason(SMALL_DIAPASON));
		 Assert.assertFalse(model.setDiapason(REVERSED_DIAPASON));
	 }
	 
	 @Test
	 public void testSetSecretNumber() {
		 int number = model.getSecretNumber();
		 Assert.assertEquals(EXPECTED_SECRET_NUMBER, number);
	 }
	 
	 @Test
	 public void testValidateDiapason() {
		 Assert.assertTrue(model.validateDiapason(RIGHT_DIAPASON));
		 Assert.assertFalse(model.validateDiapason(SMALL_DIAPASON));
		 Assert.assertFalse(model.validateDiapason(REVERSED_DIAPASON)); 
	 }
	 
	 @Test
	 public void testMatchSecretNumber() {
		 Assert.assertTrue(model.matchSecretNumber(RIGHT_USER_NUMBER));
		 Assert.assertFalse(model.matchSecretNumber(TOO_BIG_USER_NUMBER));
		 Assert.assertFalse(model.matchSecretNumber(TOO_SMALL_USER_NUMBER));
	 }
	 
	 @Test
	 public void testValidateUserNumber() {
		 Assert.assertTrue(model.validateUserNumber(RIGHT_USER_NUMBER));
		 Assert.assertFalse(model.validateUserNumber(TOO_BIG_USER_NUMBER));
		 Assert.assertFalse(model.validateUserNumber(TOO_SMALL_USER_NUMBER));
	 }
	 
	 @Test
	 public void testIsGuessed() {
		 Assert.assertTrue(model.isGuessed(RIGHT_USER_NUMBER));
		 Assert.assertFalse(model.isGuessed(TOO_BIG_USER_NUMBER));
		 Assert.assertFalse(model.isGuessed(TOO_SMALL_USER_NUMBER));
	 }
	 

}
