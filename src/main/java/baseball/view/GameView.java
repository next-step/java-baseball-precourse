package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import static baseball.constant.BaseballProperties.GAME_SIZE;

public class GameView {

    public String getInputNumber() {
        return Console.readLine();
    }

    public void requireInput() {
        System.out.print("숫자를 입력해주세요: ");
    }

    public void printFinish() {
        System.out.println(GAME_SIZE + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면1, 종료하려면 2를 입력하세요.");
    }

    public void printGuessResult(String guessResult) {
        System.out.println(guessResult);
    }

    public void exit() {
        System.exit(0);
    }
}
