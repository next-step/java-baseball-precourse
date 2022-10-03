package baseball.model;

import java.util.*;

import static camp.nextstep.edu.missionutils.Randoms.*;

public class Ball {
    final int minNumber = 1;
    final int maxNumber = 9;
    final int size = 3;

    public int generateBallNumber() {
        Set<Integer> tempBallNumbers = new LinkedHashSet<>();

        while (tempBallNumbers.size() < size) {
            int randomNumber = pickNumberInRange(minNumber, maxNumber);
            tempBallNumbers.add(randomNumber);
        }

        int[] numberArray = convertSetToIntArray(tempBallNumbers);
        return convertIntArrayToInt(numberArray);
    }

    public boolean validateBallNumber(int ballNumber) {
        String str = Integer.toString(ballNumber);
        str = str.replace("0", "");
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            set.add((int) str.charAt(i));
        }

        return str.length() == size && set.size() == size;
    }

    private int[] convertSetToIntArray(Set<Integer> tempBallNumbers) {
        int[] result = new int[size];
        int i = 0;

        for (Integer tempBallNumber : tempBallNumbers) {
            result[i] = tempBallNumber;
            i++;
        }
        return result;
    }

    private int convertIntArrayToInt(int[] numbers) {
        StringBuilder builder = new StringBuilder();
        for (int num : numbers) {
            builder.append(num);
        }

        return Integer.parseInt(builder.toString());
    }
}
