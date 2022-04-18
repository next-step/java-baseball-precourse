package baseball;

public class Application {
    private static int computerNumber = -1;

    public static void main(String[] args) {
        boolean isNumberBaseballGameStart = true;
        while (isNumberBaseballGameStart) {
            int gamePlayerNumber = InputView.inputGamePlayerNumber();
            NumberBaseballGame numberBaseballGame = NumberBaseballGame.of(gamePlayerNumber, computerNumber);
            computerNumber = numberBaseballGame.getComputerNumber();
            ResultView resultView = numberBaseballGame.decideScore();
            isNumberBaseballGameStart = resultView.printResult();
            initComputerNumber(resultView);
        }
    }

    private static void initComputerNumber(ResultView resultView) {
        if (resultView.getResultMeassge().contains("3스트라이크")) computerNumber = -1;
    }
}
