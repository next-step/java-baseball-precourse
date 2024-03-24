package model;

import exception.GameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static model.BaseballNumber.VALID_LENGTH;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballNumberTest {

    @DisplayName("각 자릿수가 서로 다른 숫자로 생성할 수 있다.")
    @Test
    void createWithInteger() {
        // given
        int num = 123;

        // when, then
        BaseballNumber baseballNumber = BaseballNumber.of(num);
    }

    @ValueSource(ints = {-1, 1})
    @DisplayName("VALID_LENGTH와 다른 길이의 숫자로 생성할 경우 예외가 발생한다.")
    @ParameterizedTest(name = "{displayName} [{arguments}]")
    void createWithInvalidLength_throwsException(int lengthDiff) {
        // given
        int newLength = VALID_LENGTH + lengthDiff;
        int num = 0;
        for (int i = 1; i <= newLength; i++) {
            num *= 10;
            num += i;
        }
        System.out.println(num);

        // when, then
        int finalNum = num;
        assertThatThrownBy(() -> BaseballNumber.of(finalNum))
                .isInstanceOf(GameException.class);
    }
}