package baseball.domain;

import baseball.domain.exceptions.DuplicatedInputNumberException;
import baseball.domain.exceptions.InvalidInputNumberException;
import baseball.domain.utils.Numbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class NumbersTest {

    @Test
    void 랜덤_숫자_3개_생성() {

        Numbers numbers = new Numbers();

        Integer[] uniqueRandomNumbers = numbers.generate3RandomNumbers();
        assertTrue(uniqueRandomNumbers.length == 3);

    }

    @Test
    void 랜덤_숫자_3개_서로_다른값인지_확인() {

        Numbers numbers = new Numbers();
        Integer[] uniqueRandomNumbers = numbers.generate3RandomNumbers();
        assertNotEquals(uniqueRandomNumbers[0], uniqueRandomNumbers[1]);
        assertNotEquals(uniqueRandomNumbers[1], uniqueRandomNumbers[2]);
        assertNotEquals(uniqueRandomNumbers[2], uniqueRandomNumbers[0]);

    }

    @ParameterizedTest
    @CsvSource(value = {"123"})
    @DisplayName("입력된 값 3자리 정수 배열로 변환 ")
    void 배열_반환(String input) {
        Numbers numbers = new Numbers();

        Integer[] convertedToArray = numbers.getInputNumbersToArray(input);
        assertEquals(1, (int) convertedToArray[0]);
        assertEquals(2, (int) convertedToArray[1]);
        assertEquals(3, (int) convertedToArray[2]);

    }

    @ParameterizedTest
    @CsvSource(value = {"112"})
    @DisplayName("잘못 입력시 에러발생")
    void 중복_에러_처리(String input) {
        Numbers numbers = new Numbers();

        assertThrows(DuplicatedInputNumberException.class, () -> {
            numbers.getInputNumbersToArray(input);
        });

    }

    @ParameterizedTest
    @CsvSource(value = {"a"})
    @DisplayName("잘못 입력시 에러발생")
    void 유효한_값이_아닌_경우_에러_처리(String input) {
        Numbers numbers = new Numbers();

        assertThrows(InvalidInputNumberException.class, () -> {
            numbers.getInputNumbersToArray(input);
        });

    }
}
