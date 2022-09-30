package baseball.controller;

import baseball.contract.Message;
import baseball.model.computer.Computer;
import baseball.model.game.Game;
import baseball.model.player.Player;

import static baseball.contract.Config.BALL_NUMBER_LENGTH;

public class GameController {
    private final Game game = new Game();
    private Computer computer = new Computer();
    private final Player player = new Player();

    public void play() {
        do {
            playGame();
        } while (game.isRunning);
    }

    public void playGame() {
        System.out.print(Message.PLAY);
        String playerInput = player.inputNum();

        String result = game.compareBall(playerInput, computer.getBall());
        System.out.println(result);
        if (result.equals(BALL_NUMBER_LENGTH + Message.STRIKE)) {
            System.out.println(Message.MATCH);
            endGame();
        }
    }

    public void endGame() {
        game.setRunning(false);

        System.out.println(Message.REPLAY);
        selectMenuGame();
    }

    public void selectMenuGame() {
        String result = player.selectMenu();
        if (result.equals("1")) {
            this.replayGame();
        }

        if (result.equals("2")) {
            System.out.println(Message.END);
        }
    }

    public void replayGame() {
        game.setRunning(true);
        this.computer = new Computer();
        this.play();
    }
}
