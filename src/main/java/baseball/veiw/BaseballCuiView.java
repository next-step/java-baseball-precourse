package baseball.veiw;

import baseball.model.InningResultData;

public interface BaseballCuiView {
    void printInputNumber();
    void printInningResult(InningResultData inningResult);
    void printRestartQuestion();
    void printEnding(int strike);
}