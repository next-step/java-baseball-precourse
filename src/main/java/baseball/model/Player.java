package baseball.model;

import baseball.view.MessagePrinter;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Player {

    public Set<String> set;
    public List<String> inputs = new ArrayList<>();

    public List<String> getNumbers() throws IllegalArgumentException {
        MessagePrinter.printInputMessage();
        String read = readLine();
        MessagePrinter.printInputNumbers(read);

        if (validationCheck(read)) {
            inputs = getAsList(getSplit(read));
        }
        return inputs;
    }

    private List<String> getAsList(String[] read) {
        return Arrays.asList(read);
    }

    private String[] getSplit(String read) {
        return read.split("");
    }

    public boolean validationCheck(String inputs) {
        String[] inputArray = getSplit(inputs);
        checkLength(inputArray);
        checkDuplicateNumber(inputArray);
        for (String input : inputArray) {
            checkInputsNumber(input);
            checkInputsRange(input);
        }
        return true;
    }

    private void checkInputsRange(String input) {
        int MIN_NUMBER = 1;
        int MAX_NUMBER = 9;
        int number = Integer.parseInt(input);

        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    private void checkInputsNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
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
