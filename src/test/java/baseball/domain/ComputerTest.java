package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Computer 클래스 테스트")
public class ComputerTest {
    private ArrayList<Integer> numbers;

    @BeforeEach
    public void init() {
        Computer computer = new Computer();
        Baseball baseball = computer.generateRandomNumbers();
        numbers = baseball.getBaseball();
    }

    @Test
    @DisplayName("generateRandomNumbers 메소드 테스트 - 숫자 길이 확인")
    public void testGenerateRandomNumbersLength() {
        assertThat(numbers).hasSize(3);
    }

    @Test
    @DisplayName("generateRandomNumbers 메소드 테스트 - 숫자 범위 확인")
    public void testGenerateRandomNumbersRange() {
        assertThat(numbers).allMatch(number -> number >= 1 && number <= 9);
    }

    @Test
    @DisplayName("generateRandomNumbers 메소드 테스트 - 숫자 중복 여부 확인")
    public void testGenerateRandomNumbersDuplicate() {
        assertThat(new HashSet<>(numbers)).hasSize(3);
    }
}
