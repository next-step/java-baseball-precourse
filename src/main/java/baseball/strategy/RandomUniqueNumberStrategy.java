package baseball.strategy;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RandomUniqueNumberStrategy implements RandomNumberStrategy {

    // 싱글톤
    private static RandomUniqueNumberStrategy strategy
                = new RandomUniqueNumberStrategy();
    
    private RandomUniqueNumberStrategy() {}
    
    public static RandomUniqueNumberStrategy getInstance() {
        return strategy;
    }
    
    @Override
    public List<Integer> getRandomNumberList(final int min, final int max, final int count) {
        validateCount(min, max, count);
        List<Integer> numbers = new ArrayList<>();
        int randomNumber = 0;
        while(numbers.size() < count) {
            randomNumber = pickNumberInRange(min, max);
            if(numbers.contains(randomNumber)) continue;
            numbers.add(randomNumber);
        }
        return numbers;
    }

    private void validateCount(final int min, final int max, final int count) {
        if(count < 0) throw new IllegalArgumentException("랜덤수의 개수는 0보다 작을 수 없음");
        if(max - min + 1 < count) throw new IllegalArgumentException("랜덤 수의 범위보다 개수가 클 수 없음");
    }
}
