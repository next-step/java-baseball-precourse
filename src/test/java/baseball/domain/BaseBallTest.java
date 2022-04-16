package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

class BaseBallTest {
    @DisplayName("볼 개수를 적게 전달")
    @ParameterizedTest
    @ValueSource(strings = {"12", "23", "45", "98"})
    void lessBall(String numberString) {
        assertThatThrownBy(() -> new BaseBall(stringToIntegerList(numberString)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("볼 개수를 많게 전달")
    @ParameterizedTest
    @ValueSource(strings = {"1234", "2345", "4567", "9812"})
    void moreBall(String numberString) {
        assertThatThrownBy(() -> new BaseBall(stringToIntegerList(numberString)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("개수는 일치하지만 중복 숫자 있는 경우")
    @ParameterizedTest
    @ValueSource(strings = {"122", "233", "455", "991"})
    void duplicateBall(String numberString) {
        assertThatThrownBy(() -> new BaseBall(stringToIntegerList(numberString)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("생성 조건을 만족")
    @ParameterizedTest
    @ValueSource(strings = {"123", "234", "456", "981"})
    void equalsCondition(String numberString) {
        BaseBall baseBall = new BaseBall(stringToIntegerList(numberString));
        assertThat(baseBall.toString()).isEqualTo(numberString);
    }

    private List<Integer> stringToIntegerList(String numberString) {
        List<Integer> numbers = new ArrayList<>();
        for (String s: numberString.split("")) {
            numbers.add(Integer.parseInt(s));
        }
        return numbers;
    }

    @DisplayName("비교_낫싱")
    @ParameterizedTest
    @CsvSource(value = {"123,456", "456,789", "789,123"})
    void compare_nothing(String n1, String n2) {
        BaseBall cpu = new BaseBall(stringToIntegerList(n1));
        BaseBall user = new BaseBall(stringToIntegerList(n2));

        CompareResult compareResult = cpu.compare(user);

        assertThat(compareResult.isNothing()).isTrue();
    }

    @DisplayName("비교_3볼")
    @ParameterizedTest
    @CsvSource(value = {"123,231", "456,645", "789,978"})
    void compare_3ball(String n1, String n2) {
        BaseBall cpu = new BaseBall(stringToIntegerList(n1));
        BaseBall user = new BaseBall(stringToIntegerList(n2));

        CompareResult compareResult = cpu.compare(user);

        assertThat(compareResult.getBall()).isEqualTo(3);
        assertThat(compareResult.getStrike()).isEqualTo(0);
        assertThat(compareResult.isNothing()).isFalse();
    }

    @DisplayName("비교_3스트라이크")
    @ParameterizedTest
    @CsvSource(value = {"123,123", "456,456", "789,789"})
    void compare_3strike(String n1, String n2) {
        BaseBall cpu = new BaseBall(stringToIntegerList(n1));
        BaseBall user = new BaseBall(stringToIntegerList(n2));

        CompareResult compareResult = cpu.compare(user);

        assertThat(compareResult.getStrike()).isEqualTo(3);
        assertThat(compareResult.getBall()).isEqualTo(0);
        assertThat(compareResult.isNothing()).isFalse();
    }

    @DisplayName("비교_1스트라이크, 1볼")
    @ParameterizedTest
    @CsvSource(value = {"123,134", "456,467", "789,791"})
    void compare_1strike_1ball(String n1, String n2) {
        BaseBall cpu = new BaseBall(stringToIntegerList(n1));
        BaseBall user = new BaseBall(stringToIntegerList(n2));

        CompareResult compareResult = cpu.compare(user);

        assertThat(compareResult.getStrike()).isEqualTo(1);
        assertThat(compareResult.getBall()).isEqualTo(1);
        assertThat(compareResult.isNothing()).isFalse();
    }

    @DisplayName("비교_1스트라이크, 2볼")
    @ParameterizedTest
    @CsvSource(value = {"123,132", "456,465", "789,798"})
    void compare_1strike_2ball(String n1, String n2) {
        BaseBall cpu = new BaseBall(stringToIntegerList(n1));
        BaseBall user = new BaseBall(stringToIntegerList(n2));

        CompareResult compareResult = cpu.compare(user);

        assertThat(compareResult.getStrike()).isEqualTo(1);
        assertThat(compareResult.getBall()).isEqualTo(2);
        assertThat(compareResult.isNothing()).isFalse();
    }

    @DisplayName("컴퓨터 볼 생성")
    @Test
    void generateComputerBall() {
        try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
            mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(1, 5, 6);
            BaseBall baseBall = BaseBall.generateComputerBall();
            assertThat(baseBall.toString()).isEqualTo("156");
        }
    }

    @DisplayName("컴퓨터 볼 생성 (랜덤값 생성 중 중복이 등장한 경우)")
    @Test
    void generateComputerBall_random_dup() {
        try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
            mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(1, 5, 1, 1, 6);
            BaseBall baseBall = BaseBall.generateComputerBall();
            assertThat(baseBall.toString()).isEqualTo("156");
        }
    }
}