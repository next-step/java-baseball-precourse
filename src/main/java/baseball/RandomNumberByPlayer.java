package baseball;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class RandomNumberByPlayer {

    Set<String> set;
    List<String> inputs = new ArrayList<>();

    public void drawNumbers() throws IllegalArgumentException{
        System.out.print("숫자를 입력해주세요 : ");
        String read = readLine();
        System.out.println(read);

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

        //TODO: validation check 더 추가 필요
        checkLength(array);
        checkDuplicateNumber(array);
        checkInputsRange(array);
        return true;
    }

    private void checkInputsRange(String[] array) {
        for (String text : array) {
            try {
                int number = Integer.parseInt(text);
                if (number <= 0 || number >= 10) {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(e);
            }

        }
    }

    private void checkLength(String[] array) {
        if (array.length != 3) {
            throw new IllegalArgumentException();
        }
    }

    // TODO interface 나 부모 클래스로 빼야한다.
    private void checkDuplicateNumber(String[] array) {
        set = new HashSet<>(getAsList(array));

        if (array.length != set.size()) {
            System.out.println("예외를 던진다.");
            throw new IllegalArgumentException();
        }
    }
}
