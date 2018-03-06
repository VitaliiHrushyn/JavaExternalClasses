package ua.testing.gameMVC;

public class View {

	public View() {
		super();
	}
	
	public void print(String message) {
		System.out.println("" + message);
	}
	
	public void printInvalidValueMessage() {
		print("Invalid value, try again");
	}
	
	public void printWinMessage(Model model) {
		print(model.getLogMessage());
	}

	public void printGreatings() {
		print("Hello! Let's play guessing number \n");
		
	}

}
