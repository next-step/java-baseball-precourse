package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import nextstep.utils.Console;
import nextstep.utils.Randoms;

public class Baseball {
    public List<Integer> setRandomNums(int numCnt) {
        int startInclusive = 1, endInclusive = 9, randdomNum;
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
        return new ArrayList<>(Arrays.asList(Console.readLine().split("")));
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

    public int goOrStop() {
        int answer;

        while (true) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            try {
                answer = Integer.parseInt(Console.readLine());
            } catch (Exception e) {
                continue;
            }
            if (answer == 1 || answer == 2) {
                break;
            }
        }
        return answer;
    }
}
