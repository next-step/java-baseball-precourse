import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameModel {
    private static final int NUM_OF_DIGIT = 3;

    final List<Integer> answer;
    final Map<Integer, Integer> numPosition = new HashMap<>();

    public GameModel(final RandomGenerator randomGenerator) {
        answer = randomGenerator.generateRandomNumber(NUM_OF_DIGIT);

        for (int i=0; i<answer.size(); i++) {
            numPosition.put(answer.get(i), i);
        }
    }

    public boolean isGameEnd(final String number) {
        return Integer.parseInt(number) == answer.get(0) * 100 + answer.get(1) * 10 + answer.get(2);
    }

    public int[] calculateGameResult(final String number) {
        final int[] gameResult = new int[2];

        for (int i=0; i<NUM_OF_DIGIT; i++) {
            final int numVal = Character.getNumericValue(number.charAt(i));

            if (!numPosition.containsKey(numVal))
                continue;

            if (numPosition.get(numVal) == i) {
                gameResult[0] += 1;
                continue;
            }

            gameResult[1] += 1;
        }

        return gameResult;
    }
}
