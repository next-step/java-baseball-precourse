package baseball.view;

import baseball.domain.Hint;
import camp.nextstep.edu.missionutils.Console;

import java.util.Map;

public class ConsoleBaseballGameView implements BaseballGameView {
    @Override
    public String inputCandidateNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputNumber = Console.readLine();
        return inputNumber;
    }

    @Override
    public void displayResult(Map<Hint, Integer> hintMap) {
        StringBuilder sb = new StringBuilder();

        appendNothing(hintMap, sb);
        appendBall(hintMap, sb);
        appendStrike(hintMap, sb);

        System.out.println(sb);
    }

    @Override
    public String isContinueGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        String continueFlag = Console.readLine();

        return continueFlag;
    }

    @Override
    public void endGame() {
        System.out.println("게임 종료");
    }

    @Override
    public void correctAnswer() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private void appendStrike(Map<Hint, Integer> hintMap, StringBuilder sb) {
        if (hintMap.containsKey(Hint.스트라이크)) {
            Integer strikeCount = hintMap.get(Hint.스트라이크);
            sb.append(strikeCount);
            sb.append(Hint.스트라이크);
        }
    }

    private void appendBall(Map<Hint, Integer> hintMap, StringBuilder sb) {
        if (hintMap.containsKey(Hint.볼)) {
            Integer ballCount = hintMap.get(Hint.볼);
            sb.append(ballCount);
            sb.append(Hint.볼);
            sb.append(" ");
        }
    }

    private void appendNothing(Map<Hint, Integer> hintMap, StringBuilder sb) {
        if (hintMap.containsKey(Hint.아웃) && hintMap.get(Hint.아웃) == 3) {
            sb.append("낫싱");
        }
    }
}
