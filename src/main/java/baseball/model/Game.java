package baseball.model;

import java.util.List;

public class Game {
    private final Computer computer;
    private final Player player;
    private final GameResult gameResult;

    public Game(Computer computer, Player player) {
        this.computer = computer;
        this.player = player;
        this.gameResult = GameResult.init();
    }

    public GameResult play() {
        List<Integer> playerNumbers = player.numbers();
        for (int i = 0; i < playerNumbers.size(); i++) {
            JudgeResult judgeResult = computer.judge(i, playerNumbers.get(i));
            gameResult.addJudgeResult(judgeResult);
        }
        return gameResult;
    }
}
