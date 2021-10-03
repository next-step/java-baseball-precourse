package baseball;

import nextstep.utils.Randoms;

import java.util.HashMap;
import java.util.Map;

public class Baseball {
    public static final int N = 3; // 게임 총 자리수
    public static final int START_INCLUSIVE = 1; // 새로 생성하는 랜덤 숫자의 최소 숫자
    public static final int END_INCLUSIVE = 9; // 새로 생성하는 랜덤 숫자의 최대 숫자

    private int answer;
    private Map<Integer, Integer> answerPositionMap;

    public Baseball() {}

    // 정답을 임의로 정하는 함수
    public void generateAnswer(Integer number) {
        assert number != null;

        Map<Integer, Integer> map = getPositionMap(number);
        if (map.size() != N) {
            throw new RuntimeException("각 자리의 숫자 중 같은 숫자가 존재");
        }
        answerPositionMap = map;
        answer = number;
    }

    // 정답을 랜덤하게 정하는 함수
    public void generateAnswer() {
        answerPositionMap = new HashMap<>();
        int position = 1;
        int result = 0;
        while (answerPositionMap.size() != N) {
            int newNumber = generateNewNumber(answerPositionMap);
            answerPositionMap.put(newNumber, position++);
            result = result * 10 + newNumber;
        }
        answer = result;
    }

    // 매개변수 map의 key 값에 존재하지 않는 숫자를 랜덤으로 골라 반환하는 함수
    private int generateNewNumber(Map<Integer, Integer> map) {

        int newNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
        if (map.containsKey(newNumber)) {
            newNumber = generateNewNumber(map);
        }
        return newNumber;
    }

    // 매개변수 number의 각 숫자들의 위치 정보를 가지는 map을 반환하는 함수
    private Map<Integer, Integer> getPositionMap(int number) {
        Map<Integer, Integer> positionMap = new HashMap<>();
        int position = (int) (Math.log10(number) + 1);
        while (number != 0) {
            int n = number % 10;
            positionMap.put(n, position--);
            number /= 10;
        }
        return positionMap;
    }

    public int getAnswer() {
        return answer;
    }
}
