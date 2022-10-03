package baseball;

import baseball.model.*;
import baseball.view.ComputerView;
import baseball.view.GameView;

public class Application {
    public static void main(String[] args) {
        Computer aComputer = new Computer(new Ball(), new BallJudgment(), new ComputerView());
        Player aPlayer = new Player(new Ball());
        Game aGame = new Game(aComputer, aPlayer, new GameView());

        aGame.play();
    }
}
