package baseball;

public class OutputView {

    private OutputView() {
        throw new IllegalStateException("생성자가 필요 없는 클래스입니다.");
    }

    static boolean show(PlayResult result, Balls balls) {
        if (result.getBall() > 0) {
            System.out.printf("%d볼 ", result.getBall());
        }
        if (result.getStrike() > 0) {
            System.out.printf("%d스트라이크", result.getStrike());
        }
        if (result.getStrike() == 0 && result.getBall() == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
        if (result.getStrike() == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return endGame(balls);
        }
        return false;
    }

    public static boolean endGame(Balls balls) {
        String option = InputView.showOptions();
        if (option.equals("2")) {
            return true;
        }
        balls.makeNumbers();
        return false;
    }
}
