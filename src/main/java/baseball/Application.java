package baseball;


public class Application {
    public static void main(String[] args) {
        GameTemplate baseball = new BaseBallGame();
        while(baseball.run()){
            baseball = new BaseBallGame();
        }
    }
}
