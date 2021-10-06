package baseball.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static baseball.service.AnswerMaker.isValid;
import static org.assertj.core.api.Assertions.assertThat;

public class AnswerMakerTest {

    @Test
    @DisplayName("제약사항 만족하는 answer 문자열 생성 검증")
    void 정답_생성_유효성_테스트() {
        List<String> answers = new ArrayList<>();
        for (int i=0; i<1000; i++) {
            answers.add(AnswerMaker.make());
        }
        assertThat(answers)
          .allMatch(answer -> isValid(answer));
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "12a", "ab2", "가나1", "", "  "})
    @DisplayName("answer는 문자가 있을 수 없음")
    void 정답_문자_포함_시_unvalid_테스트(String answer) {
        assertThat(isValid(answer)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"12", "1", "1234", "12513324123", "", " "})
    @DisplayName("answer는 3개의 숫자로 이루어져야 함")
    void 정답_숫자_3개_아닐_시_unvalid_테스트(String answer) {
        assertThat(isValid(answer)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"111", "112", "101", "012", "000", "001", "100"})
    @DisplayName("answer는 3개의 중복되지 않는, 0을 제외한 숫자로 이루어져야 함")
    void 정답_ZERO_또는_중복_포함_시_unvalid_테스트(String answer) {

        assertThat(isValid(answer)).isFalse();
    }
}
