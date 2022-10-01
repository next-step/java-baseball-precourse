package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompareBalls {

    public static int countStrikes(String computerBalls, String playerBalls) {
        if(computerBalls.equals(playerBalls)) {
            return GameConstants.numberOfBalls;
        }

        int result = 0;

        String[] arrComputerBalls = convertStringToArray(computerBalls);
        String[] arrPlayerBalls = convertStringToArray(playerBalls);

        for (int i = 0; i < GameConstants.numberOfBalls; i++) {
            result += isStrike(arrComputerBalls[i], arrPlayerBalls[i]);
        }

        return result;
    }

    public static int countBalls(String computerBalls, String playerBalls) {
        int total = countEqualNumbers(computerBalls, playerBalls);
        return total - countStrikes(computerBalls, playerBalls);
    }


    private static int isStrike(String computerBall, String playerBall) {
        return computerBall.equals(playerBall) ? 1 : 0;
    }
    private static int countEqualNumbers(String computerBalls, String playerBalls) {
        int total = 0;
        List<String> mappedComputerBalls = new ArrayList<>(Arrays.asList(convertStringToArray(computerBalls)));
        List<String> mappedPlayerBalls = new ArrayList<>(Arrays.asList(convertStringToArray(playerBalls)));

        for (int i = 0; i < GameConstants.numberOfBalls; i++) {
            total += isContain(mappedComputerBalls, mappedPlayerBalls.get(i));
        }

        return total;
    }

    private static int isContain(List<String> computerBalls, String playerBall) {
        return computerBalls.contains(playerBall) ? 1 : 0;
    }

    private static String[] convertStringToArray(String source) {
        return source.split("");
    }

}
