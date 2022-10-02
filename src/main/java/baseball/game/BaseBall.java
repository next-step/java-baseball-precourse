package baseball.game;

import baseball.computer.Score;
import baseball.computer.ScoreBag;

import java.util.List;

public class BaseBall implements Games {

    private final int MAX_SIZE = 3;

    private int strikeCount = 0;
    private int ballCount = 0;

    @Override
    public boolean play(ScoreBag sourceScores, ScoreBag scoreBag) {
        List<Score> inputScores = scoreBag.getScores();
        play(sourceScores.getScores(), inputScores);
        printResult();
        if (strikeCount == MAX_SIZE) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        clearCount();
        return false;
    }

    private void play(List<Score> scores, List<Score> inputScores) {
        checkStrike(scores, inputScores);
        checkBall(scores, inputScores);
    }

    private void checkStrike(List<Score> scores, List<Score> inputScores) {
        for (int i = 0; i < MAX_SIZE; i++) {
            checkStrike(scores.get(i), inputScores.get(i));
        }
    }

    private void checkStrike(Score source, Score input) {
        if (source.equals(input)) {
            strikeCount++;
        }
    }

    private void checkBall(List<Score> scores, List<Score> inputScores) {
        for (int i = 0; i < MAX_SIZE; i++) {
            checkBall(scores, inputScores.get(i));
        }
    }

    private void checkBall(List<Score> scores, Score inputScore) {
        for (Score score : scores) {
            checkBall(score, inputScore);
        }
    }

    private void checkBall(Score score, Score inputScore) {
        if (!score.equals(inputScore) && score.equalsScore(inputScore.getScore())) {
            ballCount++;
        }
    }

    private void printResult() {
        if (strikeCount == 0 && ballCount == 0) {
            System.out.println("낫싱");
            return;
        }
        print();
    }

    private void print() {
        StringBuilder resultMessage = new StringBuilder();
        appendBallMessage(resultMessage);
        appendStrikeMessage(resultMessage);
        System.out.println(resultMessage);
    }

    private void appendBallMessage(StringBuilder resultMessage) {
        if (ballCount != 0) {
            resultMessage.append(ballCount).append("볼").append(" ");
        }
    }

    private void appendStrikeMessage(StringBuilder resultMessage) {
        if (strikeCount != 0) {
            resultMessage.append(strikeCount).append("스트라이크");
        }
    }

    private void clearCount() {
        strikeCount = 0;
        ballCount = 0;
    }
}
