package baseball.model;

import baseball.view.InputView;
import nextstep.utils.Randoms;

import java.util.*;

public class Numbers {
    private List<Integer> userInputNumber;
    private List<Integer> generateComputeNumber;

    public List<Integer> getUserInputNumber() {
        return userInputNumber;
    }

    public List<Integer> getGenerateComputeNumber() {
        return generateComputeNumber;
    }

    public void generateNumber() {
//        순서보장를 보장해주는 Set = LinkedHashSet
        Set<Integer> numberSet = new LinkedHashSet<>();
        while (numberSet.size() < 3) {
            numberSet.add(Randoms.pickNumberInRange(1, 9));
        }
        this.generateComputeNumber = new ArrayList<>(numberSet);
    }

    public void inputNumber() {
        String[] inputArr = new InputView().InputNumberFromUser();
        userInputNumber = new ArrayList<>();
        for (String s: inputArr) {
            userInputNumber.add(Integer.valueOf(s));
        }
    }

}
