package baseball;

import nextstep.utils.Randoms;

import java.util.Arrays;
import java.util.List;

/**
 * Name : RandomNumberGenerator <br/>
 * Description : 랜덤 숫자 3자리를 생성하는 객체
 */
public class RandomNumberGenerator {
    private final int maxLength;

    public RandomNumberGenerator(int maxLength) {
        this.maxLength = maxLength;
    }

    /**
     * 1~9까지 서로 다른 수로 이루어진 3자리 수를 생성하는 메소드
     */
    public String generateNumbers() {
        List<Integer> baseNumbers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        StringBuilder numbers = new StringBuilder();

        for (int i=1; i<= maxLength ; i++){
            setNumbers(baseNumbers, numbers);
        }
        return numbers.toString();
    }

    /**
     * 1-9까지 임의이 수 중, 중복을 제거하여, 값을 설정하는 메소드
     */
    private void setNumbers(List<Integer> baseNumbers, StringBuilder numbers) {
        int randomNumber = Randoms.pickNumberInRange(1, 9);

        if (baseNumbers.get(randomNumber) == randomNumber) {
            numbers.append(randomNumber);
            baseNumbers.set(randomNumber, 0);
            return;
        }
        setNumbers(baseNumbers, numbers);
    }
}
