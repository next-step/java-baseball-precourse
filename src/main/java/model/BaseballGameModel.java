package model;

import java.util.Random;

public class BaseballGameModel {
    private int[] baseballNumbers;

    public void generateNumbers() {
        Random random = new Random();
        baseballNumbers = new int[3];
        boolean[] visited = new boolean[10];

        for (int i = 0; i < 3; i++) {
            int number = random.nextInt(9) + 1;
            if (visited[number]) {
                i--;
                continue;
            }
            baseballNumbers[i] = number;
            visited[number] = true;
        }
    }

    public int[] getBaseballNumbers() {
        return baseballNumbers;
    }

    public int[] compareNumbers(int[] userNumbers) {
        int[] result = new int[2]; // [0]은 스트라이크, [1]은 볼 개수
        boolean[] visited = new boolean[10];

        for (int i = 0; i < 3; i++) {
            visited[baseballNumbers[i]] = true;
        }

        for (int i = 0; i < 3; i++) {
            if (userNumbers[i] == baseballNumbers[i]) {
                result[0]++; // 스트라이크
                continue;
            }
            if (visited[userNumbers[i]]) {
                result[1]++; // 볼
            }
        }

        return result;
    }
}
