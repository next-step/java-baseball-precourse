package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnswerNumbersTest {
    @Test
    @DisplayName("올바른 게임 정답 숫자가 생성된다.")
    void create_success_if_correct_answer_numbers() {
        var answerNumbers = List.of(1, 2, 3);

        assertDoesNotThrow(() -> AnswerNumbers.from(answerNumbers));
    }

    @Test
    @DisplayName("게임 정답 숫자 개수가 올바르지 않다면, 예외를 던진다.")
    void create_fail_if_wrong_answer_numbers_size() {
        var overSizeAnswerNumbers = List.of(1, 2, 3, 4);

        assertThrows(Exception.class, () -> AnswerNumbers.from(overSizeAnswerNumbers));
    }

    @Test
    @DisplayName("게임 정답 숫자에 중복이 존재하면, 예외를 던진다.")
    void create_fail_if_answer_numbers_has_duplication() {
        var duplicationAnswerNumbers = List.of(1, 1, 9);

        assertThrows(Exception.class, () -> AnswerNumbers.from(duplicationAnswerNumbers));
    }
}
