package baseball.game;

import java.util.*;

import static baseball.game.GameConfig.NUM_NUMBERS;

public class Game {

    private Game() { }

    static Judgment checkAnswer(GameState state, int num, int indexOfNum) {
        if (!state.getComputerNumbers().contains(num)) {
            return Judgment.NONE;
        }
        int index = state.getComputerNumbers().getIndexOf(num);
        return index == indexOfNum ? Judgment.STRIKE : Judgment.BALL;
    }

    static RoundScore judge(GameState state, NumberToIndex answer) {
        RoundScore score = new RoundScore();
        Iterator<Integer> answerIterator = answer.numberIterator();

        while (answerIterator.hasNext()) {
            int n = answerIterator.next();
            int i = answer.getIndexOf(n);
            Judgment result = checkAnswer(state, n, i);
            score.addJudgment(result);
        }
        return score;
    }

    private static RoundScore process(GameState state, String input) {
        NumberToIndex answer = new NumberToIndex(input);
        return judge(state, answer);
    }

    private static boolean isGameOver(RoundScore score) {
        return score.getNumStrikes() == NUM_NUMBERS;
    }

    public static void play(GameState state) {
//        GameUtil.println(computerNumbers);
        boolean isOver = false;

        while (!isOver) {
            GameUtil.print(GameMessage.prompt());
            String line = GameUtil.readLine();

            RoundScore score = process(state, line);
            isOver = isGameOver(score);

            String message = GameMessage.resultMessage(score.getNumStrikes(), score.getNumBalls());
            GameUtil.println(message);
        }
    }
}
