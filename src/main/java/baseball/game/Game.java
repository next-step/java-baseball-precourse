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

    private static void play(GameState state) {
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

    public static void run() {
        String input = "1";
        while (Objects.equals(input, "1") && !Objects.equals(input, "2")) {
            play(new GameState());
            GameUtil.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            input = GameUtil.readLine();
        }
        if (!Objects.equals(input, "2")) {
            throw new IllegalArgumentException("wrong input");
        }
    }
}
