package baseball.controller;

import baseball.model.Count;
import baseball.model.NumberBaseBall;
import baseball.service.Signal;
import baseball.util.Generator;
import baseball.view.DisplayBoard;
import camp.nextstep.edu.missionutils.Console;

public class NumberBaseBallGame {

    private boolean isGameOver = false;

    public void start() {
        NumberBaseBall answerNumberBaseBallGame = new NumberBaseBall(Generator.generate());

        while (!isGameOver) {
            NumberBaseBall inputNumberBaseBallGame = inputBaseBall();
            Count count = Signal.gesture(answerNumberBaseBallGame, inputNumberBaseBallGame);
            DisplayBoard.count(count);
            isGameOver = isGameOver(count);
            answerNumberBaseBallGame = isRestart(answerNumberBaseBallGame, count, isGameOver);
        }
    }

    private NumberBaseBall inputBaseBall() {
        DisplayBoard.input();
        return new NumberBaseBall(Console.readLine());
    }

    private boolean isGameOver(Count count) {
        if (count.getStrike() == 3) {
            DisplayBoard.gameOver();
            return DisplayBoard.playAgain();
        }
        return false;
    }

    private NumberBaseBall isRestart(NumberBaseBall answerNumberBaseBallGame, Count count,
                                            Boolean isGameOver) {
        if (count.getStrike() == 3 && !isGameOver) {
            return new NumberBaseBall(Generator.generate());
        }
        return answerNumberBaseBallGame;
    }
}
