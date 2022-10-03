package baseball.view;

public class ComputerView {
    public void printPlayerBallResult(String result) {
        System.out.println(result);
    }

    public void printPlayerWin() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void printNothing() {
        System.out.println("낫싱");
    }
}