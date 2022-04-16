package baseball.view;

import baseball.domain.BaseBall;
import baseball.domain.CompareResult;

import java.util.List;

public class GameView {
    private final InputReader inputReader;

    public GameView(InputReader inputReader) {
        this.inputReader = inputReader;
    }

    List<Integer> inputUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        return inputReader.readBallNumber();
    }

    public void showCompareResult(CompareResult compareResult) {
        if (compareResult.isNothing()) {
            System.out.println("낫싱");
            return;
        }
        String countString = createCountingString(compareResult);
        System.out.println(countString);
        if (compareResult.isSuccess()) {
            System.out.println(String.format("%d개의 숫자를 모두 맞히셨습니다! 게임 종료", BaseBall.BALL_SIZE));
        }
    }

    private String createCountingString(CompareResult compareResult) {
        String string = "";
        if (compareResult.getStrike() != 0) {
            string += compareResult.getStrike() + "스트라이크 ";
        }
        if (compareResult.getBall() != 0) {
            string += compareResult.getBall() + "볼";
        }
        return string;
    }
}
