package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BaseballNumbersTest {
    
    private List<BaseballNumber> baseballNumberList;

    @BeforeEach
    void setUp() {
        baseballNumberList = generateBaseballNumberList(BaseballNumbers.NUMBER_SIZE);
    }

    @Test
    @DisplayName("숫자 조합을 생성한다.")
    void new_baseballNumbers() {
        // when
        BaseballNumbers baseballNumbers = BaseballNumbers.of(baseballNumberList);
        
        // then
        assertThat(baseballNumbers.getNumber(1))
                .isEqualTo(baseballNumberList.get(1));
    }

    @Test
    @DisplayName("중복된 숫자가 존재할 경우 에러가 발생한다.")
    void validate_duplicateNumber_exception() {
        // when 
        baseballNumberList.set(1,baseballNumberList.get(0));
        
        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> BaseballNumbers.of(baseballNumberList))
                .withMessageMatching(
                        ErrorMessage.BASEBALL_NUMBER_DUPLICATE_ERROR.getMessage());
    }

    @ParameterizedTest(name = "size: {arguments}")
    @ValueSource(ints = {BaseballNumbers.NUMBER_SIZE - 1, BaseballNumbers.NUMBER_SIZE + 1})
    @DisplayName("잘못된 크기의 숫자 조합을 생성하면 에러가 발생한다.")
    void validate_worngNumberSize_exception(int size) {
        // when
        List<BaseballNumber> worngSizeList = generateBaseballNumberList(size);

        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> BaseballNumbers.of(worngSizeList))
                .withMessageMatching("숫자는 %d자리 조합만 허용됩니다.".replace("%d", "\\d+"));
    }

    private List<BaseballNumber> generateBaseballNumberList(int size) {
        List<BaseballNumber> result = new ArrayList<>();

        for (int i = 1; i <= size; i++) {
            result.add(BaseballNumber.from(i));
        }

        return result;
    }
}
