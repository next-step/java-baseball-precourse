package baseball;

import static baseball.InputView.STOP;

public class ResultView {

    private final String resultMeassge;

    public ResultView(String resultMeassge) {
        this.resultMeassge = resultMeassge;
    }

    public String getResultMeassge() {
        return resultMeassge;
    }

    public boolean printResult() {
        System.out.println(resultMeassge);
        if (resultMeassge.equals("3스트라이크")
                && InputView.inputRestartNumber() == STOP) return false;
        return true;
    }
}
