package baseball.model;

import baseball.view.InputView;

public class ReGame {
	private static final String RESTART = "1";
    private static final String TERMINATE = "2";
	
	public static boolean endGame() {
		boolean gamingStatus =  true;
		String inputValue = InputView.getInput();
		
		if(inputValue.equals(RESTART)) {
			gamingStatus = true;
		}
		if(inputValue.equals(TERMINATE)) {
			gamingStatus = false;
		}
		
		System.out.println("reGame === " + inputValue);
		return gamingStatus;
	}

}
