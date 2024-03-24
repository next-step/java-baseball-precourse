package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameModel {
    private int[] numbers = new int[3];
    private boolean isGameInProgress;

    public void resetGame() {
        generateNumbers();
        this.isGameInProgress = true;
    }

    private void generateNumbers() {
        List<Integer> numCandidates = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            numCandidates.add(i);
        }

        Collections.shuffle(numCandidates);

        for (int i = 0; i < 3; i++) {
            numbers[i] = numCandidates.get(i);
        }
    }

    public Score calculateScore(int[] guess) {
        int strikes = 0;
        int balls = 0;
        for (int i = 0; i < 3; i++) {
            if (guess[i] == numbers[i]) {
                strikes += 1;
                continue;
            }

            if (contains(numbers, guess[i])) {
                balls += 1;
            }
        }
        return new Score(strikes, balls);
    }

    private boolean contains(int[] array, int value) {
        for (int item : array) {
            if (item == value) {
                return true;
            }
        }
        return false;
    }

    public int[] getNumbers() {
        return numbers;
    }

    public void setNumbers(int[] arr) {
        this.numbers = arr.clone();
    }

    public boolean isGameInProgress() {
        return isGameInProgress;
    }

    public void setGameInProgress(boolean gameInProgress) {
        isGameInProgress = gameInProgress;
    }
}