package gameLogics;

import java.util.ArrayList;
import java.util.List;

import static gameLogics.BaseRule.GAME_NUMBER_LENGTH;

public class UserInputProcessor {

    public static boolean validateInputString(String userInput) {
        userInput = userInput.trim();
        List<Character> ans = new ArrayList<>();
        int idx = -1;
        if (userInput.length() != GAME_NUMBER_LENGTH) {
            return false;
        }
        while (++idx < GAME_NUMBER_LENGTH) {
            if ((!Character.isDigit(userInput.charAt(idx))) || ans.contains(userInput.charAt(idx)))
                return false;
            ans.add(userInput.charAt(idx));
        }
        return true;
    }

    public static List<Integer> digestValidatedInputString(String userInput) {
        List<Integer> result = new ArrayList<>();
        userInput = userInput.trim();
        int idx = -1;
        while (++idx < GAME_NUMBER_LENGTH) {
            result.add(Character.getNumericValue(userInput.charAt(idx)));
        }
        return result;
    }
}
