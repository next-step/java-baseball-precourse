package baseball;

public class Game {
    public void play() {
        start();
        progress();
        end();
    }

    private void start() {
        System.out.println("게임 시작");
    }

    private void progress() {
        System.out.println("게임 진행");
    }

    private void end() {
        System.out.println("게임 종료");
    }
}
