package baseball.view;

import baseball.domain.GameState;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public static String inputPlayerNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        return readLine();
    }

    public static GameState inputWhetherRestartGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return GameState.getGameState(readLine());
    }
}
