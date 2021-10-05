package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PickNumberMatchResultViewTest {

    @Test
    @DisplayName("매치결과 뷰 생성자는 카운트를 0으로 초기화 한다")
    void constructorTest() {
        PickNumberMatchResultView resultView = new PickNumberMatchResultView();
        assertThat(resultView.getBall()).isEqualTo(0);
        assertThat(resultView.getStrike()).isEqualTo(0);
    }

    @Test
    @DisplayName("매치결과에 따라 카운트가 증가한다")
    void increaseCountTest() {
        PickNumberMatchResultView resultView = new PickNumberMatchResultView();

        resultView.addStrikeCount();
        resultView.addBallCount();
        resultView.addBallCount();

        assertThat(resultView.getBall()).isEqualTo(2);
        assertThat(resultView.getStrike()).isEqualTo(1);
    }

    @DisplayName("매치결과를 출력한다")
    @ParameterizedTest(name = "{2}")
    @CsvSource(value = {"3:0:3스트라이크", "1:2:1스트라이크 2볼", "0:3:3볼"}, delimiter = ':')
    void resultViewToStringTest(int strike, int ball, String result) {
        PickNumberMatchResultView resultView = new PickNumberMatchResultView();

        for (int i = 0; i < strike; i++) {
            resultView.addStrikeCount();
        }

        for (int i = 0; i < ball; i++) {
            resultView.addBallCount();
        }

        assertThat(resultView.getStrike()).isEqualTo(strike);
        assertThat(resultView.getBall()).isEqualTo(ball);
        assertThat(resultView.toString()).isEqualTo(result);
    }

    @Test
    @DisplayName("매치되는 값이 없을경우 - 낫싱")
    void noMatchResultTest() {
        PickNumberMatchResultView resultView = new PickNumberMatchResultView();
        if (resultView.getBall() == 0 && resultView.getStrike() == 0) {
            assertThat(resultView.toString()).isEqualTo(GameMessage.NOTHING.getMsg());
        }
        resultView.addBallCount();
        assertThat(resultView.toString()).isNotEqualTo(GameMessage.NOTHING.getMsg());
    }
}