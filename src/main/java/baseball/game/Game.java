package baseball.game;

import java.util.*;

import static baseball.game.GameConfig.NUM_NUMBERS;

public class Game {
    private final NumberToIndex computerNumbers = new NumberToIndex();

    public Game() {
        computerNumbers.putAll(GameUtil.randomNumbers(NUM_NUMBERS, 1, 9));
    }

    private GuessingJudgment checkAnswer(int num, int indexOfNum) {
        if (!computerNumbers.contains(num)) {
            return GuessingJudgment.NONE;
        }
        int index = computerNumbers.getIndexOf(num);
        return index == indexOfNum ? GuessingJudgment.STRIKE : GuessingJudgment.BALL;
    }

    private ScoringResults judge(NumberToIndex answer) {
        ScoringResults score = new ScoringResults();
        Iterator<Integer> answerIterator = answer.numberIterator();

        while (answerIterator.hasNext()) {
            int n = answerIterator.next();
            int i = answer.getIndexOf(n);
            GuessingJudgment result = checkAnswer(n, i);
            score.addJudgment(result);
        }
        return score;
    }

    private ScoringResults process(String input) {
        NumberToIndex answer = new NumberToIndex(input);
        return judge(answer);
    }

    private boolean isGameOver(ScoringResults score) {
        return score.getNumStrikes() == NUM_NUMBERS;
    }

    public void play() {
//        GameUtil.println(computerNumbers);
        boolean isOver = false;

        while (!isOver) {
            GameUtil.print(GameMessage.prompt());
            String line = GameUtil.readLine();

            ScoringResults score = process(line);
            isOver = isGameOver(score);

            String message = GameMessage.resultMessage(score.getNumStrikes(), score.getNumBalls());
            GameUtil.println(message);
        }
    }
}
