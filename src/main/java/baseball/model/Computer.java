package baseball.model;

import baseball.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.constant.BaseballProperties.GAME_SIZE;

public class Computer {

    List<Ball> answer;

    public Computer() {}

    public void shuffle() {
        answer = new ArrayList<>();
        List<Integer> uniqueRandomNumbers = new ArrayList<>(getUniqueRandomNumbers());
        for (int i = 0; i < GAME_SIZE; i++) {
            answer.add(new Ball(uniqueRandomNumbers.get(i)));
        }
    }

    private Set<Integer> getUniqueRandomNumbers() {
        Set<Integer> randomNumberSet = new HashSet<>();
        while (randomNumberSet.size() < GAME_SIZE) {
            randomNumberSet.add(RandomNumberGenerator.getRandomNumber());
        }
        return randomNumberSet;
    }

    public List<Ball> getAnswer() {
        return this.answer;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "answer=" + answer +
                '}';
    }
}
