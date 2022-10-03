package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import baseball.utility.InputValidation;
import camp.nextstep.edu.missionutils.Randoms;

public class Board {
	private List<Ball> board;
	public Board() {
		this.board = makeNewComputerBoard();
	}

	public Board(String inputNumber) {
		this.board = makeUserBoard(inputNumber);
	}

	private static List<Ball> makeNewComputerBoard() {
		List<Ball> ballList = new ArrayList<>();
		HashSet<Integer> numberSet = new HashSet<>();
		for(int i = 0; i < 3; i++) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if(numberSet.contains(randomNumber)) {
				i--;
				continue;
			}
			numberSet.add(randomNumber);
			ballList.add(new Ball(randomNumber, i));
		}
		return ballList;
	}

	private static List<Ball> makeUserBoard(String inputNumber) {
		InputValidation.validIntegerFormat(inputNumber);
		List<Ball> ballList = new ArrayList<>();
		for(int i = 0 ; i < 3; i++) {
			ballList.add(new Ball(inputNumber.charAt(i) - '0', i));
		}
		return ballList;
	}


	public Result compareBoard(Board userBoard) {
		Result gameResult = new Result();
		for(Ball ball : userBoard.board) {
			Status status = ball.compareBall(this.board);
			gameResult.addResult(status);
		}
		return gameResult;
	}


}
