package baseball.view;

import baseball.score.Score;

import java.util.Map;

public class ResultView {
    private static final int COUNT_OF_NONE = 0;
    private static final int COUNT_OF_ALL = 3;

    private ResultView() {

    }

    public static void printResult(Map<Score, Integer> scoreEnumIntegerMap) {
        StringBuilder stringBuilder = new StringBuilder();
        if (hasScore(scoreEnumIntegerMap, Score.BALL)) {
            stringBuilder.append(scoreEnumIntegerMap.get(Score.BALL)).append("볼").append(" ");
        }

        if (hasScore(scoreEnumIntegerMap, Score.STRIKE)) {
            stringBuilder.append(scoreEnumIntegerMap.get(Score.STRIKE)).append("스트라이크");
        }

        if (scoreEnumIntegerMap.get(Score.NOTHING) == COUNT_OF_ALL) {
            stringBuilder.append("낫싱");
        }

        System.out.println(stringBuilder);
    }

    private static boolean hasScore(Map<Score, Integer> scoreEnumIntegerMap, Score score) {
        return scoreEnumIntegerMap.get(score) != COUNT_OF_NONE;
    }

    public static void printDone() {
        System.out.print("3개의 숫자를 모두 맞히셨습니다! ");
        System.out.println("게임 종료");
    }
}
