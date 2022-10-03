package baseball;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Fitch {

    List<Integer> fitches;

    public Fitch() {
        fitches = new ArrayList<>();

        while (fitches.size() != 3) {
            fitchAdd();
        }
    }

    private void fitchAdd() {
        int fitch = pickNumberInRange(1, 9);

        if (!fitches.contains(fitch)) {
            fitches.add(fitch);
        }
    }

    public List<Integer> getFitches() {
        return fitches;
    }

    public Map<String, Integer> countBallAndStrike(String inputNumbersString) {
        List<Integer> inputNumbers = numbersStringToIntegerList(inputNumbersString);
        Map<String, Integer> fitchResultMap = new HashMap<>();
        for (int i = 0; i < inputNumbers.size(); i++) {
            int fitch = inputNumbers.get(i);
            String fitchResultString = isBallStrikeNothing(fitch, i);
            Integer fitchCnt = fitchResultMap.getOrDefault(fitchResultString, 0);
            fitchResultMap.put(fitchResultString, fitchCnt + 1);
        }
        return fitchResultMap;
    }

    private List<Integer> numbersStringToIntegerList(String numbersString) {
        char[] inputNumbersCharArray = numbersString.toCharArray();
        List<Integer> integerList = new ArrayList<>();
        for (char numberChar : inputNumbersCharArray) {
            integerList.add(Character.getNumericValue(numberChar));
        }

        return integerList;
    }

    private String isBallStrikeNothing(int fitch, int index) {
        if (fitches.contains(fitch)) {
            return (fitches.indexOf(fitch) == index) ? "strike" : "ball";
        }
        return "nothing";
    }

    public void setTestFitches() {
        fitches.clear();

        fitches.add(4);
        fitches.add(1);
        fitches.add(8);
    }
}
