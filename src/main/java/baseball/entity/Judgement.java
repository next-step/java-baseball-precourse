package baseball.entity;

import java.util.List;

public class Judgement {
    private int strikeCount = 0;
    private int ballCount = 0;
    private StringBuilder sb;

    public String matchNumbers(List<Integer> computerNumbers, String playerNumbers) {
        sb = new StringBuilder();
        int idx = 0;
        for (int z = 0; z < playerNumbers.length(); z++) {
            compareNumbers(computerNumbers, playerNumbers, idx, z);
            idx++;
        }
        return getScoreResult();
    }

    private void compareNumbers(List<Integer> computerNumbers, String playerNumbers, int idx, int z) {
        compareNumbersAndIndex(computerNumbers, playerNumbers, idx, z);
    }

    private void compareNumbersAndIndex(List<Integer> computerNumbers, String playerNumbers, int idx, int z) {
        if (computerNumbers.get(idx) == playerNumbers.charAt(z) - '0' && idx == z) {
            strikeCount++;
        }
        if (computerNumbers.get(idx) != playerNumbers.charAt(z) - '0') {
            countBall(computerNumbers, playerNumbers, z);
        }
    }

    private void countBall(List<Integer> computerNumbers, String playerNumbers, int z) {
        if (computerNumbers.contains(playerNumbers.charAt(z) - '0')) {
            ballCount++;
        }
    }

    private String getScoreResult() {
        if (strikeCount != 0 && ballCount != 0) {
            return sb.append(ballCount).append("볼 ").append(strikeCount).append("스트라이크").toString();
        }
        if (ballCount != 0) {
            return sb.append(ballCount).append("볼").toString();
        }
        if (strikeCount != 0) {
            return sb.append(strikeCount).append("스트라이크").toString();
        }
        return sb.append("낫싱").toString();
    }

}
