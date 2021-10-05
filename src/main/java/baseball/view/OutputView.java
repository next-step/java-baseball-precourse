package baseball.view;

public class OutputView {
    public void displayResults(String gameResult) {
        System.out.println(gameResult);
    }

    public void displayWin() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
    }

    public void displayErrorMessage() {
        System.out.println("[ERROR] 잘못 입력하셨습니다. 숫자 3자리를 입력해주세요.");
    }
}
