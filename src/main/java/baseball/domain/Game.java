package baseball.domain;

import baseball.domain.player.Player;
import baseball.domain.validator.InputFinishValidator;
import java.util.List;

public class Game {
    GameStatus gameStatus;
    GameRule gameRule;
    Player computer;
    Player user;
    GameResult gameResult;

    public Game(Player computer, Player user, GameRule gameRule) {
        this.gameStatus = GameStatus.INIT;
        this.gameRule = gameRule;
        this.computer = computer;
        this.user = user;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public GameStatus getGameStatus() {
        return this.gameStatus;
    }

    public boolean isEndGame() {
        return this.gameStatus == GameStatus.END;
    }

    public boolean isFinishGame() {
        return this.gameStatus == GameStatus.FINISH;
    }

    public boolean isPlayGame() {
        return this.gameStatus == GameStatus.PLAY;
    }

    public GameRule getGameRule() {
        return gameRule;
    }

    public void setGameRule(GameRule gameRule) {
        this.gameRule = gameRule;
    }

    public Player getComputer() {
        return computer;
    }

    public void setComputer(Player computer) {
        this.computer = computer;
    }

    public void setComputerNumbers(List<Integer> numbers) {
        computer.setNumbers(numbers);
    }

    public Player getUser() {
        return user;
    }

    public void setUser(Player user) {
        this.user = user;
    }

    public void playGame(List<Integer> inputNumbers) {
        if (gameStatus != GameStatus.PLAY) {
            gameStatus = GameStatus.PLAY;
        }
        user.setNumbers(inputNumbers);
        gameResult = new GameResult(computer.getNumbers(), user.getNumbers());
        if (gameResult.isWinning()) {
            this.setGameStatus(GameStatus.END);
        }
    }

    public GameResult getGameResult() {
        return gameResult;
    }

    public void checkFinish(String inputFinishInfo) {
        InputFinishValidator inputFinishValidator = new InputFinishValidator(1, 2, 1);
        if (inputFinishValidator.isInputValidate(inputFinishInfo)
                && Integer.parseInt(inputFinishInfo) == GameStatus.FINISH.ordinal()) {
            gameStatus = GameStatus.FINISH;
        }

    }
}
