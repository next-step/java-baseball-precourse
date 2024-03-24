package baseball.domain;

import java.util.Random;

public class Computer {
    public Baseball generateRandomNumbers() {
        Random random = new Random();
        StringBuilder randomNumbers = new StringBuilder();

        while (randomNumbers.length() < 3) {
            int randomNumber = random.nextInt(9) + 1;
            if (!randomNumbers.toString().contains(Integer.toString(randomNumber))) {
                randomNumbers.append(randomNumber);
            }
        }

        return new Baseball(randomNumbers.toString());
    }

}
