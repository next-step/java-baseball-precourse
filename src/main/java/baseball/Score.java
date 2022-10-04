package baseball;

import java.util.List;
import java.util.Objects;

public class Score {
    public int[] score;

    public Score(List<Integer> computer, List<Integer> user) {
        score = new int[Config.MAX_NUMBER];
        setScore(computer, user);
    }

    private void setScore(List<Integer> computer, List<Integer> user) {
        for (int i = 0; i < computer.size(); i++) {
            isStrikeOrBall(computer, user, i);
        }
    }

    private void isStrikeOrBall(List<Integer> computer, List<Integer> user, int i) {
        if (Objects.equals(computer.get(i), user.get(i))) {
            score[GameType.스트라이크.index] += 1;

            return;
        }

        if (computer.contains(user.get(i))) {
            score[GameType.볼.index] += 1;
        }
    }

    public String getResult() {
        String result = getTypesScore();

        if ("".equals(result)) {
            result = GameType.낫싱.name();
        }

        return result;
    }

    public String getTypesScore() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < GameType.values().length - 1; i++) {
            result.append(getTypeScore(GameType.values()[i]));
        }

        return result.toString().trim();
    }

    public String getTypeScore(GameType type) {
        if (this.score[type.index] > 0) {
            return String.format("%d%s ", this.score[type.index], type.name());
        }

        return "";
    }
}
