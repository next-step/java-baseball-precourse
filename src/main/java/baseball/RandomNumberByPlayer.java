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

    private boolean validationCheck(String inputs) {

        String[] array = getSplit(inputs);

        //TODO: validation check 더 추가 필요
        checkLength(array);
        checkDuplicateNumber(array);
        return true;
    }

    private void checkLength(String[] array) {
        if (array.length != 3) {
            throw new IllegalArgumentException();
        }
    }

    // TODO 숫자만 입력할 수 있도록 (1~9) 체크해야함
    // TODO 중복 체크 로직 넣어줘야 (사용자가 실수로 똑같은 숫자 넣을 수 있으니)
    // TODO 문자열 특수문자 등 걸러야 함
    // TODO interface 나 부모 클래스로 빼야한다.
    private void checkDuplicateNumber(String[] array) {
        set = new HashSet<>(getAsList(array));

        if (array.length != set.size()) {
            System.out.println("예외를 던진다.");
            throw new IllegalArgumentException();
        }
    }
}
