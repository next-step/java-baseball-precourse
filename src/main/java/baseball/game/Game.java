package baseball.game;

import baseball.game.util.Console;

import java.util.*;

import static baseball.game.GameConfig.NUM_DIGITS;

class Game {
    private final GameState state;

    Game() {
        state = new GameState();
    }

    static Judgment checkAnswer(NumberToIndex opponent, int digit, int indexOfDigit) {
        if (!opponent.contains(digit)) {
            return Judgment.NONE;
        }
        int index = opponent.getIndexOf(digit);
        return index == indexOfDigit ? Judgment.STRIKE : Judgment.BALL;
    }

    static RoundScore judge(NumberToIndex opponent, NumberToIndex answer) {
        RoundScore score = new RoundScore();
        Iterator<Integer> answerIterator = answer.numberIterator();

        while (answerIterator.hasNext()) {
            int n = answerIterator.next();
            int i = answer.getIndexOf(n);
            Judgment result = checkAnswer(opponent, n, i);
            score.addJudgment(result);
        }
        return score;
    }

    private static RoundScore process(GameState state, String input) {
        NumberToIndex answer = GameUtil.parseDigitsFrom(input);
        return judge(state.getComputersDigits(), answer);
    }

    private static boolean isGameOver(RoundScore score) {
        return score.getNumStrikes() == NUM_DIGITS;
    }

    void play() {
//        GameUtil.println(state.getComputersDigits());
        boolean isOver = false;

        while (!isOver) {
            Console.print(GameMessage.PROMPT.get());
            String input = Console.readLine();

            RoundScore score = process(state, input);
            isOver = isGameOver(score);

            String message = GameMessage.resultMessage(score.getNumStrikes(), score.getNumBalls());
            Console.println(message);
        }
    }
}
