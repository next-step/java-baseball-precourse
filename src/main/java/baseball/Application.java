package baseball;

import baseball.model.GameSystem;

public class Application {
    public static void main(String[] args) {
        GameSystem gameSystem = new GameSystem();
        gameSystem.runGameSystem();
    }
}
