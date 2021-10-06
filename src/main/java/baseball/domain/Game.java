package baseball.domain;

public class Game {

    private final RandomGenerator randomGenerator;
    private Numbers randomNumbers;

    public Game(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
        this.update();
    }

    public Score input(String value) {;
        Numbers numbers = new Numbers(value);
        ScoreFactory factory = ScoreFactory.of();
        return factory.getScore(randomNumbers, numbers);
    }

    public void update() {
        this.randomNumbers = new Numbers(randomGenerator.getValue());
    }

    public Numbers getRandomNumbers() {
        return randomNumbers;
    }
}
