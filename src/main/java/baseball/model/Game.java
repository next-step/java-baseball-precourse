package baseball.model;

import baseball.view.GameView;

public class Game {
    Computer computer;
    Player player;
    GameView gameView;
    boolean playing;

    public Game(Computer computer, Player player, GameView gameView) {
        this.computer = computer;
        this.player = player;
        this.gameView = gameView;
        this.playing = true;
    }

    public void play() {
        while (playing) {
            computer.generateBallNumber();

            progress();

            gameView.printProceedWithTheGameGuide();
            playing = playContinue(player.input());
        }
    }

    public void progress() {
        boolean end = false;

        while (!end) {
            gameView.printPlayerInputGuide();

            int inputNumber = player.input();
            player.validateInputBallNumber(inputNumber);

            end = computer.judgmentPlayerBall(player.getBallNumber());
        }
    }

    private boolean playContinue(int inputNumber) {
        if (inputNumber != 1 && inputNumber != 2) {
            throw new IllegalArgumentException("입력값은 1이거나 2를 입력해야합니다. 입력값 : " + inputNumber);
        }

        return inputNumber == 1;
    }
}
