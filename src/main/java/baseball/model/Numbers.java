package baseball.model;

import baseball.view.InputView;
import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        Set<Integer> numberSet = new HashSet<>();

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
