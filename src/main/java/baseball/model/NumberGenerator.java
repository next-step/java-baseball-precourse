package baseball.model;

import java.util.Map;

/**
 * 숫자 생성기
 * 확장성을 위해 숫자 생성기 interface 생성
 */
public interface NumberGenerator {

    /**
     * 원하는 자리수의 숫자 생성
     * @param numberControl 숫자 생성기 사용시 필요한 설정값
     * @return 생성된 숫자
     */
    Map<Integer, Integer> generateNumber(final NumberControl numberControl);
}
