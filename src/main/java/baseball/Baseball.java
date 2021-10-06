package baseball;

import java.util.ArrayList;
import java.util.List;

import nextstep.utils.Console;
import nextstep.utils.Randoms;

public class Baseball {
    public List<Integer> setRandomNums(int numCnt) {
        int startInclusive = 1, endInclusive = 9, randdomNum = 0;
        List<Integer> randomNums = new ArrayList<>();

        while (true) {
            if (randomNums.size() == numCnt) {
                break;
            }
            randdomNum = Randoms.pickNumberInRange(startInclusive, endInclusive);
            if (randomNums.contains(randdomNum)) {
                continue;
            }
            randomNums.add(randdomNum);
        }
        return randomNums;
    }

    private List<String> setUserInput() {
        List<String> userNums = new ArrayList<>();
        for (String numStr : Console.readLine().split("")) {
            userNums.add(numStr);
        }
        return userNums;
    }

    public void runBaseBallGeme(int numCnt, List<Integer> randomNums) {
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            Score score = new Score(setUserInput(), randomNums);
            if (!score.isCorrectNums()) {
                score.printErrorMsgs();
                continue;
            }
            score.printResult();
            if (score.isSuccess()) {
                break;
            }
        }
    }
}
