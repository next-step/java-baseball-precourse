package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static Computer instance;
    private String number;

    private Computer() {
        number = getRandomNumber();
    }

    public static Computer getInstance() {
        if (instance == null) {
            instance = new Computer();
        }
        return instance;
    }

    public String getNumber() {
        return number;
    }

    public void reset() {
        instance.number = getRandomNumber();
    }

    // 컴퓨터의 수를 랜덤으로 추출하는 기능
    private String getRandomNumber() {
        String computerNumber = "";
        List<Integer> alreadyPickNumber = new ArrayList<>();

        while (computerNumber.length() < 3) {
            computerNumber = computerNumber.concat(getOneNumber(alreadyPickNumber));
        }

        return computerNumber;
    }

    private String getOneNumber(List<Integer> alreadyPickNumber) {
        boolean check = true;
        int num = 0;

        while (check) {
            num = Randoms.pickNumberInRange(1,9);
            check = checkNumberAlreadyIn(num, alreadyPickNumber);
        }

        alreadyPickNumber.add(num);
        return String.valueOf(num);
    }

    private boolean checkNumberAlreadyIn(int num, List<Integer> alreadyPickNumber) {
        return alreadyPickNumber.contains(num);
    }
}
