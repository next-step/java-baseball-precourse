package baseball.view;

import baseball.common.GameState;
import baseball.common.NumberOption;
import baseball.controller.GameRule;
import baseball.domain.BaseballNumber;
import baseball.domain.Computer;
import baseball.domain.GameResult;
import baseball.domain.Player;
import baseball.exception.BaseballInputException;
import nextstep.utils.Console;

public class Game {

    private static GameState gameState;
    private static Computer computer;
    private static Player player;
    private static GameRule gameRule;

    public void startGame() {
        gameState = GameState.START;
        computer = new Computer();
        player = new Player();
        while (gameState != GameState.END) {
            inputPlayerNumber();
            checkStrikeBall();
            checkCurrent();
        }
    }

    private void inputPlayerNumber() {
        System.out.print("숫자를 입력해주세요: ");
        try {
            int inputNumber = Integer.parseInt(Console.readLine());
            BaseballNumber playerNumber = new BaseballNumber(inputNumber);
            player.setBaseballNumber(playerNumber);
            System.out.println(computer.getBaseballNumber().numberToString());
        } catch (BaseballInputException e) {
            System.out.println(e.getMessage());
            inputPlayerNumber();
        }
    }

    private void checkCurrent() {
        GameResult gameResult = gameRule.getResult();
        if (!NumberOption.MAX_SIZE.isEqualValue(gameResult.getStrike())) {
            return;
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
        gameState = GameState.END;
    }

    private void checkStrikeBall() {
        gameRule = new GameRule(player.getBaseballNumber(), computer.getBaseballNumber());
        GameResult gameResult = gameRule.getResult();
        checkStrike(gameResult);
        checkBall(gameResult);
        checkNothing(gameResult);
    }

    private void checkStrike(GameResult gameResult) {
        if (gameResult.getStrike() > NumberOption.ZERO.getValue()) {
            System.out.println(gameResult.getStrike() + "스트라이크");
        }
    }

    private void checkBall(GameResult gameResult) {
        if (gameResult.getBall() > NumberOption.ZERO.getValue()) {
            System.out.println(gameResult.getBall() + "볼");
        }
    }

    private void checkNothing(GameResult gameResult) {
        if (gameResult.getStrike() == NumberOption.ZERO.getValue()
                && gameResult.getBall() == NumberOption.ZERO.getValue()) {
            System.out.println("낫싱");
        }
    }
}
