package baseball.domain;

import baseball.domain.exceptions.BaseballIllegalArgumentException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static baseball.domain.BaseballNumber.MAX_VALUE;
import static baseball.domain.BaseballNumber.MIN_VALUE;
import static baseball.domain.ConsoleMessage.EXCEPTION_DUPLICATED_BASEBALL_NUMBERS;
import static baseball.domain.ConsoleMessage.EXCEPTION_INVALID_BASEBALL_NUMBERS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("야구 숫자 세트 테스트")
class BaseballNumbersTest {

    @Test
    @DisplayName("야구 숫자 세트 생성 성공")
    void init() {
        // when
        BaseballNumbers baseballNumbers = BaseballNumbers.of("123");

        // then
        assertThat(baseballNumbers.getBaseballNumbers()).containsExactly(
                new BaseballNumber(1), new BaseballNumber(2), new BaseballNumber(3)
        );
    }

    @ParameterizedTest(name = "{displayName} [input : {arguments}]")
    @ValueSource(strings = {"aaa", "2b3", "34c", "123456", "abcde"})
    @DisplayName("야구 숫자 세트 생성 실패 (잘못된 형식의 입력 값)")
    void initException(String input) {
        // when & then
        assertThatExceptionOfType(BaseballIllegalArgumentException.class)
                .isThrownBy(() -> BaseballNumbers.of(input))
                .withMessageMatching(EXCEPTION_INVALID_BASEBALL_NUMBERS.getMessage());
    }

    @ParameterizedTest(name = "{displayName} [input : {arguments}]")
    @ValueSource(strings = {"111", "226", "633"})
    @DisplayName("야구 숫자 세트 생성 실패 (중복된 숫자 포함)")
    void initException2(String input) {
        // when & then
        assertThatExceptionOfType(BaseballIllegalArgumentException.class)
                .isThrownBy(() -> BaseballNumbers.of(input))
                .withMessageMatching(EXCEPTION_DUPLICATED_BASEBALL_NUMBERS.getMessage());
    }

    @Test
    @DisplayName("임의의 서로 다른 숫자 3개를 생성")
    void generateRandomNumbers() {
        // when
        BaseballNumber[] baseballNumbers = BaseballNumbers.generateRandomNumbers().getBaseballNumbers();

        // then
        assertThat(baseballNumbers.length).isEqualTo(BaseballNumbers.SIZE);
        int value1 = baseballNumbers[0].getValue();
        int value2 = baseballNumbers[1].getValue();
        int value3 = baseballNumbers[2].getValue();
        assertAll(
                () -> assertThat(value1).isBetween(MIN_VALUE, MAX_VALUE),
                () -> assertThat(value2).isBetween(MIN_VALUE, MAX_VALUE),
                () -> assertThat(value3).isBetween(MIN_VALUE, MAX_VALUE),
                () -> assertThat((value1 != value2) && (value1 != value3) && (value2 != value3)).isTrue()
        );
    }

    @ParameterizedTest(name = "{displayName} [input : {arguments}]")
    @CsvSource(value = {"123:123:3:0", "236:456:1:0", "765:756:1:2", "123:456:0:0"}, delimiter = ':')
    @DisplayName("야구 점수 계산")
    void calculateScore(String computer, String player, int expectedStrikeCount, int expectedBallCount) {
        // given
        BaseballNumbers baseballNumbersOfComputer = BaseballNumbers.of(computer);
        BaseballNumbers baseballNumbersOfPlayer = BaseballNumbers.of(player);

        // when
        BaseballScore baseballScore = baseballNumbersOfComputer.calculateScore(baseballNumbersOfPlayer);
        System.out.println(baseballScore.toString());

        // then
        assertAll(
                () -> assertThat(baseballScore.getStrike()).isEqualTo(expectedStrikeCount),
                () -> assertThat(baseballScore.getBall()).isEqualTo(expectedBallCount)
        );
    }

    @ParameterizedTest(name = "{displayName} [input : {arguments}]")
    @CsvSource(value = {"123:123:true", "456:456:true",  "236:456:false", "765:567:false"}, delimiter = ':')
    @DisplayName("3Strike 이면 승리")
    void isWin(String computer, String player, boolean isWin) {
        // given
        BaseballNumbers baseballNumbersOfComputer = BaseballNumbers.of(computer);
        BaseballNumbers baseballNumbersOfPlayer = BaseballNumbers.of(player);

        // when
        BaseballScore baseballScore = baseballNumbersOfComputer.calculateScore(baseballNumbersOfPlayer);

        // then
        assertAll(
                () -> assertThat(baseballScore.isWin()).isEqualTo(isWin),
                () -> assertThat(baseballScore.isWin()).isEqualTo(isWin)
        );
    }

    @Test
    @DisplayName("임의의 서로 다른 숫자 3개를 재생성")
    void generateRandomNumbersOfRestart() {
        // when
        BaseballNumbers baseballNumbers = BaseballNumbers.generateRandomNumbers();
        baseballNumbers.generateRandomNumbersOfRestart();
        BaseballNumber[] baseballNumbersOfRestart = baseballNumbers.getBaseballNumbers();

        // then
        assertThat(baseballNumbersOfRestart.length).isEqualTo(BaseballNumbers.SIZE);
        int value1 = baseballNumbersOfRestart[0].getValue();
        int value2 = baseballNumbersOfRestart[1].getValue();
        int value3 = baseballNumbersOfRestart[2].getValue();
        assertAll(
                () -> assertThat(value1).isBetween(MIN_VALUE, MAX_VALUE),
                () -> assertThat(value2).isBetween(MIN_VALUE, MAX_VALUE),
                () -> assertThat(value3).isBetween(MIN_VALUE, MAX_VALUE),
                () -> assertThat((value1 != value2) && (value1 != value3) && (value2 != value3)).isTrue()
        );
    }
}