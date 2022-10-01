package baseball.domain;

import baseball.domain.exceptions.BaseballIllegalArgumentException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static baseball.domain.ConsoleMessage.EXCEPTION_OUT_OF_BOUNDS_BASEBALL_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@DisplayName("야구 숫자 테스트")
class BaseballNumberTest {

    @ParameterizedTest(name = "{displayName} [input : {arguments}]")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    @DisplayName("야구 숫자 생성 성공")
    void init(int input) {
        // when
        BaseballNumber baseballNumber = new BaseballNumber(input);

        // then
        assertThat(baseballNumber.getValue()).isEqualTo(input);
    }

    @ParameterizedTest(name = "{displayName} [input : {arguments}]")
    @ValueSource(ints = {0, 10})
    @DisplayName("야구 숫자 생성 실패 (제한 범위 초과)")
    void initException(int input) {
        // when & then
        assertThatExceptionOfType(BaseballIllegalArgumentException.class)
                .isThrownBy(() -> new BaseballNumber(input))
                .withMessageMatching(EXCEPTION_OUT_OF_BOUNDS_BASEBALL_NUMBER.getMessage()
                        .replace("%d", "\\d+"));
    }
}