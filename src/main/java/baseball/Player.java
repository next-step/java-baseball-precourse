package baseball;

import nextstep.utils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player {
    private final List<Integer> playNumbers;

    Player() {
        boolean isValidateStr = false;
        String userInput = "";

        while (!isValidateStr) {
            System.out.print(OutputView.INPUT_NUMBERS);
            userInput = Console.readLine();
            isValidateStr = checkPlayerNumberStr(userInput);
        }

        playNumbers =  convertStringToListInteger(userInput);
    }

    public List<Integer> getPlayerNumbers() {
        return playNumbers;
    }

    public static boolean checkPlayerNumberStr(String str) {
        try{
            return checkInputLength(str)  && checkDuplicate(str) && checkNumberValidate(str);
        } catch (UserInputNumberException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    public static boolean checkInputLength(String str) throws UserInputNumberException {
        if(str.length() == GameRule.MAX_LENGTH) {
            return true;
        }
        throw UserInputNumberException.ERR_INPUT_LENGTH;
    }

    public static boolean checkNumberValidate(String str) throws UserInputNumberException {
        String regex = String.format("[%d-%d]{%d}", GameRule.MIN_VALUE, GameRule.MAX_VALUE, GameRule.MAX_LENGTH);

        if (str.matches(regex)) {
            return true;
        }
        throw UserInputNumberException.ERR_NUMBER_VALIDATE;
    }

    public static boolean checkDuplicate(String str) throws  UserInputNumberException {
        Set<Character> checkStrSet = new HashSet<>();
        char[] charArr = str.toCharArray();

        for (char c : charArr) {
            checkStrSet.add(c);
        }

        if (checkStrSet.size() != GameRule.MAX_LENGTH) {
            throw UserInputNumberException.ERR_DUPLICATE_VALUE;
        }

        return true;
    }

    private List<Integer> convertStringToListInteger(String userStr) {
        List<Integer> userNumbers = new ArrayList<>();
        char[] userInputChars = userStr.toCharArray();

        for (char userInputChar : userInputChars) {
            userNumbers.add(Character.getNumericValue(userInputChar));
        }

        return userNumbers;
    }


}
