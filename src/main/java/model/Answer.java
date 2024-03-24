package model;

import java.util.Arrays;
import java.util.Random;

public class Answer {
    public static final int ANSWER_LENGTH = 3;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;
    private final Random random = new Random();
    private final int[] numberList = new int[MAX_NUMBER-MIN_NUMBER+2];

    {
        setRandomNumberList();
    }

    public void setRandomNumberList() {
        Arrays.fill(numberList,0);
        for (int i = 1; i <= ANSWER_LENGTH; i++) {
            int randomNumber = random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
            if (numberList[randomNumber] != 0) {
                i--;
                continue;
            }
            numberList[randomNumber] = i;
        }
    }

    public void setNumberList(String numbers) {
        Arrays.fill(numberList,0);
        for (int i = 0; i < ANSWER_LENGTH; i++) {
            numberList[numbers.charAt(i) - '0'] = i + 1;
        }
    }

    public int[] getNumberList() {
        return numberList;
    }


    public boolean isStrike(int number, int index) {
		return numberList[number] == index;
	}

    public boolean isBall(int number, int index) {
        return numberList[number] != index && numberList[number] > 0;
    }
}