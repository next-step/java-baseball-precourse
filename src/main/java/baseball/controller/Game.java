package baseball.controller;

import baseball.model.Computer;
import baseball.model.GameState;
import baseball.model.Player;
import baseball.model.Umpire;
import baseball.view.View;

public class Game {
    public static final int BALL_MIN_NUMBER = 1;
    public static final int BALL_MAX_NUMBER = 9;
    public static final int BALL_INPUT_SIZE = 3;

    private GameState gameState;
    private Computer computer;
    private Player player;
    private Umpire umpire;

    public void run() {
        do {
            this.computer = new Computer();
            this.player = new Player();
            this.umpire = new Umpire();
            computer.generateBalls();
            play();
        } while (GameState.isPlayGame(View.inputRestart()));
    }

    public void play() {
        setGameState(GameState.PLAY);

        do {
            player.inputBalls(View.inputPlayer());
            umpire.initGame(computer.balls(), player.balls());
            setGameState(umpire.judge());
            View.resultMessage(umpire.result());
        } while (GameState.isDefeatGame(gameState));

        View.victoryMessageBy(gameState);
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }
}
