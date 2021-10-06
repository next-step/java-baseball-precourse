package baseball.model;

import baseball.view.InputView;

	/**
	 * 게임속행과 종료에 대한 사용자의 값을 입력받는다.
	 * 
	 *
	 */
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
		
		return gamingStatus;
	}

}
