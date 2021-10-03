package baseball.view;

import baseball.controller.GameController;
import baseball.dto.ResponseDto;
import nextstep.utils.Console;

public class GameViewer {

	private final GameController controller = GameController.getInstance();

	private GameViewer() {
	}

	public static GameViewer getInstance() {
		return new GameViewer();
	}

	public void start() {
		controller.start();
		showAnswerView();
	}

	public void showAnswerView() {
		System.out.print("숫자를 입력주세요 : ");
		String number = Console.readLine();
		ResponseDto response = controller.check(number);
		System.out.println(response.getMessage());
		if (response.isOk()) {
			showSelectView();
			return;
		}
		showAnswerView();
	}

	public void showSelectView() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		String selection = Console.readLine();
		if (selection.equals("1")) {
			start();
		} else if(selection.equals("2")) {
			controller.end();
		}
	}
}
