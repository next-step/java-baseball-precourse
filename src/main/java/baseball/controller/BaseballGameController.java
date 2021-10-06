package baseball.controller;

import baseball.model.RandomValue;
import baseball.model.ReGame;
import baseball.view.OutputView;

public class BaseballGameController {
	
	public static void run() {
		
		boolean gaming = true;
		
		while(gaming) {
			//랜덤값 생성
			int randomValue = RandomValue.makeRandomValue();
			System.out.println("테스트 컴퓨터 값 === " + randomValue);

			GameStartController.startGame(randomValue);
			
			OutputView.printThreeStrike();
			OutputView.printReGame();
			
			gaming = ReGame.endGame();
		}
	}

}
