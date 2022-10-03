package baseball.ui;

public class StandardOutput implements Output {

    @Override
    public void printResult(String GameResultString) {
        System.out.println(GameResultString);
    }

    @Override
    public void printFinish() {
        System.out.println("게임 종료");
    }
}
