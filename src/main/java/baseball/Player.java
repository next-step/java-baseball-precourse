package baseball;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Player {

    Set<String> set;
    List<String> inputs = new ArrayList<>();

    public void drawNumbers() throws IllegalArgumentException{
        MessagePrinter.printInputMessage();
        String read = readLine();
        MessagePrinter.printInputNumbers(read);

        if (validationCheck(read)) {
            inputs = getAsList(getSplit(read));
        }
    }

    private List<String> getAsList(String[] read) {
        return Arrays.asList(read);
    }

    private String[] getSplit(String read) {
        return read.split("");
    }

    public boolean validationCheck(String inputs) {

        String[] array = getSplit(inputs);

        checkLength(array);
        checkDuplicateNumber(array);
        checkInputsRange(array);
        return true;
    }

    private void checkInputsRange(String[] inputs) {

        int MIN_NUMBER = 1;
        int MAX_NUMBER = 9;

        for (String text : inputs) {

            try {
                int number = Integer.parseInt(text);
                if (number < MIN_NUMBER || number > MAX_NUMBER) {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(e);
            }

        }
    }

    private void checkLength(String[] array) {

        int NUMBER_SIZE = 3;

        if (array.length != NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplicateNumber(String[] array) {
        set = new HashSet<>(getAsList(array));

        if (array.length != set.size()) {
            throw new IllegalArgumentException();
        }
    }
}
