package baseball;

import baseball.exceptions.InvalidInputLengthException;
import baseball.exceptions.DuplicateNumberException;
import baseball.exceptions.NoNumericException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {


    public static void validateEnterNumber(String input) {
        checkLength(input);
        checkDuplicate(input);
        checkNumeric(input);
    }

    private static void checkNumeric(String input) {
        if(!input.matches("[0-9]+")){
            throw new NoNumericException();
        }
    }

    private static void checkLength(String input) {
        if(input.length() != 3){
            System.out.println(input.length());
            throw new InvalidInputLengthException();
        }
    }
    private static void checkDuplicate(String input) {
        String[] inputs = input.split("");
        List<String> list = Arrays.asList(inputs);
        Set<String> set = new HashSet<>(list);
        if(set.size() !=3){
            throw new DuplicateNumberException();
        }
    }
}
