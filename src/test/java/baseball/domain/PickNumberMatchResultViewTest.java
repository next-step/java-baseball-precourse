package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PickNumberMatchResultViewTest {

    @Test
    @DisplayName("매치결과 뷰 생성자는 카운트를 0으로 초기화 한다")
    void constructorTest() {
        PickNumberMatchResultView resultView = new PickNumberMatchResultView();
        assertThat(resultView.getBall()).isEqualTo(0);
        assertThat(resultView.getStrike()).isEqualTo(0);
    }

}