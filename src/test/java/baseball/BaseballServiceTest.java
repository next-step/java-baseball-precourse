package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class BaseballServiceTest {

    private final BaseballService baseballService = new BaseballService();

    @Test
    void 숫자로_이루어져있지_않으면_잘못된_값() {
        assertSimpleTest(() -> assertThatThrownBy(() -> baseballService.validateNumber("-12")).isInstanceOf(
                IllegalArgumentException.class));
    }

    @Test
    void 입력이_3글자가_아니면_잘못된_값() {
        assertSimpleTest(() -> assertThatThrownBy(() -> baseballService.validateNumber("1234")).isInstanceOf(
                IllegalArgumentException.class));
    }

    @Test
    void zero_포함되어_있으면_잘못된_값() {
        assertSimpleTest(() -> assertThatThrownBy(() -> baseballService.validateNumber("102")).isInstanceOf(
                IllegalArgumentException.class));
    }

    @Test
    void 숫자가_중복되면_잘못된_값() {
        assertSimpleTest(() -> assertThatThrownBy(() -> baseballService.validateNumber("119")).isInstanceOf(
                IllegalArgumentException.class));
    }

    @Test
    void 정답_숫자가_올바른지_테스트() {
        String answer = baseballService.generateRandomThreeDigitNumber();
        assertSimpleTest(() -> assertThatCode(() -> baseballService.validateNumber(answer)).doesNotThrowAnyException());
    }

    @Test
    void 점수계산_2볼_1스트라이크_테스트() {
        Score score = baseballService.countScore("123", "321");
        Score expected = new Score(2, 1);
        assertThat(score).isEqualTo(expected);
    }

    @Test
    void 점수계산_3스트라이크_테스트() {
        Score score = baseballService.countScore("123", "123");
        Score expected = new Score(0, 3);
        assertThat(score).isEqualTo(expected);
    }

    @Test
    void 점수계산_0볼_0스트라이크_테스트() {
        Score score = baseballService.countScore("123", "456");
        Score expected = new Score(0, 0);
        assertThat(score).isEqualTo(expected);
    }

    @Test
    void 게임종료_3스트라이크면_TRUE() {
        Score score = new Score(0, 3);
        assertThat(baseballService.isGameEnded(score)).isTrue();
    }

    @Test
    void 게임종료_2볼_1스트라이크면_FALSE() {
        Score score = new Score(2, 1);
        assertThat(baseballService.isGameEnded(score)).isFalse();
    }
}
