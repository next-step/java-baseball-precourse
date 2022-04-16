package baseball.view;

import baseball.domain.BaseBall;
import baseball.domain.CompareResult;

import java.util.List;

public class GameView {
    private final InputReader inputReader;

    public GameView(InputReader inputReader) {
        this.inputReader = inputReader;
    }

    public List<Integer> inputUserNumber() {
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
        if (compareResult.getBall() != 0) {
            string += compareResult.getBall() + "볼 ";
        }
        if (compareResult.getStrike() != 0) {
            string += compareResult.getStrike() + "스트라이크";
        }
        return string;
    }

    public boolean askReGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return inputReader.readReGameFlag();
    }
}
