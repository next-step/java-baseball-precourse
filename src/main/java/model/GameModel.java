package model;

public class GameModel {

    private BaseballNumber target;

    public GameModel() {
        reset();
    }

    public void reset() {
        this.target = BaseballNumber.of(GameNumberGenerator.generate());
    }

    public GameResult getResult(BaseballNumber guess) {
        return GameResultCalculator.calculate(target, guess);
    }
}
