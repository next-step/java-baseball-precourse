package baseball.view;

import baseball.common.GameState;
import baseball.domain.BaseballNumber;
import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.exception.BaseballInputException;
import nextstep.utils.Console;

public class Game {

    private static GameState gameState;
    private static Computer computer;
    private static Player player;

    public void startGame() {
        gameState = GameState.START;
        computer = new Computer();
        player = new Player();
        inputPlayerNumber();
    }

    private void inputPlayerNumber() {
        System.out.print("숫자를 입력해주세요: ");
        try {
            int inputNumber = Integer.parseInt(Console.readLine());
            player.setBaseballNumber(new BaseballNumber(inputNumber));
        } catch (BaseballInputException e) {
            System.out.println(e.getMessage());
            inputPlayerNumber();
        }
    }
}
