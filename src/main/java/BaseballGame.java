import util.RandomGenerator;
import view.InputView;
import view.OutputView;

import java.util.*;

public class BaseballGame {
    private static final int NUM_OF_DIGIT = 3;

    public static void main(String[] args) {
        // 1. 랜덤 세자리 수 생성
        final List<Integer> answer = RandomGenerator.generateRandomNumber(NUM_OF_DIGIT);

        Map<Integer, Integer> numberMap = new HashMap<>();
        for (int i=0; i<answer.size(); i++) {
            numberMap.put(answer.get(i), i);
        }

        while (true) {
            // 2. 사용자 입력
            OutputView.printInfo();
            String number = InputView.getNumber();

            // 3. 게임 종료 여부 판단
            if (Integer.parseInt(number) == answer.get(0) * 100 + answer.get(1) * 10 + answer.get(2)) {
               OutputView.printEnding();
                break;
            }

            // 4. 일치하는 숫자 판단 <스트라이크, 볼>
            int[] count = new int[2];
            for (int i=0; i<3; i++) {
                int inputNum = Character.getNumericValue(number.charAt(i));

                // 숫자가 포함되어 있다.
                if (numberMap.containsKey(inputNum)) {
                    // 자리가 동일하다.
                    if (numberMap.get(inputNum) == i) {
                        count[0] += 1;
                        continue;
                    }

                    count[1] += 1;
                }
            }

            // 5. 힌트 출력
            OutputView.printHint(count[0], count[1]);
        }
    }
}
