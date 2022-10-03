package baseball;


import baseball.game.BaseballPlay;

public class Application {
    public static void main(String[] args) {
        BaseballPlay baseballPlay = BaseballPlay.getInstance();
        baseballPlay.run();
    }
}
