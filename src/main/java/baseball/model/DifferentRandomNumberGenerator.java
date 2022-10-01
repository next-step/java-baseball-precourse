package baseball.model;

import java.util.HashMap;
import java.util.Map;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

/**
 * 각 자리수가 서로 다른 무작위(random) 숫자 생성기
 */
public class DifferentRandomNumberGenerator implements NumberGenerator {

    private final Map<Integer, Integer> generateNumber = new HashMap<>(); // 각 자리수가 서로 달라야 하므로 List가 아닌 Map 사용 (key: 숫자, value: 해당 숫자가 존재하는 자리)

    public DifferentRandomNumberGenerator() {
    }

    @Override
    public Map<Integer, Integer> generateNumber(NumberControl numberControl) {
        while(generateNumber.size() < numberControl.getNumberTotalLength()) {
            int number = pickNumberInRange(numberControl.getStartInclusive(), numberControl.getEndInclusive());
            generateNumber.putIfAbsent(number, generateNumber.size() + 1);
        }
        return generateNumber;
    }
}
