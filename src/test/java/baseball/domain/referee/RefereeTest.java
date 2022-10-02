package baseball.domain.referee;

import baseball.domain.number.BaseballNumber;
import baseball.domain.number.BaseballNumbers;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RefereeTest {
    private BaseballNumbers computerNumbers;

    @BeforeEach
    void setUp() {
        this.computerNumbers = createBaseballNumbers(1, 2, 3);
    }

    @Test
    @DisplayName("3 스트라이크 : 123, 123 비교")
    void judgeTest1() {
        // given
        BaseballNumbers userNumbers = createBaseballNumbers(1, 2, 3);

        // when
        Referee referee = Referee.create();
        referee.judge(computerNumbers, userNumbers);

        // then
        Hint hint = referee.getHint();
        Assertions.assertThat(hint).isEqualTo(Hint.of(3, 0));
    }

    @Test
    @DisplayName("2 스트라이크 : 123, 124 비교")
    void judgeTest2() {
        // given
        BaseballNumbers userNumbers = createBaseballNumbers(1, 2, 4);

        // when
        Referee referee = Referee.create();
        referee.judge(computerNumbers, userNumbers);

        // then
        Hint hint = referee.getHint();
        Assertions.assertThat(hint).isEqualTo(Hint.of(2, 0));
    }

    @Test
    @DisplayName("1 스트라이크 2볼 : 123, 132 비교")
    void judgeTest3() {
        // given
        BaseballNumbers userNumbers = createBaseballNumbers(1, 3, 2);

        // when
        Referee referee = Referee.create();
        referee.judge(computerNumbers, userNumbers);

        // then
        Hint hint = referee.getHint();
        Assertions.assertThat(hint).isEqualTo(Hint.of(1, 2));
    }

    @Test
    @DisplayName("1 스트라이크 1볼 : 123, 134 비교")
    void judgeTest4() {
        // given
        BaseballNumbers userNumbers = createBaseballNumbers(1, 3, 4);

        // when
        Referee referee = Referee.create();
        referee.judge(computerNumbers, userNumbers);

        // then
        Hint hint = referee.getHint();
        Assertions.assertThat(hint).isEqualTo(Hint.of(1, 1));
    }

    @Test
    @DisplayName("1 스트라이크 : 123, 145 비교")
    void judgeTest5() {
        // given
        BaseballNumbers userNumbers = createBaseballNumbers(1, 4, 5);

        // when
        Referee referee = Referee.create();
        referee.judge(computerNumbers, userNumbers);

        // then
        Hint hint = referee.getHint();
        Assertions.assertThat(hint).isEqualTo(Hint.of(1, 0));
    }

    @Test
    @DisplayName("1 볼 : 123, 451 비교")
    void judgeTest6() {
        // given
        BaseballNumbers userNumbers = createBaseballNumbers(4, 5, 1);

        // when
        Referee referee = Referee.create();
        referee.judge(computerNumbers, userNumbers);

        // then
        Hint hint = referee.getHint();
        Assertions.assertThat(hint).isEqualTo(Hint.of(0, 1));
    }

    @Test
    @DisplayName("2 볼 : 123, 251 비교")
    void judgeTest7() {
        // given
        BaseballNumbers userNumbers = createBaseballNumbers(2, 5, 1);

        // when
        Referee referee = Referee.create();
        referee.judge(computerNumbers, userNumbers);

        // then
        Hint hint = referee.getHint();
        Assertions.assertThat(hint).isEqualTo(Hint.of(0, 2));
    }

    @Test
    @DisplayName("3 볼 : 123, 231 비교")
    void judgeTest8() {
        // given
        BaseballNumbers userNumbers = createBaseballNumbers(2, 3, 1);

        // when
        Referee referee = Referee.create();
        referee.judge(computerNumbers, userNumbers);

        // then
        Hint hint = referee.getHint();
        Assertions.assertThat(hint).isEqualTo(Hint.of(0, 3));
    }

    @Test
    @DisplayName("낫싱 : 123, 456 비교")
    void judgeTest9() {
        // given
        BaseballNumbers userNumbers = createBaseballNumbers(4, 5, 6);

        // when
        Referee referee = Referee.create();
        referee.judge(computerNumbers, userNumbers);

        // then
        Hint hint = referee.getHint();
        Assertions.assertThat(hint).isEqualTo(Hint.of(0, 0));
    }

    private BaseballNumbers createBaseballNumbers(int num1, int num2, int num3) {
        List<BaseballNumber> numberValues = new ArrayList<>();
        numberValues.add(BaseballNumber.from(num1));
        numberValues.add(BaseballNumber.from(num2));
        numberValues.add(BaseballNumber.from(num3));
        return BaseballNumbers.from(numberValues);
    }
}