package baseball;

public class Application {
    public static void main(String[] args) {
        boolean gameEnd = true;
        while(gameEnd){
            BaseballGame baseballGame = new BaseballGame();
            gameEnd = baseballGame.start();
        }
    }
}
