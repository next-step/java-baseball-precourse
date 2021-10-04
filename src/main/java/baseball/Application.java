package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현
        Controller game = new Controller();
        System.out.println("prigram start");
        while(true) {
            game.run();
        }
    }
}
