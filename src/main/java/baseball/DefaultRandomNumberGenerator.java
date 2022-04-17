package baseball;


import java.util.*;

/**
 * 서로 다른 난수 numberOfRandomNumber 개를 생성하는 클래스.
 */
public class DefaultRandomNumberGenerator implements RandomNumberGenerator {
    private final int numberOfRandomNumber;

    public DefaultRandomNumberGenerator(int numberOfRandomNumber) {
        this.numberOfRandomNumber = numberOfRandomNumber;
    }

    /**
     * numberOfRandomNumber 만큼의 1~9까지의 서로 다른 수를 리턴합니다.
     */
    @Override
    public List<Integer> generate() {
        final Set<Integer> randomNumberSet = new HashSet<>();
        while(randomNumberSet.size() < numberOfRandomNumber) {
            randomNumberSet.add(camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(1, 9));
        }
        
        return new ArrayList<>(randomNumberSet);
    }
}
