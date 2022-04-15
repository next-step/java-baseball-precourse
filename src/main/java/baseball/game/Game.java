package baseball.game;

import java.util.*;

import static baseball.game.GameConfig.NUM_NUMBERS;

public class Game {

    private Game() { }

    static GuessingJudgment checkAnswer(GameState state, int num, int indexOfNum) {
        if (!state.getComputerNumbers().contains(num)) {
            return GuessingJudgment.NONE;
        }
        int index = state.getComputerNumbers().getIndexOf(num);
        return index == indexOfNum ? GuessingJudgment.STRIKE : GuessingJudgment.BALL;
    }

    static ScoringResults judge(GameState state, NumberToIndex answer) {
        ScoringResults score = new ScoringResults();
        Iterator<Integer> answerIterator = answer.numberIterator();

        while (answerIterator.hasNext()) {
            int n = answerIterator.next();
            int i = answer.getIndexOf(n);
            GuessingJudgment result = checkAnswer(state, n, i);
            score.addJudgment(result);
        }
        return score;
    }

    private static ScoringResults process(GameState state, String input) {
        NumberToIndex answer = new NumberToIndex(input);
        return judge(state, answer);
    }

    private static boolean isGameOver(ScoringResults score) {
        return score.getNumStrikes() == NUM_NUMBERS;
    }

    public static void play(GameState state) {
//        GameUtil.println(computerNumbers);
        boolean isOver = false;

        while (!isOver) {
            GameUtil.print(GameMessage.prompt());
            String line = GameUtil.readLine();

            ScoringResults score = process(state, line);
            isOver = isGameOver(score);

            String message = GameMessage.resultMessage(score.getNumStrikes(), score.getNumBalls());
            GameUtil.println(message);
        }
    }
}
