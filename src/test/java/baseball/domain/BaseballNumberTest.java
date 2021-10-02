package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("숫자야구 Domain Test")
class BaseballNumberTest {

    @DisplayName("랜덤 숫자 생성(숫자야구 생성자) Test")
    @RepeatedTest(10)
    public void BaseBallNumberTest() {
        BaseballNumber baseballNumber = new BaseballNumber();
        for (int i = 0; i < 3; i++) {
            assertTrue(baseballNumber.getValueByIndex(i) < 10 && baseballNumber.getValueByIndex(i) > 0);
        }
        assertTrue(baseballNumber.getValueByIndex(0) != baseballNumber.getValueByIndex(1));
        assertTrue(baseballNumber.getValueByIndex(0) != baseballNumber.getValueByIndex(2));
        assertTrue(baseballNumber.getValueByIndex(1) != baseballNumber.getValueByIndex(2));
    }

}