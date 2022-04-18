package baseball.ui;

import java.util.List;
import java.util.stream.Collectors;

import baseball.logic.GameLogic;
import camp.nextstep.edu.missionutils.Console;

public class CliGameUI implements GameUI {

	private GameLogic gameLogic;

	public CliGameUI(GameLogic gameLogic) {
		this.gameLogic = gameLogic;
	}

	@Override
	public void process() {
		List<Integer> randNum = (List<Integer>) gameLogic.generateNumbers();

		// Game Start
		while (true) {
			List<Integer> inputNum = (List<Integer>)input();
			if (checkInput(inputNum)) {
				boolean result = gameLogic.process(randNum, inputNum);
				if (result){
					System.out.println("게임 종료");
					break;
				}
			}
		}
	}

	@Override
	public boolean end() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
		return Console.readLine().trim().equals("2") ? true : false;
	}

	public Object input() {
		System.out.print("숫자를 입력해주세요 : ");
		return Console.readLine().chars()
			.mapToObj(value -> Character.getNumericValue(value))
			.distinct()
			.filter(integer -> integer <= 9)
			.filter(integer -> integer > 0)
			.collect(Collectors.toList());
	}

	private boolean checkInput(List<Integer> num) {
		if (num.size() == 3)
			return true;
		throw new IllegalArgumentException("입력 값이 유효하지 않습니다.");
	}

}
